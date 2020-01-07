package com.mak.labproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity {
	Button login,register;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_layout);
		login=(Button)findViewById(R.id.button1);
		register=(Button)findViewById(R.id.button2);
		
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "mak", Toast.LENGTH_SHORT).show();
				
				Intent intent1 = new Intent(SecondActivity.this,LoginActivity.class);
					
					startActivity(intent1);
			}
		});
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent intent = new Intent(SecondActivity.this,RegisterActivity.class);
					
					startActivity(intent);
			}
		});
	}

}
