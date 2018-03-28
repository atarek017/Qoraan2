package com.diesel2.ahmed.qoraan2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class webv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webv);





        WebView webView = (WebView) findViewById(R.id.webView);
/*
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setInitialScale(View.FOCUS_LEFT);

*/

        Intent data = getIntent();

        int htm=data.getExtras().getInt("html");

        int number = data.getExtras().getInt("item");
        number++;


        webView.loadUrl("file:///android_asset/html"+htm+"/" + number + ".html");



        
    }
}
