package booyah.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

    //    NFLModel m = new NFLModel();
        NFLView v = new NFLView();
    //    v.start();
    //    NFLPresenter p = new NFLPresenter();
    //    p.run();


    }
}
