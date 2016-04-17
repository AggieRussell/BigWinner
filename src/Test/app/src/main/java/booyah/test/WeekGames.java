package booyah.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Christine on 4/17/16.
 */
public class WeekGames extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_games);

        final GridLayout lm = (GridLayout) findViewById(R.id.gridWeekGames);
        final TextView greeting = (TextView) findViewById(R.id.greetingView);
        final TextView year = (TextView) findViewById(R.id.yearView);

        final NFLPresenter p = (NFLPresenter) getApplicationContext();

        String u = "User: " + p.getUser();
        String y = "Season: " + p.getSeason();
        greeting.setText(u);
        year.setText(y);

        String name = p.getUser();
        int duration = Toast.LENGTH_SHORT;
        String s = "Welcome " + name + "!";
        Toast toast = Toast.makeText(getApplicationContext(), s, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    protected void onDestroy() {

        super.onDestroy();

    }
}
