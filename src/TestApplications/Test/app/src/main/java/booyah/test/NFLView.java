package booyah.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static java.lang.System.out;

/**
 * Created by Christine on 4/16/16.
 */
public class NFLView extends Activity {

    int x;

    public NFLView() {
        x = 0;
        out.printf("view x = %d\n", x);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Spinner spinner = (Spinner) findViewById(R.id.seasonSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.season_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        x=1;
        out.printf("view x = %d\n", x);
    }

    public void start() {
    //    setContentView(R.layout.loginscreen);

    }

}
