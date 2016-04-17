package booyah.test;

/**
 * Created by Christine on 4/16/16.
 */

import static java.lang.System.out;

public class NFLModel {

    private String user;
    private String season;

    public NFLModel() {
        user = ".";
        season = ".";
        out.printf("user: %s\nseason: %s\n", user, season);
    }

    public NFLModel(String u, String s) {
        setUser(u);
        setSeason(s);
        out.printf("user: %s\nseason: %s\n", user, season);
    }

    public void setUser(String u) {
        user = u;
        out.println("model user set");
    }

    public void setSeason(String s){
        season = s;
        out.println("model season set");
    }

    public String getUser() {
        return user;
    }

    public String getSeason() {
        return season;
    }
}
