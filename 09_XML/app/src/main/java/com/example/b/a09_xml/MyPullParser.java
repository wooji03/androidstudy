package com.example.b.a09_xml;

import android.os.AsyncTask;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;

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
        String strUrl =params[0];
        String strRes ="";

        try {

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new URL(strUrl).openStream(),"utf-8");

            int evenType = xpp.getEventType();
            boolean bRead = false;
            //문서끝까지 루프
            while (evenType != XmlPullParser.END_DOCUMENT)
            {
                switch (evenType)
                {
                    case XmlPullParser.START_TAG:
                        String tagName = xpp.getName();
                        if(tagName.equals("hour") || tagName.equals("day") || tagName.equals("temp") || tagName.equals("wfKor"))
                        {
                            strRes += tagName + " ";
                            bRead = true;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if(xpp.getName().equals("wfKor"))
                        {
                            strRes += "\n";
                        }
                        break;
                    case XmlPullParser.TEXT:
                        if(bRead)
                        {
                            bRead = false;
                            strRes+= xpp.getText()+", ";
                        }
                        break;
                }
                evenType = xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strRes;
    }
}
