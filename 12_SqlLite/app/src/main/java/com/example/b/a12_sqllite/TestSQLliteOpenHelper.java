package com.example.b.a12_sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by b on 2016-09-01.
 */
public class TestSQLliteOpenHelper extends SQLiteOpenHelper {



    public TestSQLliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        //디비 생성
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //처음 설치될때 딱 한번 호출...
        String sql = "CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT,age INTEGER);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //변경사항이 있을때 딱 한번 호출 업데이트용...
        String sql = "DROP TABLE IF EXISTS student;";
        db.execSQL(sql);

        onCreate(db);
    }
}
