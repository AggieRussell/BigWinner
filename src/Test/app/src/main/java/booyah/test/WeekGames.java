package booyah.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Christine Russell on 4/17/16.
 */
public class WeekGames extends Activity {

    final ArrayList<RadioButton> home = new ArrayList<RadioButton>();
    final ArrayList<RadioButton> away = new ArrayList<RadioButton>();
    final ArrayList<RadioGroup> games = new ArrayList<RadioGroup>();
    final ArrayList<View> lines = new ArrayList<View>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_games);

        resetButtons();

        final TableLayout lm = (TableLayout) findViewById(R.id.tableWeekGames);
        final TextView greeting = (TextView) findViewById(R.id.greetingView);
        final TextView year = (TextView) findViewById(R.id.yearView);
        final TextView week = (TextView) findViewById(R.id.weekView);
        final Button submit = (Button) findViewById(R.id.submitButton);

        final NFLPresenter p = (NFLPresenter) getApplicationContext();

        String u = "User: " + p.getUser();
        String y = "Season: " + p.getSeason();
        p.increaseWeek();
        greeting.setText(u);
        year.setText(y);
        week.setText("Week " + p.getWeek() + " Games");

        String name = p.getUser();
        int duration = Toast.LENGTH_SHORT;
        String s = "Welcome " + name + "!";
        Toast toast = Toast.makeText(getApplicationContext(), s, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        p.setGames();

        ArrayList<String> h = p.getHome();
        ArrayList<String> a = p.getAway();

        setButtons(h,a);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ArrayList<String> picks = new ArrayList<String>();
                for(int i = 0; i<games.size(); ++i) {
                    if (games.get(i).getVisibility() == View.VISIBLE) {
                        String s = ((RadioButton)findViewById(games.get(i).getCheckedRadioButtonId())).getText().toString();
                        if (s.charAt(0) == '@')
                            s = s.substring(2);
                        picks.add(s);
                    }
                }
                p.setPicks(picks);

                Intent i = new Intent(getBaseContext(), WeekResults.class);
                startActivity(i);
            }
        });
    }

    private void resetButtons() {
        away.clear();
        home.clear();
        games.clear();
        lines.clear();
        away.add((RadioButton) findViewById(R.id.radioButton1));
        away.add((RadioButton) findViewById(R.id.radioButton3));
        home.add((RadioButton) findViewById(R.id.radioButton2));
        home.add((RadioButton) findViewById(R.id.radioButton4));
        games.add((RadioGroup) findViewById(R.id.rg1));
        games.add((RadioGroup) findViewById(R.id.rg2));
        lines.add((View) findViewById(R.id.l1));
        for(int i = 0; i < games.size(); ++i) {
            games.get(i).setVisibility(View.INVISIBLE);
        }
        for(int i = 0; i < lines.size(); ++i) {
            lines.get(i).setVisibility(View.INVISIBLE);
        }
    }

    private void setButtons(ArrayList<String> h, ArrayList<String> a) {
        for (int i = 0; i < h.size(); ++i) {
            away.get(i).setText(a.get(i));
            home.get(i).setText("@ " + h.get(i));
            games.get(i).setVisibility(View.VISIBLE);
            if (i < lines.size())
                lines.get(i).setVisibility(View.VISIBLE);
        }
    }



    protected void onDestroy() {

        super.onDestroy();

    }
}
