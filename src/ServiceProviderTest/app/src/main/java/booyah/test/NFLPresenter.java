package booyah.test;

/**
 * Created by Christine on 4/16/16.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Application;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import static java.lang.System.out;

public class NFLPresenter extends Application {

    //NFLView v;
    NFLModel m;

    int x;

    public NFLPresenter(){
    //    v = new NFLView();
        m = new NFLModel();
        x=0;
        out.printf("pres x = %d\n", x);
    }

    public void setM(String u, String s) {
        m.setUser(u);
        m.setSeason(s);
        out.println("pres setM");
    }

    public String getUser() {
        out.println("pres getUser");
        return m.getUser();
    }

    public String getSeason() {
        out.println("pres getSeason");
        return m.getSeason();
    }

}
