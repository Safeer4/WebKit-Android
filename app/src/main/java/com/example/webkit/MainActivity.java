package com.example.webkit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    //Create a WebView object;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the WebView object and point to the WebView in activity_main.xml
        webView = (WebView)findViewById(R.id.webkit);

        //Set the WebView client
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

        //We set the url which will be loaded in the webView
        webView.loadUrl("http://safeerullah.ninja/");

        //This enables javascript execution in the webView
        webView.getSettings().setJavaScriptEnabled(true);
    }

    //This method is triggered when back button of the phone is pressed.
    @Override
    public void onBackPressed() {
        //if possible, go back
        if (webView.canGoBack()) {
            webView.goBack();
        }
    }
}