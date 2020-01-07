package com.mak.customrecieverexample;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView txt;
	Button btn;
	EditText edit;
	
	CustomReceiver myReceiver;
	String action="custom_event";
	IntentFilter filter; //atar majhe action ke reg kori

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.textView1);
        btn=(Button)findViewById(R.id.button1);
        edit=(EditText)findViewById(R.id.editText1);
        
       myReceiver=new CustomReceiver();
        filter=new IntentFilter(action);
        
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(action);
				String data="";
				data=edit.getText().toString();
				if(data.equals(""))
				{
					Toast.makeText(getApplicationContext(), "please input something!!", Toast.LENGTH_SHORT).show();
				}
				else {
					
					intent.putExtra("mak", data);
					sendBroadcast(intent);
					
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
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	registerReceiver(myReceiver, filter);
    }
    
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	unregisterReceiver(myReceiver);
    	
    }
    
    class CustomReceiver extends BroadcastReceiver{  //inner cls bole akhanei ake reg korbo

		@Override
		public void onReceive(Context arg0, Intent in) {
			// TODO Auto-generated method stub
			if(in.getAction().equals(action))
			{
				String data2=in.getExtras().getString("mak");
				txt.setText("Received Brodcast: "+data2);
			}
			
		}
    	
    	
    } 
    
}
