package booyah.test;

/**
 * Created by Christine Russell on 4/16/16.
 */

import java.util.ArrayList;
import android.app.Activity;
import android.app.Application;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import static java.lang.System.out;

public class NFLModel{

    private String user;
    private String season;
    ArrayList<String> home = new ArrayList<String>();
    ArrayList<String> away = new ArrayList<String>();
    ArrayList<String> winners = new ArrayList<String>();

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

    public void setGames(DBHelper db, int week) {
        int yearNum = Integer.parseInt(season);

        ArrayList<Column> weekSchedule = db.getGames(yearNum, week);
        for(int i=0; i<weekSchedule.get(0).size(); ++i) {
            String homeTeam = (String) weekSchedule.get(2).getCol().get(i);
            String awayTeam = (String) weekSchedule.get(3).getCol().get(i);
            home.add(homeTeam);
            away.add(awayTeam);
        }

 /*       if (week == 1) {
            home.add("Falcons");
            away.add("Saints");
            home.add("Texans");
            away.add("Cowboys");
            home.add("Falcons");
            away.add("Saints");
            home.add("Texans");
            away.add("Cowboys");
            home.add("Falcons");
            away.add("Saints");
            home.add("Texans");
            away.add("Cowboys");
            home.add("Falcons");
            away.add("Saints");
            home.add("Texans");
            away.add("Cowboys");
        }
        if (week == 2) {
            home.add("Falcons");
            away.add("Saints");
            home.add("Texans");
            away.add("Cowboys");
            home.add("Falcons");
            away.add("Saints");
        }*/
    }

    public ArrayList<String> getHome() {
        return home;
    }

    public ArrayList<String> getAway() {
        return away;
    }

    public ArrayList<String> getWinners(int week) {
        //dummy code for demo purposes
        winners.clear();
        if (week == 1) {
            winners.add("Falcons");
            winners.add("Texans");
            winners.add("Falcons");
            winners.add("Texans");
            winners.add("Falcons");
            winners.add("Texans");
            winners.add("Falcons");
            winners.add("Texans");
        }
        if (week == 2) {
            winners.add("Falcons");
            winners.add("Texans");
            winners.add("Falcons");
        }
        return winners;
    }

    public double getWklyUserAccuracy(ArrayList<String> picks) {
        double numCorrect = 0;
        double numGames = 0;
        for (int i = 0; i < winners.size(); ++i) {
            out.println(winners.get(i));
            out.println(picks.get(i));
            if (winners.get(i).equals(picks.get(i)))
                numCorrect++;
            numGames++;
        }
        out.println(numCorrect);
        double x = numCorrect/numGames;
        out.println(x);
        return x;
    }

}
