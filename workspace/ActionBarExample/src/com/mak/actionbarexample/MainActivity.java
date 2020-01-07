package com.mak.actionbarexample;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	Button show,hide,change;
	ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    show=(Button)findViewById(R.id.button2);
    hide=(Button)findViewById(R.id.button3);
    change=(Button)findViewById(R.id.button1);
    
    actionBar=getSupportActionBar();
    
    show.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			actionBar.show();
		}
	});
    
    hide.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			actionBar.hide();
		}
	});
    
	change.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			actionBar.setIcon(R.drawable.call);
			actionBar.setTitle("new action bar");
			actionBar.setSubtitle("subtitle");
		}
	});
	
	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	switch(item.getItemId())
    	{
    	case R.id.call:
    	    Toast.makeText(getApplicationContext(), "Call item selected", Toast.LENGTH_SHORT).show();
    	    return true;
    	case R.id.mail:
    		Toast.makeText(getApplicationContext(), "Mail item selected", Toast.LENGTH_SHORT).show();
    		return true;
    	case R.id.send:
    		Toast.makeText(getApplicationContext(), "Send item selected", Toast.LENGTH_SHORT).show();
    		return true;
    	default:
    		return super.onOptionsItemSelected(item);
    	
    	
    	
    	}
    }
    
}
