package com.mak.boundedserviceexample;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mak.boundedserviceexample.TheService.MyLocalBinder;

public class MainActivity extends Activity {
	
	TheService myService;
	public static boolean isBound=false;
	
   TextView result;
   Button bind,unBind,showTime;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind=(Button)findViewById(R.id.button1);
        showTime=(Button)findViewById(R.id.button2);
        unBind=(Button)findViewById(R.id.button3);
        result=(TextView)findViewById(R.id.textView1);
        
        bind.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,TheService.class);
				bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
				
			}
		});
        
        unBind.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if(isBound)
				unbindService(myConnection);
				
				else
					Toast.makeText(getApplicationContext(), "alredy unbinded", Toast.LENGTH_SHORT).show();
			}
		});
        
        showTime.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(isBound)
				{
					String time=myService.getTime();
					result.setText(time);
					
				}
				else {
					
					result.setText("service not bounded");
				}
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
        
    
    ServiceConnection myConnection= new ServiceConnection() {
		
		@Override //unbind korle call hobena jodi service crash khay tokhn e kebol call hobe
		public void onServiceDisconnected(ComponentName arg0) { 
			
			myService=null;
			isBound=false;
			result.setText("not bounded");
		}
		
		@Override //bind korle ata call hobe
		public void onServiceConnected(ComponentName arg0, IBinder service) {
			// TODO Auto-generated method stub
			
			MyLocalBinder binder=(MyLocalBinder)service;
			
			myService=binder.getService();
			
			isBound=true;
			
			
		}
	};
	


}
