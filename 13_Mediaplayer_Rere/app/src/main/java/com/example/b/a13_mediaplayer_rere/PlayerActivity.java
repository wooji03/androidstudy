package com.example.b.a13_mediaplayer_rere;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PlayerActivity extends AppCompatActivity {

    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }

    public void onPlayClick(View v){
        stopMP();
        mp = new MediaPlayer();
        mp.setDataSource();
        mp.prepare();
        mp.start();
    }

    public void onStopClick(View v){
        stopMP();
    }

    private void stopMP(){
        if (mp != null) {

            mp.stop();
            mp.release();
            mp = null;

        }
    }

}
