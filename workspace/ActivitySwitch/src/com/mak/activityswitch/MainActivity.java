package com.mak.activityswitch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button button;
	TextView text;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button1);
        text=(TextView)findViewById(R.id.textView1);
        
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				/* String fromTextView= text.getText().toString();
				Toast.makeText(getApplicationContext(), fromTextView, Toast.LENGTH_LONG).show();
				text.setText("ami kamal"); */
             
				
                /*Intent intent = new Intent(MainActivity.this,SecondActivity.class);
				intent.putExtra("mak","this is my name");
				startActivity(intent);*/

				
				//implicit intent
				
				Intent intent=new Intent("com.mak.activityswitch.LAUNCH",Uri.parse("http://www.fb.com")); //intent ar obj create korlam//by default class hisebe ney
				
				startActivity(intent);
				
			}
		});
    
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
