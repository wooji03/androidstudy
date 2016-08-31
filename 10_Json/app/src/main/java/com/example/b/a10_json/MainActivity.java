package com.example.b.a10_json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    String str ="[{'name':'kim','tel':'010-1111-1111'},"+
            "{'name':'park','tel':'010-2222-2222'},"+
            "{'name':'lee','tel':'010-3333-3333'}]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //localJsonTest();
        internetJsonTest();

    }

    private void internetJsonTest(){
        //많이쓰는 json 파서
        //json 파서는 번거롭다.
        //gson json parsar
        //volley json parsar
        //Loopj Async-HttpClient 올드하지만 많이쓴이고 있고 http://loopj.com/android-async-http/
        //상단바 Setting아이콘 옆에 project structure app<depandance + loopj 검색 추가
        //build.gradle(Module)에 추가가 된다.

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://api.androidhive.info/contacts/",new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                TextView textView = (TextView) findViewById(R.id.textView);
                try {
                    String strRes2="";
                    JSONArray array = response.getJSONArray("contacts");
                    for(int i = 0;i<array.length();i++)
                    {
                        JSONObject obj = array.getJSONObject(i);
                        String name = obj.getString("id");
                        String tel = obj.getString("name");
                        strRes2+="Name : "+name+", email : "+tel+"\n";
                    }
                    textView.setText(strRes2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("JsonContacts",response.toString());
            }
        });
    }

    private void localJsonTest(){
        TextView textView = (TextView) findViewById(R.id.textView);
        try {

            String strRes="";

            JSONArray array = new JSONArray(str);

            for(int i = 0;i<array.length();i++)
            {
                JSONObject obj = array.getJSONObject(i);
                String name = obj.getString("name");
                String tel = obj.getString("tel");
                strRes+="Name : "+name+", tel : "+tel+"\n";
            }

            textView.setText(strRes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
