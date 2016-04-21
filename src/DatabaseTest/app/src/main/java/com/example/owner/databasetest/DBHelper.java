package com.example.owner.databasetest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "NFLStats.db";
    //private static final String DATABASE_NAME = "northwind.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = getReadableDatabase();
        db.close();
        // you can use an alternate constructor to specify a database location
        // (such as a folder on the sd card)
        // you must ensure that this folder is available and you have permission
        // to write to it
        //super(context, DATABASE_NAME, context.getExternalFilesDir(null).getAbsolutePath(), null, DATABASE_VERSION);

    }

    public Cursor getEmployees() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"0 _id", "Week", "Home", "Away"};
        String sqlTables = "Season2015";
        //String [] sqlSelect = {"0 _id", "FirstName", "LastName"};
        //String sqlTables = "Employees";
        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, "Week=1", null,
                null, null, null);

        c.moveToFirst();
        return c;

    }

}