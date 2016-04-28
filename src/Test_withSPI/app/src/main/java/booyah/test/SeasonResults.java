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
 * Created by Christine on 4/27/16.
 */
public class SeasonResults extends Activity {

    private DBHelper db;
    final ArrayList<TextView> games = new ArrayList<TextView>();
    final ArrayList<TextView> winners = new ArrayList<TextView>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_results);

        db = new DBHelper(this);

        final NFLPresenter p = (NFLPresenter) getApplicationContext();

        final TableLayout lm = (TableLayout) findViewById(R.id.tableWeekResults);
        final TextView greeting = (TextView) findViewById(R.id.greetingView);
        final TextView year = (TextView) findViewById(R.id.yearView);
        final TextView week = (TextView) findViewById(R.id.weekView);
        final TextView userAcc = (TextView) findViewById(R.id.userAcc);
        final Button again = (Button) findViewById(R.id.againButton);

        String u = "User: " + p.getUser();
        String y = "Season: " + p.getSeason();
        greeting.setText(u);
        year.setText(y);
        week.setText(p.getSeason() + " Season Results");

        String uA = String.format("%.2f",p.getSeasonUserAccuracy()) + "%";
        userAcc.setText("Your accuracy: " + uA);

        again.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                p.resetSeason();

                Intent i = new Intent(getBaseContext(), LoginScreen.class);
                startActivity(i);
                finish();

            }
        });

    }


}
