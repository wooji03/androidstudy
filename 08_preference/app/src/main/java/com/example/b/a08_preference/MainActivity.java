package com.example.b.a08_preference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    EditText myIdTxt;
    EditText myPwTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //자기자신만 접근....xml형식...
        pref = getSharedPreferences("MySetting",0);
        String saveId = pref.getString("id","NO DATA");
        String savePw =  pref.getString("pw","NO DATA");
        //Toast.makeText(MainActivity.this, "str : "+str, Toast.LENGTH_SHORT).show();

        //pref 에 저장하는게 아니라...editor에 저장 하는...

        //
        myIdTxt = (EditText) findViewById(R.id.myId);
        myPwTxt = (EditText) findViewById(R.id.myPw);

        if(saveId !="NO DATA" && savePw !="NO DATA")
        {
            Toast.makeText(MainActivity.this, "자동로그인", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }


    }

    public void onButton1Clicked(View v){

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);



        SharedPreferences.Editor editor = pref.edit();
        editor.putString("id",myIdTxt.getText().toString());
        editor.putString("pw",myPwTxt.getText().toString());
        editor.commit();

        myIdTxt.setText("");
        myPwTxt.setText("");
        startActivity(intent);
    }

}
