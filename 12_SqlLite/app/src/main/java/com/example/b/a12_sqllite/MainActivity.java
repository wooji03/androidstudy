package com.example.b.a12_sqllite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);

        TestDBHandler testDBHandler = new TestDBHandler(this);
        testDBHandler.insert("kim","서울",20);
        testDBHandler.insert("jang","인천",29);
        testDBHandler.insert("park","경기",33);

        String strRet = testDBHandler.showAllData();
        textView.setText(strRet);

        testDBHandler.delete("park");

        String strRet2 = testDBHandler.showAllDataResult();
        textView.setText(strRet2);
        //Sugar ORM
        //realm realm.io//자체디비를 쓰게 되고
        //

    }
}
