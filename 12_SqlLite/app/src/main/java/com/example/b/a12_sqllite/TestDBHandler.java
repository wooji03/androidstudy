package com.example.b.a12_sqllite;

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
        //github clone복사 사용...해보기
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

    public void update(String name,String newAge){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age",newAge);
        db.update("student",values,"name=?",new String[]{name});
    }

    public void delete(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        //?에 대응하는게 조건이다.
        db.delete("student","name=?", new String[]{name});
    }

    public String showAllData(){
        String strRs="";
        //select * form student where id = 1;
        SQLiteDatabase db = helper.getReadableDatabase();
        //cursor BOF EOF
        // db.query( 테이블이름, * , null은 전부를 말한다.
        Cursor cs = db.query("student",null,null,null,null,null,null);
        while (cs.moveToNext())
        {
            int id = cs.getInt(cs.getColumnIndex("id"));
            String name = cs.getString(cs.getColumnIndex("name"));
            String address = cs.getString(cs.getColumnIndex("address"));
            int age = cs.getInt(cs.getColumnIndex("age"));
            Log.d("sqlite",id+". name : "+name+", address : "+address+",age : "+age);
            strRs += id+". name : "+name+", address : "+address+",age : "+age+"\n";
        }
        return strRs;
    }

    public String showAllDataResult(){

        //select * form student where id = 1;
        String strRs="";
        SQLiteDatabase db = helper.getReadableDatabase();
        //cursor BOF EOF
        // db.query( 테이블이름, * , null은 전부를 말한다.
        Cursor cs = db.query("student",null,null,null,null,null,null);
        while (cs.moveToNext())
        {
            int id = cs.getInt(cs.getColumnIndex("id"));
            String name = cs.getString(cs.getColumnIndex("name"));
            String address = cs.getString(cs.getColumnIndex("address"));
            int age = cs.getInt(cs.getColumnIndex("age"));
            Log.d("sqlite",id+". name : "+name+", address : "+address+",age : "+age);
            strRs += id+". name : "+name+", address : "+address+",age : "+age+"\n";
        }
        return strRs;
    }



}
