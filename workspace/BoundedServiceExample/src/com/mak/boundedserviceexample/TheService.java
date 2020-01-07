package com.mak.boundedserviceexample;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class TheService extends Service //arekta cls toiri kore oita diye data adan prodan korbo
{
private final IBinder myBinder=new MyLocalBinder();
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		
		Toast.makeText(getApplicationContext(), "kaj korse", Toast.LENGTH_SHORT).show();
		return myBinder;
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "created", Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "destroyed", Toast.LENGTH_SHORT).show();
		MainActivity.isBound=false;
	}
	public String getTime()
	{
		Calendar c=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("dd:MMMM:yyyy HH:mm:ss a");
		String time=sdf.format(c.getTime());
		return time;
	}
	
	public class MyLocalBinder extends Binder
	{
		public TheService getService() {
			// TODO Auto-generated method stub

			return TheService.this;
		}
		
	}
	
	

}
