package com.mak.webviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;

public class MainActivity extends Activity {
	WebView web1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web1=(WebView)findViewById(R.id.webView1);
        web1.getSettings().setJavaScriptEnabled(true);
        web1.getSettings().setBuiltInZoomControls(true);
        //web1.loadUrl("file:///android_asset/webpages/index.html"); //asset hobe assets na
        web1.loadUrl("https://www.google.com.bd");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
