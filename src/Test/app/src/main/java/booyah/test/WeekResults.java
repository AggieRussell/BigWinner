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
    //    final Button again = (Button) findViewById(R.id.againButton);

        String u = "User: " + p.getUser();
        String y = "Season: " + p.getSeason();
        greeting.setText(u);
        year.setText(y);
        week.setText("Week " + p.getWeek() + " Results");

        resetResults();

        displayWinners(p);

        String uA = String.format("%.2f",p.getWklyUserAccuracy()) + "%";
        userAcc.setText("Your accuracy: " + uA);
/*
        again.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), LoginScreen.class);
                startActivity(i);
            }
        });
*/
    }

    private void resetResults() {
        games.clear();
        winners.clear();
        games.add((TextView) findViewById(R.id.game1));
        games.add((TextView) findViewById(R.id.game2));
        winners.add((TextView) findViewById(R.id.winner1));
        winners.add((TextView) findViewById(R.id.winner2));
        for (int i = 0; i<games.size(); ++i) {
            games.get(i).setVisibility(View.INVISIBLE);
            winners.get(i).setVisibility(View.INVISIBLE);
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
