package com.example.b.a08_preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences pref = getSharedPreferences("MySetting",0);
        String idStr = pref.getString("id","NO DATA");
        String pwStr = pref.getString("pw","NO DATA");
        Toast.makeText(LoginActivity.this, "Hello!! 안녕하세요", Toast.LENGTH_SHORT).show();


        EditText editText = (EditText) findViewById(R.id.saveTxt);
        editText.setText("id : "+idStr+", pw : "+pwStr);

    }
}
