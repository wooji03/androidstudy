package com.example.b.a09_xml;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    class MyDomParser extends AsyncTask<String, Void, Document>{

        //Execute끝났을떄
        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);

            //data이름을 가지고 있는 엘리먼트들을...getElementsByTagName
            NodeList nodeList = document.getElementsByTagName("data");

            for(int i=0;i<nodeList.getLength();i++)
            {
                Element element = (Element)nodeList.item(i);
                NodeList hourNodeList = element.getElementsByTagName("hour");
                Element hourElement = (Element)hourNodeList.item(0);
                NodeList textNodeList = hourElement.getChildNodes();
                String strHour = textNodeList.item(0).getNodeValue();


            }

        }

        @Override
        protected Document doInBackground(String... params) {
            String strUrl = params[0];
            URL url =null;
            Document doc = null;

            try {
                url = new URL(strUrl);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();//안드로이드 시스템
                DocumentBuilder db = dbf.newDocumentBuilder();

                doc = db.parse(url.openStream());

            } catch (Exception error){
                error.printStackTrace();
            }

            return doc;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //인터넷으로 하는것들은 스레드를 하는것이 좋다..
        //에러로 처리할수도 있다.

        MyDomParser parser = new MyDomParser();

        //AsyncTask<String, Void, Document>로 넘어가는 값값
        parser.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4119055000");

    }
}
