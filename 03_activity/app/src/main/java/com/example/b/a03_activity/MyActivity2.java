package com.example.b.a03_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my2);

        Intent intent = getIntent();
//        String extraStr = intent.getExtras().get("id").toString();
        String extraStr = intent.getStringExtra("id");

        Toast.makeText(MyActivity2.this, "id : "+extraStr, Toast.LENGTH_SHORT).show();

        Button btnFinish = (Button) findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("My Result","qwerasdfzxcv");
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
    }
}
