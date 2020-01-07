package com.mak.secondproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button1); 
        
        Toast.makeText(getApplicationContext(), "OnCreate", Toast.LENGTH_LONG).show();
        //just akta button kaj koranor jonno
       /*button.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 	  Toast.makeText(getApplicationContext(), "button pressed", Toast.LENGTH_LONG).show();
			 
			
		}
	});*/
        //akadhik button kaj koranor jonno
        button.setOnClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	  Toast.makeText(getApplicationContext(), "OnStart", Toast.LENGTH_LONG).show();
    }
   
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	  Toast.makeText(getApplicationContext(), "OnResume", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	  Toast.makeText(getApplicationContext(), "OnPause", Toast.LENGTH_LONG).show();
    	super.onPause();
    	
    }
    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	 Toast.makeText(getApplicationContext(), "OnStop", Toast.LENGTH_LONG).show();
    	super.onStop();
    	 
    }
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	  Toast.makeText(getApplicationContext(), "OnDestroy", Toast.LENGTH_LONG).show();
    	super.onDestroy();
    	
    }


	@Override //implement korar karone abstract method take define korte hoise
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==R.id.button1)
		{
			 Toast.makeText(getApplicationContext(), "button pressed", Toast.LENGTH_LONG).show();
			return;
		}
	}
	
    
}
