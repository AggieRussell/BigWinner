package com.example.owner.databasetest;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.*;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView score = (TextView) findViewById(R.id.textView);
        DBHelper db = new DBHelper(this);
       // List<Column> out = db.select("2015", 1);
        Cursor out = db.select("2015",1);
        out.moveToFirst();
        String output = out.getString(out.getColumnIndex("Home"));
        score.setText(output);

    }
}
