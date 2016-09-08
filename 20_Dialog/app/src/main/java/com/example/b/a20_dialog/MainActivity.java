package com.example.b.a20_dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int MY_DIALLOG = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == MY_DIALLOG){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("App Exit");
            builder.setMessage("앱을 종료하시겠습니까?");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setCancelable(false);//화면박을 눌렀을때 반응안하게 한다.
            builder.setNeutralButton("Don't Read Late", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setView(R.layout.dialog_layout);
            return builder.create();
        }
        return null;
    }

    public void onBtnClicked(View v){
        //showDialog(R.id.onBtn);
        showDialog(MY_DIALLOG);
    }
}
