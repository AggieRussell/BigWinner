package booyah.test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Christine Russell on 4/18/16.
 */
public class WeekResults extends Activity {

    private DBHelper db;
    MediaPlayer whistleSound;
    final ArrayList<RadioButton> home = new ArrayList<RadioButton>();
    final ArrayList<RadioButton> away = new ArrayList<RadioButton>();
    final ArrayList<RadioButton> allRB = new ArrayList<>();
    final ArrayList<RadioGroup> games = new ArrayList<RadioGroup>();
    final ArrayList<View> lines = new ArrayList<View>();
    final ArrayList<TextView> stats = new ArrayList<>();
    final ArrayList<View.OnClickListener> listeners = new ArrayList<>();
    final ArrayList<ImageView> logos = new ArrayList<ImageView>();
    TextView openLeft = null;
    TextView openRight = null;

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

        ArrayList<String> h = p.getHome();
        ArrayList<String> a = p.getAway();
        ArrayList<String> predictions = p.getPredictions();

        setButtons(h, a, predictions);
        setStatistics(h, a, p, db);

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
        stats.add((TextView) findViewById(R.id.list17));
        stats.add((TextView) findViewById(R.id.list18));
        stats.add((TextView) findViewById(R.id.list19));
        stats.add((TextView) findViewById(R.id.list20));
        stats.add((TextView) findViewById(R.id.list21));
        stats.add((TextView) findViewById(R.id.list22));
        stats.add((TextView) findViewById(R.id.list23));
        stats.add((TextView) findViewById(R.id.list24));
        stats.add((TextView) findViewById(R.id.list25));
        stats.add((TextView) findViewById(R.id.list26));
        stats.add((TextView) findViewById(R.id.list27));
        stats.add((TextView) findViewById(R.id.list28));
        stats.add((TextView) findViewById(R.id.list29));
        stats.add((TextView) findViewById(R.id.list30));
        stats.add((TextView) findViewById(R.id.list31));
        stats.add((TextView) findViewById(R.id.list32));
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
            away.get(i).setClickable(false);
            home.get(i).setClickable(false);
        }
        for(int i = 0; i < allRB.size(); ++i) {
            listeners.add(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(openLeft != null && openLeft != stats.get(allRB.indexOf(v)) && openLeft != stats.get(allRB.indexOf(v))) {
                        openLeft.setVisibility(View.GONE);
                        openRight.setVisibility(View.GONE);
                    }
                    int textIndex = allRB.indexOf(v);
                    if(textIndex % 2 == 0) {
                        openLeft = stats.get(textIndex);
                        openRight = stats.get(textIndex+1);
                    }
                    else {
                        openLeft = stats.get(textIndex-1);
                        openRight = stats.get(textIndex);
                    }
                    openLeft.setVisibility(View.VISIBLE);
                    openRight.setVisibility(View.VISIBLE);
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
                //   away.get(i).setTextColor(0xFF1b831b);
                away.get(i).setTextColor(0xFF0000CD);
                away.get(i).setTypeface(null, Typeface.BOLD_ITALIC);
            }
            else {
                //   home.get(i).setTextColor(0xFF1b831b);
                home.get(i).setTextColor(0xFF0000CD);
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

    private void setStatistics(ArrayList<String> h, ArrayList<String> a, NFLPresenter p, DBHelper db) {
        for(int i = 0; i < games.size(); ++i) {
            //If the radio group is being used this week
            if(games.get(i).getVisibility() == View.VISIBLE) {
                stats.get(i*2).setText(p.getStatistics(db, a.get(i)));
                stats.get(i*2+1).setText(p.getStatistics(db, h.get(i)));
            }
        }
    }

    private void displayWinners(NFLPresenter p, DBHelper db) {
        ArrayList<String> w = p.getWinners(db);
        ArrayList<String> h = p.getHome();
        ArrayList<String> a = p.getAway();
        ArrayList<String> predictions = p.getPredictions();
        ArrayList<String> picks = p.getPicks();

        for (int i = 0; i < a.size(); ++i) {
            //user picked to win
            if (picks.contains(a.get(i))) {
                away.get(i).setChecked(true);
                //actually won
                if (w.contains(a.get(i))) {
                    //            away.get(i).setBackgroundColor(0xFFAFE4C8);
                    away.get(i).setBackgroundResource(R.drawable.greenrect);
                 //   away.get(i).setHeight(40);
                }
                //didn't win
                else {
                    //            away.get(i).setBackgroundColor(0xFFFF9595);
                 //   away.get(i).setBackgroundResource(R.drawable.redrect);
                 //   away.get(i).setHeight(40);
                }
            }
            //user picked to win
            if (picks.contains(h.get(i))) {
                home.get(i).setChecked(true);
                //actually won
                if (w.contains(h.get(i))) {
                    //            home.get(i).setBackgroundColor(0xFFAFE4C8);
                    home.get(i).setBackgroundResource(R.drawable.greenrect);
                }
                //didn't win
                else {
                    //            home.get(i).setBackgroundColor(0xFFFF9595);
                 //   home.get(i).setBackgroundResource(R.drawable.redrect);
                }
            }
        }

        for(int i = 0; i < away.size(); ++i) {
            away.get(i).setClickable(false);
            home.get(i).setClickable(false);
        }

    /*    for(int i = 0; i < w.size(); ++i) {
            int logoIndex;
            if(a.contains(w.get(i))) {
                logoIndex = a.indexOf(w.get(i));
            }
            else {
                logoIndex = h.indexOf(w.get(i));
            }

            if(predictions.contains(w.get(i))) {
                //display logo
                logos.get(logoIndex).setVisibility(View.VISIBLE);
            }
<<<<<<< HEAD
        }
        for (int i = w.size(); i<logos.size(); ++i) {
            logos.get(i).setVisibility(View.GONE);
        }
=======
        }*/
>>>>>>> 0357f82bb461b831007b6f4172fe6e5016b985a7
    }
}
