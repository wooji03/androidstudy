package com.example.b.a07_asynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class MyAsyncTask extends AsyncTask<Integer, Integer, String> {
    TextView textView;

    public MyAsyncTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        textView.setText("count : "+values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Integer... params) {
        int start = params[0];
        for(int i=start; i<100; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("Asynctask", "count : "+i);
//                textView.setText("count : "+i);
            publishProgress(i);
        }

        return "AsyncTask done!!!";
    }
}
