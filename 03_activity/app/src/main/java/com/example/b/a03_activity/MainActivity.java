package com.example.b.a03_activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_REQ_NUM = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myActivityBtn1 = (Button) findViewById(R.id.myActivityBtn1);
        myActivityBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent intent = new Intent(MainActivity.this,MyActivity.class);
                intent.putExtra("id","Maxdream");
                startActivity(intent);

            }
        });

        Button myActivityBtn2 = (Button) findViewById(R.id.myActivityBtn2);
        myActivityBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-9990-5409"));;
                startActivity(intent);

            }
        });

        Button myActivityBtn3 = (Button) findViewById(R.id.myActivityBtn3);
        myActivityBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));;
                startActivity(intent);

            }
        });
        Button myActivityBtn4 = (Button) findViewById(R.id.myActivityBtn4);
        myActivityBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent intent = new Intent(MainActivity.this,MyActivity2.class);
                intent.putExtra("id","Maxdream");
                startActivityForResult(intent,MY_REQ_NUM);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        //Activity가 많을때는 이런방법으로...확인을 하고 진행
        if(requestCode == MY_REQ_NUM){
            if(resultCode == RESULT_OK){
                String strResult = data.getStringExtra("My Result");
                Toast.makeText(MainActivity.this, "My Result : "+strResult, Toast.LENGTH_SHORT).show();
            }
        }

    }
}
