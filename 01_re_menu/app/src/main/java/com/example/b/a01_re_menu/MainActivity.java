package com.example.b.a01_re_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //getMenuInflater().inflate(R.menu.menu_name,menu); 이런방식도 가능
        //다른방법으로 해보자..

        menu.add(0,100,0,"context menu1");
        menu.add(0,101,0,"context menu2");


        //sdfsdfsfsdfsdfs

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == 100)
        {
            Toast.makeText(MainActivity.this, "context 1 selected", Toast.LENGTH_SHORT).show();

        }else if(item.getItemId() == 101){

            Toast.makeText(MainActivity.this, "context 2 selected", Toast.LENGTH_SHORT).show();
        }
        return true;
        //return super.onContextItemSelected(item); item이 없을때
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_name,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_test1)
        {
            Toast.makeText(MainActivity.this, "menu 1 selected", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.menu_test2)
        {
            Toast.makeText(MainActivity.this, "menu 2 selected", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.menu_test3)
        {
            Toast.makeText(MainActivity.this, "menu 3 selected", Toast.LENGTH_SHORT).show();
        }
        return true;
        //return super.onOptionsItemSelected(item);
    }
}
