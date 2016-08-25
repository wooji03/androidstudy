package com.example.b.a02_widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = (Button) findViewById(R.id.btnHello);
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Widget","Button Click");
            }
        });

        CheckBox checkBox = (CheckBox) findViewById(R.id.myCheckBox);
//        checkBox.setOnClickListener(new);
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
