package b.example.com.a16_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by maxdream on 2016-09-07.
 */
public class MyService extends Service {
    public MyService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service", "onCreate()");
        Toast.makeText(MyService.this, "service : onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("service", "onDestroy()");
        Toast.makeText(MyService.this, "service : onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service", "onStartCommand()");
        Toast.makeText(MyService.this, "service : onStartCommand()", Toast.LENGTH_SHORT).show();
        return START_NOT_STICKY;
    }
}
