package com.example.b.a09_loginform_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        String strId = getIntent().getStringExtra("id");
        TextView textView =(TextView) findViewById(R.id.textView);
        textView.setText("Hello "+strId);
    }
}
