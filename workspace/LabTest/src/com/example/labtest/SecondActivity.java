package com.example.labtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {

	Button btnLogin, btnReg;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);

		btnLogin = (Button) findViewById(R.id.btnLog);
		btnReg = (Button) findViewById(R.id.button2);

		btnLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub

				Intent intent = new Intent(SecondActivity.this, ActivityLogin.class);
				startActivity(intent);

			}
		});

		btnReg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub

				Intent intent = new Intent(SecondActivity.this, ActivityRegister.class);
				startActivity(intent);

			}
		});
	}

}
