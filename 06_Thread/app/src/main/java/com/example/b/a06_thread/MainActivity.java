package com.example.b.a06_thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnTread;
    class MyThread extends Thread {

        @Override
        public void run(){
            for(int i =0;i<100;i++)
            {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("MyThread","Count:"+i);
                btnTread.setText("Thread Count : "+i);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(btnTread ==null)
        {
            btnTread = (Button) findViewById(R.id.btnThead);
        }
    }

    //단점 Fragmenet에서는 사용할수 없다...
    //Activity에서만 사용가능하다.
    public void onBtnClick(View v){

//        MyThread th = new MyThread();
//        th.start();

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0;i<100;i++)
                {
                    try {
                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d("MyThread","Count:"+i);

                    btnTread.setText("Thread Count : "+i);
                }
            }
        });
        th2.start();

    }

}
