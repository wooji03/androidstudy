package com.example.b.a13_mediaplayer_rere;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class PlayerActivity extends AppCompatActivity {

    MediaPlayer mp = null;
    String filePath ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        filePath = getIntent().getStringExtra("path").toString();
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(filePath);
        Toast.makeText(PlayerActivity.this, filePath, Toast.LENGTH_SHORT).show();
    }

    public void onPlayClick(View v){
        stopMP();
        mp = new MediaPlayer();
        try {
            mp.setDataSource(filePath);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
