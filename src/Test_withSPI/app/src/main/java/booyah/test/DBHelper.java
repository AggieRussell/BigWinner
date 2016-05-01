package booyah.test;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "NFLStats.db";

    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = getReadableDatabase();
        db.close();
        // you can use an alternate constructor to specify a database location
        // (such as a folder on the sd card)
        // you must ensure that this folder is available and you have permission
        // to write to it
        //super(context, DATABASE_NAME, context.getExternalFilesDir(null).getAbsolutePath(), null, DATABASE_VERSION);

    }

    public ArrayList<Column> getGames(int year, int week) {
        //set up query
        String tableName = "Season" + Integer.toString(year);
        String queryString = "SELECT * FROM " + tableName + " WHERE week = ?";
        String[] args = {Integer.toString(week)};

        //set up db to read
        SQLiteDatabase db = getReadableDatabase();
        Cursor dbCursor = db.rawQuery(queryString, args);

        //Set up List and fill up column names
        ArrayList<Column> allGames = new ArrayList<Column>();
        String[] colNames = dbCursor.getColumnNames();
        for(int k = 0; k < colNames.length; ++k){
            allGames.add(new Column(colNames[k]));

            //Debug
            Log.d("Check Col Names", colNames[k]);
        }

        //begin reading
        if(dbCursor.moveToFirst()){
            while(dbCursor.isAfterLast() == false){
                for(int i = 0; i < dbCursor.getColumnCount(); ++i){
                    String s = dbCursor.getString(i);   //read value
                    allGames.get(i).addValue(s);        //add to column
                }
                dbCursor.moveToNext();
            }
        }
        else{
            //fail condition?
            Log.d("Failure Tag", "Fail to move cursor #2!!!");
        }

        dbCursor.close();

        //Check output
        String check = "";
        int checkList = allGames.get(0).getCol().size();
        for(int l = 0; l < checkList; ++l){

            for(int m = 0; m < allGames.size(); ++m){
                check = check + (String)allGames.get(m).getValue(l) + " ";
            }
            check = check + "\n";
        }
        Log.d("Correct Array?", check);

        return allGames;

    }

    public ArrayList<Column> getScores(){
        //set up query
        String queryString = "SELECT * FROM Scores";

        //set up db to read
        SQLiteDatabase db = getReadableDatabase();
        Cursor dbCursor = db.rawQuery(queryString, null);

        //fill column names
        ArrayList<Column> scores = new ArrayList<Column>();
        String[] colNames = dbCursor.getColumnNames();
        for(int k = 0; k < colNames.length; ++k){
            scores.add(new Column(colNames[k]));

            //Debug
            Log.d("Check Col Names", colNames[k]);
        }

        //begin reading
        if(dbCursor.moveToFirst()){
            while(dbCursor.isAfterLast() == false){
                for(int i = 0; i < dbCursor.getColumnCount(); ++i){
                    String s = dbCursor.getString(i);   //read value
                    scores.get(i).addValue(s);        //add to column
                }
                dbCursor.moveToNext();
            }
        }
        else{
            //fail condition?
            Log.d("Failure Tag", "Fail to move cursor #2!!!");
        }

        //make years human read-able
        int years = scores.get(0).size();
        Log.d("Year Value", Integer.toString(years));
        for(int j = 0; j < years; ++j){
            scores.get(0).changeValue(j, "201" + (String)scores.get(0).getValue(j));
            Log.d("Check Year", (String)scores.get(0).getValue(j));
        }

        dbCursor.close();
        //Check output
        String check = "";
        int checkList = scores.get(0).getCol().size();
        for(int l = 0; l < checkList; ++l){

            for(int m = 0; m < scores.size(); ++m){
                check = check + (String)scores.get(m).getValue(l) + " ";
            }
            check = check + "\n";
        }
        Log.d("Correct Array?", check);


        return scores;
    }

    public void updateScore(int year, double score){
        //query
        String updateRecent = "UPDATE Scores SET Recent = ? WHERE Year = ?";
        String updateTop = "UPDATE Scores SET Top = ? WHERE Year = ?";
        String[] argsRecent = {Double.toString(score),  Integer.toString(year%2010)};
        String[] argsTop = {Double.toString(score),Integer.toString(year%2010)};
        //set up database for writing
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(updateRecent, argsRecent);


        //fill column names
        ArrayList<Column> scores;
        scores = getScores();
        String currentTop = (String)scores.get(1).getValue((year%2010)-1);
        if(currentTop.equals("--"))
            db.execSQL(updateTop, argsTop);
        else if(Double.parseDouble(currentTop) < score)
            db.execSQL(updateTop, argsTop);


    }

    public void clearScores(){
        //query
        String updateRecent = "UPDATE Scores SET Recent = ?";
        String updateTop = "UPDATE Scores SET Top = ?";
        String[] args = {"--"};

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(updateRecent, args);
        db.execSQL(updateTop, args);
    }
}