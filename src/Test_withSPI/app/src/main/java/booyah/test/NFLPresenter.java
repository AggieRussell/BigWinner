package booyah.test;

/**
 * Created by Christine Russell on 4/16/16.
 */

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Application;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

import static java.lang.System.out;

public class NFLPresenter extends Application {

    //NFLView v;
    NFLModel m;

    //    private DBHelper db = new DBHelper(this);
    ArrayList<String> picks = new ArrayList<String>();

    int week;

    public NFLPresenter(){
        //    v = new NFLView();
        //      db = new DBHelper(this);
        m = new NFLModel();
        week = 0;
    }

    public void setM(String u, String s, String a) {
        m.setUser(u);
        m.setSeason(s);
        m.setPredictor(a);
        out.println("pres setM");
    }

    public String getUser() {
        out.println("pres getUser");
        return m.getUser();
    }

    public String getSeason() {
        out.println("pres getSeason");
        return m.getSeason();
    }

    public void increaseWeek() {
        ++week;
    }

    public int getWeek() {
        return week;
    }

    public void resetWeek() {
        week = 0;
    }

    public void resetGames() {
        m.resetGames();
    }

    public void resetSeason() { m.resetSeason(); }

    public void setGames(DBHelper db) {
        m.setGames(db, week);
    }

    public void setPicks(ArrayList<String> p) {
        picks.clear();
        picks = p;
    }

    public ArrayList<String> getHome() {
        return m.getHome();
    }

    public ArrayList<String> getAway() {
        return m.getAway();
    }

    public ArrayList<String> getPicks() {
        return picks;
    }

    public ArrayList<String> getWinners(DBHelper db) {
        return m.getWinners(db, week);
    }

    public ArrayList<String> getPredictions() { return m.getPredictions(getApplicationContext(), week); }

    public double getWklyUserAccuracy() {
        return m.getWklyUserAccuracy(picks);
    }

    public double getSeasonUserAccuracy() { return m.getSeasonUserAccuracy(); }
}
