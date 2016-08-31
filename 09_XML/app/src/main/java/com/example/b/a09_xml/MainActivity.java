package com.example.b.a09_xml;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {



    class MyDomParser extends AsyncTask<String, Void, Document>{

        //Execute끝났을떄 doInBackground return 받아
        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);



//            <data seq="0">
//                <hour>21</hour>
//                <day>0</day>
//                <temp>20.0</temp>
//                <tmx>-999.0</tmx>
//                <tmn>-999.0</tmn>
//                <sky>4</sky>
//                <pty>1</pty>
//                <wfKor>비</wfKor>
//                <wfEn>Rain</wfEn>
//                <pop>56</pop>
//                <r12>0.0</r12>
//                <s12>0.0</s12>
//                <ws>7.9</ws>
//                <wd>6</wd>
//                <wdKor>서</wdKor>
//                <wdEn>W</wdEn>
//                <reh>86</reh>
//                <r06>2.636086</r06>
//                <s06>0.0</s06>
//            </data>
            //4.
            String strRes ="";
            //data이름을 가지고 있는 엘리먼트들을...getElementsByTagName
            NodeList nodeList = document.getElementsByTagName("data");

            for(int i=0;i<nodeList.getLength();i++)
            {
                Element element = (Element)nodeList.item(i);
                strRes += "Hour : "+getElementText(element,"hour")+", ";
                strRes += "Day : "+getElementText(element,"day")+", ";
                strRes += "Temp : "+getElementText(element,"temp")+", ";
                strRes += "State : "+getElementText(element,"wfKor");
                strRes += "\n";
            }
            textView.setText(strRes);

        }

        private String getElementText(Element dataElement, String tag)
        {
            NodeList hourNodeList = dataElement.getElementsByTagName(tag);
            Element hourElement = (Element) hourNodeList.item(0);
            NodeList textNodeList = hourElement.getChildNodes();
            return textNodeList.item(0).getNodeValue();
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

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        //인터넷으로 하는것들은 스레드를 하는것이 좋다..
        //에러로 처리할수도 있다.

        MyDomParser parser = new MyDomParser();

        //AsyncTask<String, Void, Document>로 넘어가는 값값
        parser.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4119055000");

    }
}
