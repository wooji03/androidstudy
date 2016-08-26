package com.example.b.a04_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            //parent가 listview , layout이 view ,position이 아이템 위에서부터 0~9... , id
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String myStr = myData[position].toString();
                Toast.makeText(MainActivity.this, "MyData Item : "+myStr, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
