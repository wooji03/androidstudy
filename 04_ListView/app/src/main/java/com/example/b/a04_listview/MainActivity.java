package com.example.b.a04_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] myData = {"Hello","World","Orcale","Java",
            "Hello","World","Orcale","Java",
            "Hello","World","Orcale","Java",
            "Hello","World","Orcale","Java",
            "Hello","World","Orcale","Java"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //android.R.layout.simple_expandable_list_item_1,
        //android가 붙으면 안드로이드 시스템영역..없으면 레이어영역
        //AppData\Local\Android\sdk\platforms\android-23\data\res\layout
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                myData);

        listView.setAdapter(adapter);
    }
}
