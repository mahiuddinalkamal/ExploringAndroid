package com.mak.googlemap;

import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.media.audiofx.BassBoost.Settings;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button showMap,distance,address,internet,provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    showMap=(Button)findViewById(R.id.button1);
    distance=(Button)findViewById(R.id.button2);
    address=(Button)findViewById(R.id.button3);
    internet=(Button)findViewById(R.id.button4);
    provider=(Button)findViewById(R.id.button5);
    
    showMap.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(MainActivity.this,MapActivity.class);
			startActivity(intent);
			
		}
	});
    
    distance.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			float[] results= new float[1];
			double lat1 =22.368025;
			double lat2 =22.351451;
			double lon1 =91.849106;
			double lon2 =91.852068;
			Location.distanceBetween(lat1, lon1, lat2, lon2, results);
			float xdistance=results[0]/1000; //km a convert korlam just
			Toast.makeText(getApplicationContext(), "Distance is:"+xdistance+" km", Toast.LENGTH_SHORT).show();
			
		}
	});
    
	address.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		Geocoder gcd=new Geocoder(MainActivity.this, Locale.getDefault());
		
			List<Address> addresses =null;
			
			Address addr= null;
			try{
				
				addresses=gcd.getFromLocation(22.368025, 91.849106, 1);
				if(addresses.size()>0)
				{
					
					addr=addresses.get(0);
					String info="";
					info=info+addr.getAddressLine(0); //street ar name ashbe
					info= info+" , "+addr.getLocality()+" , "+addr.getCountryName(); //locality ta method use kore korlam 
				
				Toast.makeText(getApplicationContext(), info, Toast.LENGTH_SHORT).show();
				}
				else Toast.makeText(getApplicationContext(), "Adress not found", Toast.LENGTH_SHORT).show();
			}
			catch(Exception e){
				
				Toast.makeText(getApplicationContext(), "Adress not found", Toast.LENGTH_SHORT).show();
			}
			
			
		}
	});
    
	internet.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			boolean internetStatus=isConnectingToInternet();
			if(internetStatus)
			{
				Toast.makeText(getApplicationContext(), "Internet Connction ON", Toast.LENGTH_SHORT).show();
			}
			
			else 
			{
				Intent in=new Intent(android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS);
				startActivity(in);
				
			}
		}
	});
    
    provider.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			LocationManager manager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
			boolean statusOfGps=manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            boolean statusOfNetwork=manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            if(statusOfGps) 
            	Toast.makeText(getApplicationContext(), "GpS ProvideR ON",Toast.LENGTH_SHORT).show();
            if(statusOfNetwork) 
            	Toast.makeText(getApplicationContext(), "NetWork Provider Is ON", Toast.LENGTH_SHORT).show();
		  if(statusOfGps==false || statusOfNetwork==false )
		  {
			  
			  Intent in=new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			  startActivity(in);
		  }
		}
	});
    }
    public boolean isConnectingToInternet()
    {
    	ConnectivityManager connectivity=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
    	if(connectivity!=null){
    		
    		NetworkInfo[] info=connectivity.getAllNetworkInfo();
    		if(info!=null)
    		{
    			for(int i=0;i<info.length;i++){
    			if(info[i].getState()==NetworkInfo.State.CONNECTED)
    			{
    			
    				return true;
    			
    				
    			}
    			
    		  }
    	    }
    		}
    	return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
