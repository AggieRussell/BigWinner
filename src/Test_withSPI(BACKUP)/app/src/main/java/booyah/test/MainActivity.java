package booyah.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);
      //  db = new DBHelper(this);
      //  NFLPresenter p = new NFLPresenter();
     //   p.setDb(db);
    //    NFLModel m = new NFLModel();
        NFLView v = new NFLView();
    //    v.start();
    //    p.run();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
