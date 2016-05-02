package booyah.test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
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
import java.lang.String;

/**
 * Created by Christine Russell on 4/17/16.
 */
public class WeekGames extends Activity {

    private DBHelper db;
    final ArrayList<RadioButton> home = new ArrayList<RadioButton>();
    final ArrayList<RadioButton> away = new ArrayList<RadioButton>();
    final ArrayList<RadioButton> allRB = new ArrayList<>();
    final ArrayList<RadioGroup> games = new ArrayList<RadioGroup>();
    final ArrayList<View> lines = new ArrayList<View>();
    final ArrayList<TextView> stats = new ArrayList<>();
    final ArrayList<View.OnClickListener> listeners = new ArrayList<>();
    TextView open = null;
    MediaPlayer intenseSound;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_games);

        intenseSound = MediaPlayer.create(this,R.raw.suspense);
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
        ArrayList<String> predictions = p.getPredictions();

        setButtons(h,a, predictions);

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
                    intenseSound.start();

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
        stats.add((TextView) findViewById(R.id.list1));
        stats.add((TextView) findViewById(R.id.list2));
        stats.add((TextView) findViewById(R.id.list3));
        stats.add((TextView) findViewById(R.id.list4));
        stats.add((TextView) findViewById(R.id.list5));
        stats.add((TextView) findViewById(R.id.list6));
        stats.add((TextView) findViewById(R.id.list7));
        stats.add((TextView) findViewById(R.id.list8));
        stats.add((TextView) findViewById(R.id.list9));
        stats.add((TextView) findViewById(R.id.list10));
        stats.add((TextView) findViewById(R.id.list11));
        stats.add((TextView) findViewById(R.id.list12));
        stats.add((TextView) findViewById(R.id.list13));
        stats.add((TextView) findViewById(R.id.list14));
        stats.add((TextView) findViewById(R.id.list15));
        stats.add((TextView) findViewById(R.id.list16));
        lines.add((View) findViewById(R.id.l1));
        lines.add((View) findViewById(R.id.l2));
        lines.add((View) findViewById(R.id.l3));
        lines.add((View) findViewById(R.id.l4));
        lines.add((View) findViewById(R.id.l5));
        lines.add((View) findViewById(R.id.l6));
        lines.add((View) findViewById(R.id.l7));
        lines.add((View) findViewById(R.id.l8));
        lines.add((View) findViewById(R.id.l9));
        lines.add((View) findViewById(R.id.l10));
        lines.add((View) findViewById(R.id.l11));
        lines.add((View) findViewById(R.id.l12));
        lines.add((View) findViewById(R.id.l13));
        lines.add((View) findViewById(R.id.l14));
        lines.add((View) findViewById(R.id.l15));
        lines.add((View) findViewById(R.id.l16));
        for(int i = 0; i < games.size(); ++i) {
            games.get(i).setVisibility(View.GONE);
        }
        for(int i = 0; i < away.size(); ++i) {
            allRB.add(away.get(i));
            allRB.add(home.get(i));
        }
        for(int i = 0; i < allRB.size(); ++i) {
            listeners.add(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(open != null && open != stats.get(allRB.indexOf(v)/2)) {
                        open.setVisibility(View.GONE);
                    }
                    open = stats.get(allRB.indexOf(v)/2);
                    open.setVisibility(View.VISIBLE);
                }
            });
            allRB.get(i).setOnClickListener(listeners.get(i));
        }
        for(int i = 0; i < lines.size(); ++i) {
            lines.get(i).setVisibility(View.GONE);
        }
        for(int i=0; i < stats.size(); ++i) {
            stats.get(i).setVisibility(View.GONE);
            stats.get(i).setText("Statistics");
        }
    }

    private void setButtons(ArrayList<String> h, ArrayList<String> a, ArrayList<String> predictions) {
        System.out.println(h.size());
        System.out.println(predictions.size());

        for (int i = 0; i < h.size(); ++i) {
            away.get(i).setText(a.get(i));
            home.get(i).setText(h.get(i));
            games.get(i).setVisibility(View.VISIBLE);
            if (i < games.size())
                lines.get(i).setVisibility(View.VISIBLE);

            if(predictions.contains(a.get(i))) {
                away.get(i).setTextColor(0xFF1b831b);
                away.get(i).setTypeface(null, Typeface.BOLD_ITALIC);
            }
            else {
                home.get(i).setTextColor(0xFF1b831b);
                home.get(i).setTypeface(null, Typeface.BOLD_ITALIC);
            }

            //test radio button images
            switch (a.get(i)) {
                case "Cardinals" :
                    away.get(i).setButtonDrawable(R.drawable.cardinals_selector);
                    break;
                case "Falcons" :
                    away.get(i).setButtonDrawable(R.drawable.falcons_selector);
                    break;
                case "Ravens" :
                    away.get(i).setButtonDrawable(R.drawable.ravens_selector);
                    break;
                case "Bills" :
                    away.get(i).setButtonDrawable(R.drawable.bills_selector);
                    break;
                case "Panthers" :
                    away.get(i).setButtonDrawable(R.drawable.panthers_selector);
                    break;
                case "Bears" :
                    away.get(i).setButtonDrawable(R.drawable.bears_selector);
                    break;
                case "Bengals" :
                    away.get(i).setButtonDrawable(R.drawable.bengals_selector);
                    break;
                case "Browns" :
                    away.get(i).setButtonDrawable(R.drawable.browns_selector);
                    break;
                case "Cowboys" :
                    away.get(i).setButtonDrawable(R.drawable.cowboys_selector);
                    break;
                case "Broncos" :
                    away.get(i).setButtonDrawable(R.drawable.broncos_selector);
                    break;
                case "Lions" :
                    away.get(i).setButtonDrawable(R.drawable.lions_selector);
                    break;
                case "Packers" :
                    away.get(i).setButtonDrawable(R.drawable.packers_selector);
                    break;
                case "Texans" :
                    away.get(i).setButtonDrawable(R.drawable.texans_selector);
                    break;
                case "Colts" :
                    away.get(i).setButtonDrawable(R.drawable.colts_selector);
                    break;
                case "Jaguars" :
                    away.get(i).setButtonDrawable(R.drawable.jaguars_selector);
                    break;
                case "Chiefs" :
                    away.get(i).setButtonDrawable(R.drawable.chiefs_selector);
                    break;
                case "Dolphins" :
                    away.get(i).setButtonDrawable(R.drawable.dolphins_selector);
                    break;
                case "Vikings" :
                    away.get(i).setButtonDrawable(R.drawable.vikings_selector);
                    break;
                case "Patriots" :
                    away.get(i).setButtonDrawable(R.drawable.patriots_selector);
                    break;
                case "Saints" :
                    away.get(i).setButtonDrawable(R.drawable.saints_selector);
                    break;
                case "Giants" :
                    away.get(i).setButtonDrawable(R.drawable.giants_selector);
                    break;
                case "Jets" :
                    away.get(i).setButtonDrawable(R.drawable.jets_selector);
                    break;
                case "Raiders" :
                    away.get(i).setButtonDrawable(R.drawable.raiders_selector);
                    break;
                case "Eagles" :
                    away.get(i).setButtonDrawable(R.drawable.eagles_selector);
                    break;
                case "Steelers" :
                    away.get(i).setButtonDrawable(R.drawable.steelers_selector);
                    break;
                case "Chargers" :
                    away.get(i).setButtonDrawable(R.drawable.chargers_selector);
                    break;
                case "49ers" :
                    away.get(i).setButtonDrawable(R.drawable.forty_niners_selector);
                    break;
                case "Seahawks" :
                    away.get(i).setButtonDrawable(R.drawable.seahawks_selector);
                    break;
                case "Rams" :
                    away.get(i).setButtonDrawable(R.drawable.rams_selector);
                    break;
                case "Buccaneers" :
                    away.get(i).setButtonDrawable(R.drawable.buccaneers_selector);
                    break;
                case "Titans" :
                    away.get(i).setButtonDrawable(R.drawable.titans_selector);
                    break;
                case "Redskins" :
                    away.get(i).setButtonDrawable(R.drawable.redskins_selector);
                    break;
                default :
                    break;
            }
            switch (h.get(i)) {
                case "Cardinals" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.cardinals_selector, 0);
                    break;
                case "Falcons" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.falcons_selector, 0);
                    break;
                case "Ravens" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ravens_selector, 0);
                    break;
                case "Bills" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.bills_selector, 0);
                    break;
                case "Panthers" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.panthers_selector, 0);
                    break;
                case "Bears" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.bears_selector, 0);
                    break;
                case "Bengals" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.bengals_selector, 0);
                    break;
                case "Browns" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.browns_selector, 0);
                    break;
                case "Cowboys" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.cowboys_selector, 0);
                    break;
                case "Broncos" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.broncos_selector, 0);
                    break;
                case "Lions" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.lions_selector, 0);
                    break;
                case "Packers" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.packers_selector, 0);
                    break;
                case "Texans" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.texans_selector, 0);
                    break;
                case "Colts" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.colts_selector, 0);
                    break;
                case "Jaguars" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.jaguars_selector, 0);
                    break;
                case "Chiefs" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.chiefs_selector, 0);
                    break;
                case "Dolphins" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.dolphins_selector, 0);
                    break;
                case "Vikings" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.vikings_selector, 0);
                    break;
                case "Patriots" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.patriots_selector, 0);
                    break;
                case "Saints" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.saints_selector, 0);
                    break;
                case "Giants" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.giants_selector, 0);
                    break;
                case "Jets" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.jets_selector, 0);
                    break;
                case "Raiders" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.raiders_selector, 0);
                    break;
                case "Eagles" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eagles_selector, 0);
                    break;
                case "Steelers" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.steelers_selector, 0);
                    break;
                case "Chargers" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.chargers_selector, 0);
                    break;
                case "49ers" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.forty_niners_selector, 0);
                    break;
                case "Seahawks" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.seahawks_selector, 0);
                    break;
                case "Rams" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.rams_selector, 0);
                    break;
                case "Buccaneers" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.buccaneers_selector, 0);
                    break;
                case "Titans" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.titans_selector, 0);
                    break;
                case "Redskins" :
                    home.get(i).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.redskins_selector, 0);
                    break;
                default :
                    break;
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
