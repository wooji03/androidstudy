package com.example.b.a23_notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onBtnClicked(View v){
        //이곳에 스레드3초후에 작동를 하게 한다면..
        // 여기서 생성해서하면 버튼이 눌린채 3초후에 작동하기때문에
        //사용자들은 멈췄다고 생각하낟..
        //따로 스레드를 빼서 진행을 하던가 다른 작업이 필요하다.
        //간단한 방법으로는 3초후에 진행하는 매소드다.
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                intent.putExtra("Notification",100);

                //PendingIntent 안드로이드에서 관리하는 Notifications이다..
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                //리소스를 이용ㅇ한다..getResources()

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.tulips);

                Notification notification = new NotificationCompat.Builder(MainActivity.this)
                        .setContentTitle("상태바 드래그시 보이는 타이틀")
                        .setContentText("상태바 드래그시 보이는 서브타이틀")
                        .setTicker("상태바 한줄 메시지")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(bitmap)
                        .setContentIntent(pIntent)
                        .setAutoCancel(true)
                        .build();

                manager.notify(1234, notification);



            }
        },3000);
    }
}
