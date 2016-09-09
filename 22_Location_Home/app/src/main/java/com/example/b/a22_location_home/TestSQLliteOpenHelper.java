package com.example.b.a22_location_home;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by b on 2016-09-01.
 */
public class TestSQLliteOpenHelper extends SQLiteOpenHelper {



    public TestSQLliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                                int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE location(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "timestamp INTEGER, latitude REAL, longitude REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS location;";
        db.execSQL(sql);

        onCreate(db);
    }
}
