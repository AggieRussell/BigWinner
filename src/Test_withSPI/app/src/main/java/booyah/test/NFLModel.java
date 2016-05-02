package booyah.test;

/**
 * Created by Christine Russell on 4/16/16.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.*;
import android.app.Activity;
import android.app.Application;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.content.res.AssetManager;


import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import static java.lang.System.out;

public class NFLModel{

    private String user;
    private String season;
    private ArrayList<String> home = new ArrayList<String>();
    private ArrayList<String> away = new ArrayList<String>();
    private ArrayList<String> winners = new ArrayList<String>();
    private ArrayList<String> predictions = new ArrayList<>();
    private double numCorrect;
    private double numCorrectPredicted;
    private double numGames;
    //   ArrayList<ArrayList<String>> weekList = new ArrayList<ArrayList<String>>();

    public NFLModel() {
        user = ".";
        season = ".";
        out.printf("user: %s\nseason: %s\n", user, season);
    }

    public NFLModel(String u, String s) {
        setUser(u);
        setSeason(s);
        out.printf("user: %s\nseason: %s\n", user, season);
    }

    public void setUser(String u) {
        user = u;
        out.println("model user set");
    }

    public void setSeason(String s){
        season = s;
        out.println("model season set");
    }

    public String getUser() {
        return user;
    }

    public String getSeason() {
        return season;
    }

    public void resetGames() {
        home.clear();
        away.clear();
        winners.clear();
    }

    public void resetSeason() {
        user = ".";
        season = ".";
        numCorrect = 0;
        numGames = 0;
    }

    public void setGames(DBHelper db, int week) {
        int yearNum = Integer.parseInt(season);

        ArrayList<Column> weekSchedule = db.getGames(yearNum, week);
        for(int i=0; i<weekSchedule.get(0).size(); ++i) {
            String homeTeam = (String) weekSchedule.get(2).getCol().get(i);
            String awayTeam = (String) weekSchedule.get(3).getCol().get(i);
            home.add(homeTeam);
            away.add(awayTeam);
        }
    }

    public ArrayList<String> getHome() {
        return home;
    }

    public ArrayList<String> getAway() { return away; }

    public ArrayList<String> getWinners(DBHelper db, int week) {
        winners.clear();
        int yearNum = Integer.parseInt(season);

        ArrayList<Column> weekSchedule = db.getGames(yearNum, week);
        for(int i=0; i<weekSchedule.get(0).size(); ++i) {
            int homeTeamScore = Integer.parseInt((String)weekSchedule.get(4).getCol().get(i));
            int awayTeamScore = Integer.parseInt((String)weekSchedule.get(5).getCol().get(i));
            if(homeTeamScore > awayTeamScore)
                winners.add((String) weekSchedule.get(2).getCol().get(i));
            else winners.add((String) weekSchedule.get(3).getCol().get(i));
        }
        return winners;
    }

    public ArrayList<String> getPredictions(Context c, int week) {
        predictions.clear();

        //Get the various results of the predictors and return those predictions that occur most often
        ArrayList<String> powerRanks = getPredictionsFor("PowerRankPredictions", c, week);
        ArrayList<String> bayes = getPredictionsFor("BayesPredictions", c, week);
        ArrayList<String> piRating = getPredictionsFor("PiRatingPredictions", c, week);

        boolean prOptimum;
        for(int i=0; i<powerRanks.size(); ++i) {
            prOptimum = false;
            if(powerRanks.get(i).compareTo(bayes.get(i)) == 0)
                prOptimum = true;
            if(powerRanks.get(i).compareTo(piRating.get(i)) == 0)
                prOptimum = true;

            if(prOptimum == true)
                predictions.add(powerRanks.get(i));
            else predictions.add(bayes.get(i));
        }

        return predictions;
    }

    public ArrayList<String> getPredictionsFor(String predictor, Context c, int week) {
        String fileName = predictor + ".txt";
        ArrayList<String> thesePredictions = new ArrayList<>();

        String line;
        try {
            //Utilize android asset manager to handle text file and file reader
            AssetManager assetManager = c.getAssets();
            InputStream inS = assetManager.open(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inS));

            int yearNum = Integer.parseInt(season);
            boolean yearFound = false;
            while((line = bufferedReader.readLine()) != null && !yearFound) {
                int thisYear = Integer.parseInt(line);
                boolean weekFound = false;

                if(thisYear == yearNum) {
                    yearFound = true;
                    while((line = bufferedReader.readLine()) != null && !weekFound) {
                        String tokens[] = line.split(" ");
                        int thisWeek = Integer.parseInt(tokens[0]);

                        if(thisWeek == week) {
                            weekFound = true;
                            for(int i=1; i<tokens.length; ++i) {
                                thesePredictions.add(tokens[i]);
                            }
                        }
                    }
                }
                else {
                    for(int i=0; i<17; ++i) {
                        bufferedReader.readLine();
                    }
                }
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            out.printf("Unable to open file %s\n", fileName);
        }
        catch(IOException ex) {
            out.printf("Error reading file %s\n", fileName);
        }

        return thesePredictions;
    }

    public double getWklyUserAccuracy(ArrayList<String> picks) {
        double wklyNumCorrect = 0;
        double wklyNumGames = 0;
        for (int i = 0; i < winners.size(); ++i) {
            if (winners.get(i).equals(picks.get(i)))
                wklyNumCorrect++;
            wklyNumGames++;
        }
        out.println("Weekly Number Correct: " + wklyNumCorrect);
        double x = wklyNumCorrect/wklyNumGames;
        out.println("Weekly User Accuracy: " + x);
        numCorrect += wklyNumCorrect;
        numGames += wklyNumGames;
        return 100*x;

    }

    public double getWklyPredictorAccuracy() {
        double wklyNumCorrect = 0;
        double wklyNumGames = 0;
        for (int i = 0; i < winners.size(); ++i) {
            if (predictions.contains(winners.get(i)))
                wklyNumCorrect++;
            wklyNumGames++;
        }
        out.println("Weekly Number Correct: " + wklyNumCorrect);
        double x = wklyNumCorrect/wklyNumGames;
        out.println("Weekly Predictor Accuracy: " + x);
        numCorrectPredicted += wklyNumCorrect;
        return 100*x;

    }

    public double getSeasonUserAccuracy() {
        return (100*numCorrect/numGames);
    }

    public double getSeasonPredictorAccuracy() {
        return (100*numCorrectPredicted/numGames);
    }

}
