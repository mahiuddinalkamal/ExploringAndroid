package com.example.universitywebsite;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebsiteActivity extends Activity{
	
	WebView web;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.website_activity);
		
		web=(WebView)findViewById(R.id.webView1);
		
		web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setBuiltInZoomControls(true);
        web.setWebViewClient(new WebViewClient());
		
		String value = getIntent().getExtras().getString("key");
		
		web.loadUrl(value);
		
	}

}
