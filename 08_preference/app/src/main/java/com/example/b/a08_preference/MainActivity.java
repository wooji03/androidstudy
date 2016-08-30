package com.example.b.a08_preference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getPreferences("MySetting",0);
        String str = pref.getString("id","NO DATA");
        Toast.makeText(MainActivity.this, "str : "+str, Toast.LENGTH_SHORT).show();

        SharedPreferences.Editor editor = pref.edit();
        editor.putString("id","abc");

        editor.commit();
    }

}
