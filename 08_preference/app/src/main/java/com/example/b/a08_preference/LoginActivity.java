package com.example.b.a08_preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences pref;
    String idStr;
    String pwStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pref = getSharedPreferences("MySetting",0);
        idStr = pref.getString("id","NO DATA");
        pwStr = pref.getString("pw","NO DATA");
        Toast.makeText(LoginActivity.this, "Hello!! 안녕하세요", Toast.LENGTH_SHORT).show();


        EditText editText = (EditText) findViewById(R.id.saveTxt);
        editText.setText("id : "+idStr+", pw : "+pwStr);

    }

    public void onButton2Clicked(View v){
        if(idStr !="" && pwStr !="")
        {
            pref.getString("id","NO DATA");
            pref.getString("pw","NO DATA");
            SharedPreferences.Editor editor = pref.edit();
            editor.clear();
            editor.commit();
            finish();
        }
    }
}
