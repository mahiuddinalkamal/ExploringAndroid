package com.mak.alarmmanagerexample;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;

public class MainActivity extends Activity { //intent holo akta msg obj jar maddhome akta activity arekta activity ke 
	                                         //akta request pathay kono akta action complete korar jonno
                                             //pending intent a akta time set kora thakbe jottokkhn na 
	                                        //oi time a pouchabe totokkhon porjonto se intent take pending rakhbe
	TimePicker timePicker;
    Button setAlarm,removeAlarm;
    
    PendingIntent pending;
	int id;
	String action="com.mak.alarmmanagerexample.ALARM";
	AlarmManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker=(TimePicker)findViewById(R.id.timePicker1);
        setAlarm=(Button)findViewById(R.id.button1);
        removeAlarm=(Button)findViewById(R.id.button2);
        
        manager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
        id=0;
    	Intent intent=new Intent(action);
        pending=PendingIntent.getBroadcast(getApplicationContext(), id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        
        
        setAlarm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int min=timePicker.getCurrentMinute(); //akhane time ta 24 format return korbe
				int hour=timePicker.getCurrentHour();
				
				Calendar calendar=Calendar.getInstance();
				calendar.set(Calendar.HOUR_OF_DAY, hour);
				calendar.set(Calendar.MINUTE, min);
				calendar.set(Calendar.SECOND,0);
				
				manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pending);
				
			}
		});
        
        removeAlarm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				manager.cancel(pending);
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
