package com.mak.listwebviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class SecondActivity extends Activity{
	
	WebView web1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.second_activity);
	    String value=getIntent().getExtras().getString("mak");
	    web1=(WebView)findViewById(R.id.webView1);
	    web1.getSettings().setJavaScriptEnabled(true);
	    web1.getSettings().setBuiltInZoomControls(true);
	 

		if(value.equals("CUET"))
		{
			
			 web1.loadUrl("http://www.cuet.ac.bd");
		}
		else if(value.equals("BUET"))
		{
			 web1.loadUrl("http://www.buet.ac.bd");
			
		}
	
		else if(value.equals("KUET"))
		{
			 web1.loadUrl("http://www.kuet.ac.bd");
			
		}
	
		else if(value.equals("RUET"))
		{
			
			 web1.loadUrl("http://www.ruet.ac.bd");
		}
	
		else if(value.equals("DU"))
		{
			
			 web1.loadUrl("http://www.du.ac.bd");
		}
		else if(value.equals("SUST"))
		{
			 web1.loadUrl("http://www.sust.edu");
			
		}
	
	
	}

}
