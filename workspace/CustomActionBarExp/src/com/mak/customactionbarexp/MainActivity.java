package com.mak.customactionbarexp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        LayoutInflater inflater= LayoutInflater.from(MainActivity.this);
        
        View view=inflater.inflate(R.layout.custom_layout, null);
        ImageButton imgCall=(ImageButton)view.findViewById(R.id.imgCall);
        ImageButton imgSend=(ImageButton)view.findViewById(R.id.imgSend);
        ImageButton imgMail=(ImageButton)view.findViewById(R.id.imgMail);
    
    imgCall.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "call is called!", Toast.LENGTH_SHORT).show();
		}
	});
    imgSend.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "send is called!", Toast.LENGTH_SHORT).show();
		}
	});
    
    imgMail.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "mail is called!", Toast.LENGTH_SHORT).show();
		}
	});
    
    actionBar=getSupportActionBar();
    actionBar.setDisplayShowTitleEnabled(false);
    actionBar.setDisplayShowHomeEnabled(false);
    actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
    actionBar.setCustomView(view, new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
    
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
