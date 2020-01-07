package com.mak.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class TheService extends Service{

	@Override
	public IBinder onBind(Intent arg0) { //unbounded service ar jonno lagena
		// TODO Auto-generated method stub
		return null;
	}
		
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
	Toast.makeText(getApplicationContext(), "service created", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "service started", Toast.LENGTH_SHORT).show();
		return START_NOT_STICKY;
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "service destroyed", Toast.LENGTH_SHORT).show();
	}
	

}
