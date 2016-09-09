package com.example.b.a22_location_home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by b on 2016-09-01.
 */
public class TestDBHandler {

    TestSQLliteOpenHelper helper;

    public TestDBHandler(Context context){
        helper = new TestSQLliteOpenHelper(context, "myTracker", null, 1);
    }

    public void insert(long timestamp, double latitude, double longitude){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("timestamp", timestamp);
        values.put("latitude", latitude);
        values.put("longitude", longitude);

        db.insert("location", null, values);
    }


    public String showAllData(){
        SQLiteDatabase db = helper.getReadableDatabase();

        String str = "";
        Cursor c = db.query("location", null, null, null, null, null, null);
        while(c.moveToNext()){
            long timestamp = c.getLong(c.getColumnIndex("timestamp"));
            double latitude = c.getDouble(c.getColumnIndex("latitude"));
            double longitude = c.getInt(c.getColumnIndex("longitude"));

            str += "\ntimestamp : "+timestamp+
                    " latitude : "+latitude+" longitude : "+longitude;

            Log.d("sqlite", "timestamp : "+timestamp+
                    " latitude : "+latitude+" longitude : "+longitude);
        }
        return str;
    }
}
