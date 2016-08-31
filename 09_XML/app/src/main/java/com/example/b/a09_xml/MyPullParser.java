package com.example.b.a09_xml;

import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by b on 2016-08-31.
 */
public class MyPullParser extends AsyncTask<String, Void, String> {
    TextView textView;

    public MyPullParser(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
    }

    @Override
    protected String doInBackground(String... params) {
        return null;
    }
}
