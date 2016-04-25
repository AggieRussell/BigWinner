package booyah.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Christine Russell on 4/18/16.
 */
public class WeekResults extends Activity {

    final ArrayList<TextView> games = new ArrayList<TextView>();
    final ArrayList<TextView> winners = new ArrayList<TextView>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_results);

        final NFLPresenter p = (NFLPresenter) getApplicationContext();

        final TableLayout lm = (TableLayout) findViewById(R.id.tableWeekResults);
        final TextView greeting = (TextView) findViewById(R.id.greetingView);
        final TextView year = (TextView) findViewById(R.id.yearView);
        final TextView week = (TextView) findViewById(R.id.weekView);
        final TextView userAcc = (TextView) findViewById(R.id.userAcc);
        final Button again = (Button) findViewById(R.id.againButton);

        if (p.getWeek() < 17)
            again.setText("NEXT WEEK");
        else
            again.setText("PLAY AGAIN");

        String u = "User: " + p.getUser();
        String y = "Season: " + p.getSeason();
        greeting.setText(u);
        year.setText(y);
        week.setText("Week " + p.getWeek() + " Results");

        resetResults();

        displayWinners(p);

        String uA = String.format("%.2f",p.getWklyUserAccuracy()) + "%";
        userAcc.setText("Your accuracy: " + uA);

        again.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (p.getWeek() < 17) {
                    Intent i = new Intent(getBaseContext(), WeekGames.class);
                    startActivity(i);
                    finish();
                }
                else {
                    Intent i = new Intent(getBaseContext(), LoginScreen.class);
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
        for (int i = 0; i<games.size(); ++i) {
            games.get(i).setVisibility(View.GONE);
            winners.get(i).setVisibility(View.GONE);
        }
    }

    private void displayWinners(NFLPresenter p) {
        ArrayList<String> w = p.getWinners();
        ArrayList<String> h = p.getHome();
        ArrayList<String> a = p.getAway();
        ArrayList<String> picks = p.getPicks();
        for (int i = 0; i < w.size(); ++i) {
            games.get(i).setText(a.get(i) + " @ " + h.get(i));
            winners.get(i).setText(w.get(i));
            if (w.get(i).equals(picks.get(i)))
                winners.get(i).setTextColor(0xFF2E8B57);
            else
                winners.get(i).setTextColor(0xFFFF0000);
            games.get(i).setVisibility(View.VISIBLE);
            winners.get(i).setVisibility(View.VISIBLE);
        }
    }

}
