package booyah.test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Christine Russell on 4/18/16.
 */
public class WeekResults extends Activity {

    private DBHelper db;
    MediaPlayer whistleSound;
    final ArrayList<TextView> games = new ArrayList<TextView>();
    final ArrayList<TextView> winners = new ArrayList<TextView>();
    final ArrayList<ImageView> logos = new ArrayList<ImageView>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_results);

        whistleSound = MediaPlayer.create(this,R.raw.whistle);
        db = new DBHelper(this);

        final NFLPresenter p = (NFLPresenter) getApplicationContext();

        final TableLayout lm = (TableLayout) findViewById(R.id.tableWeekResults);
        final TextView greeting = (TextView) findViewById(R.id.greetingView);
        final TextView year = (TextView) findViewById(R.id.yearView);
        final TextView week = (TextView) findViewById(R.id.weekView);
        final TextView userAcc = (TextView) findViewById(R.id.userAcc);
        final TextView predictorAcc = (TextView) findViewById(R.id.predictorAcc);
        final Button next = (Button) findViewById(R.id.nextButton);

        String u = "User: " + p.getUser();
        String y = "Season: " + p.getSeason();
        greeting.setText(u);
        year.setText(y);
        week.setText("Week " + p.getWeek() + " Results");

        if (p.getWeek() < 17)
            next.setText("Next Week");
        else
            next.setText("Final Results");

        resetResults();

        displayWinners(p, db);

        String uA = String.format("%.2f",p.getWklyUserAccuracy()) + "%";
        userAcc.setText("Your accuracy: " + uA);

        String pA = String.format("%.2f",p.getWklyPredictorAccuracy()) + "%";
        predictorAcc.setText("Big Winner accuracy: " + pA);

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (p.getWeek() < 17) {
                    whistleSound.start();
                    Intent i = new Intent(getBaseContext(), WeekGames.class);
                    startActivity(i);
                    finish();
                }
                else {
                    Intent i = new Intent(getBaseContext(), SeasonResults.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }

    private void resetResults() {
        games.clear();
        winners.clear();
        games.add((TextView) findViewById(R.id.game1));
        games.add((TextView) findViewById(R.id.game2));
        games.add((TextView) findViewById(R.id.game3));
        games.add((TextView) findViewById(R.id.game4));
        games.add((TextView) findViewById(R.id.game5));
        games.add((TextView) findViewById(R.id.game6));
        games.add((TextView) findViewById(R.id.game7));
        games.add((TextView) findViewById(R.id.game8));
        games.add((TextView) findViewById(R.id.game9));
        games.add((TextView) findViewById(R.id.game10));
        games.add((TextView) findViewById(R.id.game11));
        games.add((TextView) findViewById(R.id.game12));
        games.add((TextView) findViewById(R.id.game13));
        games.add((TextView) findViewById(R.id.game14));
        games.add((TextView) findViewById(R.id.game15));
        games.add((TextView) findViewById(R.id.game16));
        winners.add((TextView) findViewById(R.id.winner1));
        winners.add((TextView) findViewById(R.id.winner2));
        winners.add((TextView) findViewById(R.id.winner3));
        winners.add((TextView) findViewById(R.id.winner4));
        winners.add((TextView) findViewById(R.id.winner5));
        winners.add((TextView) findViewById(R.id.winner6));
        winners.add((TextView) findViewById(R.id.winner7));
        winners.add((TextView) findViewById(R.id.winner8));
        winners.add((TextView) findViewById(R.id.winner9));
        winners.add((TextView) findViewById(R.id.winner10));
        winners.add((TextView) findViewById(R.id.winner11));
        winners.add((TextView) findViewById(R.id.winner12));
        winners.add((TextView) findViewById(R.id.winner13));
        winners.add((TextView) findViewById(R.id.winner14));
        winners.add((TextView) findViewById(R.id.winner15));
        winners.add((TextView) findViewById(R.id.winner16));
        logos.add((ImageView) findViewById(R.id.logo1));
        logos.add((ImageView) findViewById(R.id.logo2));
        logos.add((ImageView) findViewById(R.id.logo3));
        logos.add((ImageView) findViewById(R.id.logo4));
        logos.add((ImageView) findViewById(R.id.logo5));
        logos.add((ImageView) findViewById(R.id.logo6));
        logos.add((ImageView) findViewById(R.id.logo7));
        logos.add((ImageView) findViewById(R.id.logo8));
        logos.add((ImageView) findViewById(R.id.logo9));
        logos.add((ImageView) findViewById(R.id.logo10));
        logos.add((ImageView) findViewById(R.id.logo11));
        logos.add((ImageView) findViewById(R.id.logo12));
        logos.add((ImageView) findViewById(R.id.logo13));
        logos.add((ImageView) findViewById(R.id.logo14));
        logos.add((ImageView) findViewById(R.id.logo15));
        logos.add((ImageView) findViewById(R.id.logo16));
        for (int i = 0; i<games.size(); ++i) {
            games.get(i).setVisibility(View.GONE);
            winners.get(i).setVisibility(View.GONE);
            logos.get(i).setVisibility(View.INVISIBLE);
        }
    }

    private void displayWinners(NFLPresenter p, DBHelper db) {
        ArrayList<String> w = p.getWinners(db);
        ArrayList<String> h = p.getHome();
        ArrayList<String> a = p.getAway();
        ArrayList<String> predictions = p.getPredictions();
        ArrayList<String> picks = p.getPicks();
        System.out.println("Winners: ");
        System.out.println(w);
        for (int i = 0; i < w.size(); ++i) {
            games.get(i).setText(a.get(i) + " @ " + h.get(i));
            winners.get(i).setText(w.get(i));
            if (predictions.contains(w.get(i)))
                logos.get(i).setVisibility(View.VISIBLE);
            if (w.get(i).equals(picks.get(i))) {
                winners.get(i).setTextColor(0xFF2E8B57);
            }
            else {
                winners.get(i).setTextColor(0xFFFF0000);
            }
            games.get(i).setVisibility(View.VISIBLE);
            winners.get(i).setVisibility(View.VISIBLE);
        }
        for (int i = w.size(); i<logos.size(); ++i) {
            logos.get(i).setVisibility(View.GONE);
        }
    }

}
