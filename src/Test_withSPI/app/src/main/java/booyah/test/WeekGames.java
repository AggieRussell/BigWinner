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

    private DBHelper db;
    final ArrayList<RadioButton> home = new ArrayList<RadioButton>();
    final ArrayList<RadioButton> away = new ArrayList<RadioButton>();
    final ArrayList<RadioGroup> games = new ArrayList<RadioGroup>();
    final ArrayList<View> lines = new ArrayList<View>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_games);

        db = new DBHelper(this);

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

        if (p.getWeek()==1) {
            String name = p.getUser();
            String s = "Welcome " + name + "!";
            Toast toast = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

        p.resetGames();
        p.setGames(db);

        ArrayList<String> h = p.getHome();
        ArrayList<String> a = p.getAway();

        setButtons(h,a);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ArrayList<String> picks = new ArrayList<String>();
                boolean picksForAll = true;
                for(int i = 0; i<games.size(); ++i) {
                    if (games.get(i).getVisibility() == View.VISIBLE) {
                        if (games.get(i).getCheckedRadioButtonId() == -1) {
                            picksForAll = false;
                            break;
                        }
                        String s = ((RadioButton)findViewById(games.get(i).getCheckedRadioButtonId())).getText().toString();
                        if (s.charAt(0) == '@')
                            s = s.substring(2);
                        picks.add(s);
                    }
                }
                if (!picksForAll) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Please pick a winner for each game", Toast.LENGTH_SHORT);
                    toast2.setGravity(Gravity.CENTER, 0, 0);
                    toast2.show();
                }
                else {
                    p.setPicks(picks);

                    Intent i = new Intent(getBaseContext(), WeekResults.class);
                    startActivity(i);
                    finish();
                }
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
        away.add((RadioButton) findViewById(R.id.radioButton5));
        away.add((RadioButton) findViewById(R.id.radioButton7));
        away.add((RadioButton) findViewById(R.id.radioButton9));
        away.add((RadioButton) findViewById(R.id.radioButton11));
        away.add((RadioButton) findViewById(R.id.radioButton13));
        away.add((RadioButton) findViewById(R.id.radioButton15));
        away.add((RadioButton) findViewById(R.id.radioButton17));
        away.add((RadioButton) findViewById(R.id.radioButton19));
        away.add((RadioButton) findViewById(R.id.radioButton21));
        away.add((RadioButton) findViewById(R.id.radioButton23));
        away.add((RadioButton) findViewById(R.id.radioButton25));
        away.add((RadioButton) findViewById(R.id.radioButton27));
        away.add((RadioButton) findViewById(R.id.radioButton29));
        away.add((RadioButton) findViewById(R.id.radioButton31));
        home.add((RadioButton) findViewById(R.id.radioButton2));
        home.add((RadioButton) findViewById(R.id.radioButton4));
        home.add((RadioButton) findViewById(R.id.radioButton6));
        home.add((RadioButton) findViewById(R.id.radioButton8));
        home.add((RadioButton) findViewById(R.id.radioButton10));
        home.add((RadioButton) findViewById(R.id.radioButton12));
        home.add((RadioButton) findViewById(R.id.radioButton14));
        home.add((RadioButton) findViewById(R.id.radioButton16));
        home.add((RadioButton) findViewById(R.id.radioButton18));
        home.add((RadioButton) findViewById(R.id.radioButton20));
        home.add((RadioButton) findViewById(R.id.radioButton22));
        home.add((RadioButton) findViewById(R.id.radioButton24));
        home.add((RadioButton) findViewById(R.id.radioButton26));
        home.add((RadioButton) findViewById(R.id.radioButton28));
        home.add((RadioButton) findViewById(R.id.radioButton30));
        home.add((RadioButton) findViewById(R.id.radioButton32));
        games.add((RadioGroup) findViewById(R.id.rg1));
        games.add((RadioGroup) findViewById(R.id.rg2));
        games.add((RadioGroup) findViewById(R.id.rg3));
        games.add((RadioGroup) findViewById(R.id.rg4));
        games.add((RadioGroup) findViewById(R.id.rg5));
        games.add((RadioGroup) findViewById(R.id.rg6));
        games.add((RadioGroup) findViewById(R.id.rg7));
        games.add((RadioGroup) findViewById(R.id.rg8));
        games.add((RadioGroup) findViewById(R.id.rg9));
        games.add((RadioGroup) findViewById(R.id.rg10));
        games.add((RadioGroup) findViewById(R.id.rg11));
        games.add((RadioGroup) findViewById(R.id.rg12));
        games.add((RadioGroup) findViewById(R.id.rg13));
        games.add((RadioGroup) findViewById(R.id.rg14));
        games.add((RadioGroup) findViewById(R.id.rg15));
        games.add((RadioGroup) findViewById(R.id.rg16));
        lines.add((View) findViewById(R.id.l1));
        lines.add((View) findViewById(R.id.l2));
        lines.add((View) findViewById(R.id.l3));
        lines.add((View) findViewById(R.id.l4));
        lines.add((View) findViewById(R.id.l5));
        lines.add((View) findViewById(R.id.l6));
        lines.add((View) findViewById(R.id.l7));
        for(int i = 0; i < games.size(); ++i) {
            games.get(i).setVisibility(View.GONE);
        }
        for(int i = 0; i < lines.size(); ++i) {
            lines.get(i).setVisibility(View.GONE);
        }
    }

    private void setButtons(ArrayList<String> h, ArrayList<String> a) {
        System.out.println(h.size());
        System.out.println(a.size());
        System.out.println(home.size());
        System.out.println(away.size());
        System.out.println(games.size());
        for (int i = 0; i < h.size(); ++i) {
            away.get(i).setText(a.get(i));
            home.get(i).setText("@ " + h.get(i));
            games.get(i).setVisibility(View.VISIBLE);
            if (i < games.size()/2-1)
                lines.get(i).setVisibility(View.VISIBLE);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
