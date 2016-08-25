package com.example.b.a03_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Intent intent = getIntent();
//        String extraStr = intent.getExtras().get("id").toString();
        String extraStr = intent.getStringExtra("id");

        Toast.makeText(MyActivity.this, "id : "+extraStr, Toast.LENGTH_SHORT).show();
    }
}
