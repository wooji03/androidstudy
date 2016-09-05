package b.example.com.a13_mediaplayer_2;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path = Environment.getExternalStorageDirectory()+"/Download";
        File dir = new File(path);
        File[] files = dir.listFiles();
        for(int i=0; i<files.length; i++){
            String fileName = files[i].getName();
            if(fileName.endsWith(".mp3")) {
                list.add(fileName);
            }
        }
    }
}
