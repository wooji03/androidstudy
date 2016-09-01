package com.example.b.a11_webview;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    ProgressDialog progressDialog;
    ProgressBar progressBar;
    class MyWebViewClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressDialog.dismiss();
            //progressBar.setVisibility(View.INVISIBLE);//화면에만 안보이지만 위치는 차지하고 있다
            progressBar.setVisibility(View.GONE);//완전히 사라진다.
        }
    }

    class MyWebChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            progressBar.setProgress(newProgress);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.lodingProgressbar);
        progressBar.setVisibility(View.GONE);
        progressDialog = new ProgressDialog(this);
        Button button = (Button) findViewById(R.id.btnLoad);

        //client에는 여러가지 기능이 있다..
        webView = (WebView) findViewById(R.id.webView);
        webView.setWebChromeClient(new MyWebChromeClient());
        webView.setWebViewClient(new MyWebViewClient());
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
    }

    public void onBtn1Clicked(View v){
        EditText editText = (EditText) findViewById(R.id.editUrl);
        //webView.loadUrl(editText.getText().toString());
        webView.loadUrl("http://m.naver.com");
    }
}
