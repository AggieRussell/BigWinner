package booyah.test;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Christine on 4/27/16.
 */
public class SeasonResults extends Activity {

    private DBHelper db;
    MediaPlayer introSong;
    MediaPlayer playerWinsSound;
    MediaPlayer playerLosesSound;
    final ArrayList<TextView> topScores = new ArrayList<TextView>();
    final ArrayList<TextView> recentScores = new ArrayList<TextView>();
    final ArrayList<TextView> listOfYears = new ArrayList<TextView>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.season_results);
        introSong = MediaPlayer.create(this,R.raw.ftheme);
        playerWinsSound = MediaPlayer.create(this,R.raw.applause);
        playerLosesSound = MediaPlayer.create(this,R.raw.boo);

        db = new DBHelper(this);

        final NFLPresenter p = (NFLPresenter) getApplicationContext();

        boolean playerWon = (p.getSeasonUserAccuracy() > p.getSeasonPredictorAccuracy());
        if(playerWon)
            playerWinsSound.start();
        else
            playerLosesSound.start();

        final TableLayout lm = (TableLayout) findViewById(R.id.tableWeekResults);
        final TextView greeting = (TextView) findViewById(R.id.greetingView);
        final TextView year = (TextView) findViewById(R.id.yearView);
        final TextView season = (TextView) findViewById(R.id.seasonView);
        final TextView userAcc = (TextView) findViewById(R.id.userAcc);
        final TextView predictorAcc = (TextView) findViewById(R.id.predictorAcc);
        final Button again = (Button) findViewById(R.id.againButton);

        String u = "User: " + p.getUser();
        String y = "Season: " + p.getSeason();
        greeting.setText(u);
        year.setText(y);
        String s = "" + p.getSeason() + " Season Results";
        season.setText(s);

        resetScores();
        displayScores(p, db);

        String uA = String.format("%.2f",p.getSeasonUserAccuracy()) + "%";
        userAcc.setText("Your accuracy: " + uA);

        String pA = String.format("%.2f",p.getSeasonPredictorAccuracy()) + "%";
        predictorAcc.setText("Big Winner accuracy: " + pA);

        again.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                p.resetSeason();
                introSong.start();

                Intent i = new Intent(getBaseContext(), LoginScreen.class);
                startActivity(i);
                finish();

            }
        });

    }

    private void resetScores(){
        topScores.clear();
        recentScores.clear();
        listOfYears.clear();
        topScores.add((TextView) findViewById(R.id.top2011));
        topScores.add((TextView) findViewById(R.id.top2012));
        topScores.add((TextView) findViewById(R.id.top2013));
        topScores.add((TextView) findViewById(R.id.top2014));
        topScores.add((TextView) findViewById(R.id.top2015));
        recentScores.add((TextView) findViewById(R.id.recent2011));
        recentScores.add((TextView) findViewById(R.id.recent2012));
        recentScores.add((TextView) findViewById(R.id.recent2013));
        recentScores.add((TextView) findViewById(R.id.recent2014));
        recentScores.add((TextView) findViewById(R.id.recent2015));
        listOfYears.add((TextView) findViewById(R.id.year2011));
        listOfYears.add((TextView) findViewById(R.id.year2012));
        listOfYears.add((TextView) findViewById(R.id.year2013));
        listOfYears.add((TextView) findViewById(R.id.year2014));
        listOfYears.add((TextView) findViewById(R.id.year2015));

    }

    private void displayScores(NFLPresenter p, DBHelper db) {
        double newScore = p.getSeasonUserAccuracy();
        int yearNum = Integer.parseInt(p.getSeason());
        db.updateScore(yearNum, newScore);
        ArrayList<Column> scores = db.getScores();

        for(int i = 0; i < scores.get(0).size(); ++i){
            listOfYears.get(i).setText( (String) scores.get(0).getValue(i));
            topScores.get(i).setText( (String) scores.get(1).getValue(i));
            recentScores.get(i).setText( (String) scores.get(2).getValue(i));

            listOfYears.get(i).setVisibility(View.VISIBLE);
            topScores.get(i).setVisibility(View.VISIBLE);
            recentScores.get(i).setVisibility(View.VISIBLE);
        }
    }


}
