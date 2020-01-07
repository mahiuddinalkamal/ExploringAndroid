package com.mak.sensorcheckerexample;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Button checkAll;
	TextView text;
	
	SensorManager manager;
	
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        checkAll=(Button)findViewById(R.id.button1);
        text=(TextView)findViewById(R.id.textView1);
        manager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        
        checkAll.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				List<android.hardware.Sensor> allSensors= manager.getSensorList(Sensor.TYPE_ALL);
				String text1="";
				for(int i=0;i<allSensors.size();i++)
				{
				  String name=allSensors.get(i).getName();
				  text1+=name+"\n\n";
					
				}
				text.setText(text1);
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
