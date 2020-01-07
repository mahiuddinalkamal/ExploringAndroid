package com.example.labtest;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityWeb extends Activity {

	WebView web;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);

		String value = getIntent().getExtras().getString("site");

		web = (WebView) findViewById(R.id.webView1);

		web.getSettings().setJavaScriptEnabled(true);
		web.getSettings().setBuiltInZoomControls(true);
		web.setWebViewClient(new WebViewClient());

		web.loadUrl("http://www."+value+".com/");
	}

}
