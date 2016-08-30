package com.example.b.a06_thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private static final int MYTHREAD = 100;
    Button btn;
    ProgressBar progressBar;
    class MyThread extends Thread {

        @Override
        public void run(){
            for(int i=0; i<100; i++){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("MyThread", "count : "+i);
//                btn.setText("count : "+i);
                Message msg = handler.obtainMessage(); //new Message();
                msg.what = MYTHREAD;
                msg.arg1 = i;
                handler.sendMessage(msg);
            }
        }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == MYTHREAD){
                btn.setText("count : "+msg.arg1);
                progressBar.setProgress(msg.arg1);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    //단점 Fragmenet에서는 사용할수 없다...
    //Activity에서만 사용가능하다.
    public void onBtnClick(View v){

//        MyThread th = new MyThread();
//        th.start();

        MyThread th = new MyThread();
        th.start();

    }

}
