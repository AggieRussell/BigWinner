package booyah.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Christine Russell on 4/16/16.
 */
public class LoginScreen extends Activity {

    MediaPlayer introSong;
    MediaPlayer whistleSound;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        introSong = MediaPlayer.create(this,R.raw.ftheme);
        introSong.start();
        whistleSound = MediaPlayer.create(this,R.raw.whistle);

        final TableLayout lm = (TableLayout) findViewById(R.id.tableLogin);
        final TextView user = (TextView) findViewById(R.id.username);
        final Spinner spinner = (Spinner) findViewById(R.id.seasonSpinner);
        final Button login = (Button) findViewById(R.id.loginButton);
        final Button instruct = (Button) findViewById(R.id.instructButton);
        final TextView msg = (TextView) findViewById(R.id.afterLogin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.season_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final NFLPresenter p = (NFLPresenter) getApplicationContext();

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = user.getText().toString();
                String year = spinner.getSelectedItem().toString();
            //    msg.setText(s);

                if (name.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter a username", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                else {
                    p.setM(name,year);
                    p.resetWeek();
                    introSong.release();
                    whistleSound.start();

                    Intent i = new Intent(getBaseContext(), WeekGames.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        instruct.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Instructions.class);
                startActivity(i);
                finish();
            }
        });

    }

}
