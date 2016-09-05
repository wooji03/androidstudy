package com.example.b.a13_mediaplayer_rere;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.listView);
        String path = Environment.getExternalStorageDirectory()+"/Download";
        File dir = new File(path);
        File[] files = dir.listFiles();
        for(int i=0; i<files.length; i++){
            String fileName = files[i].getName();
            if(fileName.endsWith(".mp3")) {
                list.add(fileName);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, list
        );

        listView.setAdapter(adapter);
    }
}
