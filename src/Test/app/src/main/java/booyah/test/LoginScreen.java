package booyah.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Christine Russell on 4/16/16.
 */
public class LoginScreen extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        final RelativeLayout lm = (RelativeLayout) findViewById(R.id.relativeLogin);
        final TextView user = (TextView) findViewById(R.id.username);
        final Spinner spinner = (Spinner) findViewById(R.id.seasonSpinner);
        final Button login = (Button) findViewById(R.id.loginButton);
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

                p.setM(name,year);
                p.resetWeek();

                Intent i = new Intent(getBaseContext(), WeekGames.class);
                startActivity(i);
                finish();
            }
        });

    }

}
