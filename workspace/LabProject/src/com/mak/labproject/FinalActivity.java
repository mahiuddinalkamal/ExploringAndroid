package com.mak.labproject;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FinalActivity  extends Activity{
	
	WebView web1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_layout);
		
	    String value=getIntent().getExtras().getString("mak");
	    
	    web1=(WebView)findViewById(R.id.webView1);
	    
	    web1.getSettings().setJavaScriptEnabled(true);
	    web1.getSettings().setBuiltInZoomControls(true);
	    web1.setWebViewClient(new WebViewClient());

	    web1.loadUrl("http://www."+value+".com/");
	    
		
	
	}
}
