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

    //    private DBHelper db;
    MediaPlayer introSong;
    MediaPlayer playerWinsSound;
    MediaPlayer playerLosesSound;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.season_results);
        introSong = MediaPlayer.create(this,R.raw.ftheme);
        playerWinsSound = MediaPlayer.create(this,R.raw.applause);
        playerLosesSound = MediaPlayer.create(this,R.raw.boo);

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


}
