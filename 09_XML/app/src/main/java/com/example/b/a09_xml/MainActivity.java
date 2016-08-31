package com.example.b.a09_xml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {





    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        //인터넷으로 하는것들은 스레드를 하는것이 좋다..
        //에러로 처리할수도 있다.

        //MyDomParser parser = new MyDomParser(textView);
        MyPullParser parser = new MyPullParser(textView);
        parser.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4119055000");
        //AsyncTask<String, Void, Document>로 넘어가는 값값

    }
}
