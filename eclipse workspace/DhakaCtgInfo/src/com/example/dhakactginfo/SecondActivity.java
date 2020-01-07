package com.example.dhakactginfo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        
		String value = getIntent().getExtras().getString("city");
		//Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
		
		TextView txtCity = (TextView)findViewById(R.id.textCity);
		TextView txtArea = (TextView)findViewById(R.id.textArea);
		TextView txtPopulation = (TextView)findViewById(R.id.textPopulation);
		TextView txtMale = (TextView)findViewById(R.id.textMale);
		TextView txtFemale = (TextView)findViewById(R.id.textFemale);
		
		
		if(value.equals("dhaka"))
		{
			txtCity.setText("DHAKA");
			txtArea.setText("816 squre km");
			txtPopulation.setText("15 milion");
			txtMale.setText("56%");
			txtFemale.setText("44%");
		}
		else
		{
			txtCity.setText("CHITTAGONG");
			txtArea.setText("157 squre km");
			txtPopulation.setText("5 milion");
			txtMale.setText("52%");
			txtFemale.setText("48%");
		}
	};
}
