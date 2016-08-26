package com.example.b.a05_listview2_custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MyData> list = new ArrayList<MyData>();

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        for(int i =0;i<30;i++)
        {
            list.add(new MyData(R.mipmap.ic_launcher,"Title"+i,"desc"+i));
        }

        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);

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


        //재활용하는 데이타를 셋팅해주는...
        //convertView. itemView를 말한다. 최초에는 null로 들어온다..
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //return null;
            if(convertView == null)
            {
                convertView = getLayoutInflater().inflate(R.layout.item_view,null);
            }


            //Toast.makeText(convertView, "Position : "+position, Toast.LENGTH_SHORT).show();
            Log.d("ConverView","ConverView"+position);

            MyData myData = list.get(position);

            //에러가 안다...  findViewByid에러난다...이건 onCreate에서(AppCompatActivity)
            //넘어온 convertView.에서 찾는다..
            TextView titleTextView = (TextView) convertView.findViewById(R.id.titleView);
            TextView descTextView = (TextView) convertView.findViewById(R.id.descView);
            ImageView iconView = (ImageView) convertView.findViewById(R.id.iconView);

            titleTextView.setText(myData.title);
            descTextView.setText(myData.desc);
            iconView.setImageResource(myData.imgId);

            return convertView;
        }

    }


}
