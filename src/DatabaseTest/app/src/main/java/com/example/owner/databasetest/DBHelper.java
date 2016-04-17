package com.example.owner.databasetest;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 4/15/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/com.example.ownder.databasetest/databases";
    private static final int version = 1;
    private static final String name = "NFL";
    private SQLiteDatabase myDb;
    private static final String[] COLUMNS = {"Week", "Home", "Away", "HomeScore", "AwayScore", "TPYA", "TDPYA", "APYA", "ADPYA"};


    public DBHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //do nothing
        String myPath = DB_PATH + name;
        myDb = SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //do nothing
    }

    public void close(){
        if (myDb != null)
            myDb.close();
        super.close();
    }

    /*public void select(String tableYear, int week){
        String table = tableYear + "Season";
        List<Column> cols = new ArrayList<Column>();

        try{
            for(int i = 0; i < COLUMNS.length; ++i){
                Column temp = new Column();
            }
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = myDb.query(table, //table
                    COLUMNS,//column names
                    " Week = ?", // c. selections
                    new String[] { String.valueOf(week) }, // d. selections args
                    null, // e. group by
                    null, // f. having
                    null, // g. order by
                    null); // h. limit)
            if (cursor != null)
                cursor.moveToFirst();
            do{

            }while(cursor.moveToNext());
        }
        catch(SQLiteException e) {
            System.out.println("Database does not exist");
        }
    }*/

    public /*List<Column>*/ Cursor select(String tableYear, int week){
        List<Column> cols = new ArrayList<Column>();
        String tableName = tableYear + "Season";
        for(int i = 0; i < COLUMNS.length; ++i){
            String coltype = null;
            if(COLUMNS[i] == "Week" || COLUMNS[i] == "HomeScore" || COLUMNS[i] == "AwayScore")
                coltype = "INT";
            else if(COLUMNS[i] == "Home" || COLUMNS[i] == "Away")
                coltype = "VARCHAR(10)";
            else
                coltype = "VARCHAR(4)";

            Column temp = new Column(COLUMNS[i], coltype);
            cols.add(temp);
        }
        Cursor cursor = null;
        try{
            // 1. build the query
            String query = "SELECT  * FROM " + tableName + " WHERE Week=" + week;

            // 2. get reference to writable DB
            SQLiteDatabase db = this.getReadableDatabase();
            cursor = db.rawQuery(query, null);

            // 3. go over each row, build book and add it to list

       /*     if (cursor.moveToFirst()) {
                do {
                    cols.get(0).addValue(Integer.parseInt(cursor.getString(0)));
                    cols.get(1).addValue(cursor.getString(1));
                    cols.get(2).addValue(cursor.getString(2));
                    cols.get(3).addValue(Integer.parseInt(cursor.getString(3)));
                    cols.get(4).addValue(Integer.parseInt(cursor.getString(4)));
                    cols.get(5).addValue(cursor.getString(5));
                    cols.get(6).addValue(cursor.getString(6));
                    cols.get(7).addValue(cursor.getString(7));
                    cols.get(8).addValue(cursor.getString(8));

                } while (cursor.moveToNext());
            }
*/


            // return books
            System.out.println("here?");
        }
        catch(SQLiteException e) {
            System.out.println("Database does not exist");

        }
        return cursor;
    }
}
