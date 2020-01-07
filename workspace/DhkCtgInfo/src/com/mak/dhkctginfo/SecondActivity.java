package com.mak.dhkctginfo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;



public class SecondActivity extends Activity{
TextView txtCity,txtArea,txtPopulation,txtMale,txtFemale;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.second_activity);
	
	 // Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
	 txtCity=(TextView)findViewById(R.id.textView2);
	 txtArea=(TextView)findViewById(R.id.textView4);
	 txtPopulation=(TextView)findViewById(R.id.textView6);
	 txtMale=(TextView)findViewById(R.id.textView8);
	 txtFemale=(TextView)findViewById(R.id.textView10);
	 
	 String value=getIntent().getExtras().getString("city");
	 
	
	if(value.equals("DHAKA"))
	{
		txtCity.setText("Dhaka");
		txtArea.setText("500 square km");
		txtPopulation.setText("two crores min");
		txtMale.setText("48%");
		txtFemale.setText("52%");
		
	}
	else {
		txtCity.setText("Chittagong");
		txtArea.setText("200 square km");
		txtPopulation.setText("one crore min");
		txtMale.setText("40%");
		txtFemale.setText("60%");
		
		
	}
}
}
