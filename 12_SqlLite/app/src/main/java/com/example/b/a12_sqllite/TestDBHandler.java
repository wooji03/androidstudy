package com.example.b.a12_sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by b on 2016-09-01.
 */
public class TestDBHandler {
    TestSQLliteOpenHelper helper;

    public TestDBHandler(Context context){
        //디비를만든다...
        helper = new TestSQLliteOpenHelper(context,"people",null,1);
    }

    public void insert(String name, String address, int age){

        SQLiteDatabase db = helper.getWritableDatabase();//락을걸고 락을 풀어주는 역할을 한다.
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("address",address);
        values.put("age",age);

        db.insert("student",null,values);
    }

    public void delete(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        //?에 대응하는게 조건이다.
        db.delete("student","name = ?", new String[]{name});
    }


}
