package com.example.b.a05_listview2_custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //inner class
    class MyData{
        public MyData(int imgId, String title, String desc) {
            this.imgId = imgId;
            this.title = title;
            this.desc = desc;
        }

        int imgId;
        String title;
        String desc;
    }

    //ArrayList<MyData> list = new ArrayList<MyData>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        for(int i =0;i<30;i++)
        {
            list.add(new MyData(R.mipmap.ic_launcher,"Title"+i,"desc"+i));
        }
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }


}
