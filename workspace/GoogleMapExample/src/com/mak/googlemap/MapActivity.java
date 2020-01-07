package com.mak.googlemap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import android.app.Dialog;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapActivity extends FragmentActivity implements 
GooglePlayServicesClient.ConnectionCallbacks,GooglePlayServicesClient.OnConnectionFailedListener,LocationListener{
	
	GoogleMap map;
	Button direction;
	LatLng  loc,myLoc; //location banay
	Marker marker,myMarker;
	double lat,myLat,lon,myLon;
	LocationClient locationClient;
	boolean draw=false;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.map_layout);
		direction=(Button)findViewById(R.id.button1);
		if(!isMapAvailable())
		{
			Toast.makeText(getApplicationContext(), "google play service is not installed", Toast.LENGTH_SHORT).show();
		}
		else {
			
			map=((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
			if(map==null)Toast.makeText(getApplicationContext(), "map can not be created", Toast.LENGTH_SHORT).show();
			else{
				
				map.setMyLocationEnabled(true);
				lat=22.368025;
				lon=91.849106;
				loc=new LatLng(lat, lon); //location create korlam
				marker=map.addMarker(new MarkerOptions().position(loc).title("Hello Chittagong").snippet("A Nice City"));
				marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
				marker.showInfoWindow();
				//map.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 12.0f));
				locationClient=new LocationClient(this, this, this);
			}
		}
		
		
		direction.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			/*	PolylineOptions line=new PolylineOptions().add(loc,myLoc).width(5).color(Color.BLUE); //ader majhe line draw hobe
				map.addPolyline(line); */
			
				if(draw==false)
				{
					try
					{
						draw=true;
						Toast.makeText(getApplicationContext(), "Wait to get the direction", Toast.LENGTH_LONG).show();
						try{
							 final LatLngBounds bounds = new LatLngBounds.Builder().include(myLoc).include(loc).build();
						         map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 65));
						}
						catch(Exception e)
						{
							Toast.makeText(getApplicationContext(), "Direction can not be shown, please try again.", Toast.LENGTH_LONG).show();
						}
					    String str_origin = "origin="+lat+","+lon;
				        // Destination of route
				        String str_dest = "destination="+myLat+","+myLon; 
				        // Sensor enabled
				        String sensor = "sensor=false"; 
				        // Building the parameters to the web service
				        String parameters = str_origin+"&"+str_dest+"&"+sensor;	 
				        // Output format
				        String output = "json";	 
				        // Building the url to the web service
				        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;
				        DownloadTask downloadTask = new DownloadTask();	        
			         // Start downloading json data from Google Directions API
			            downloadTask.execute(url); 		            
					}
					catch(Exception e)
					{
						e.printStackTrace();
						Toast.makeText(getApplicationContext(), "Direction can not be shown, please try again.", Toast.LENGTH_LONG).show();
					}
				}
				else Toast.makeText(getApplicationContext(), "Wait to get the direction", Toast.LENGTH_LONG).show();


				
			}
		});
		
		
		map.setOnMarkerClickListener(new OnMarkerClickListener() {
			
			@Override
			public boolean onMarkerClick(Marker marker1) {
				// TODO Auto-generated method stub
				//return false; //google map je default action dey oita perform korbe 
				              //true dile defaulte action perform hobena
				 
				String title=marker1.getTitle();
				marker1.showInfoWindow();
				Toast.makeText(getApplicationContext(), title+"  marker is clicked", Toast.LENGTH_SHORT).show();
				return true;
			
			}
		});
		
		map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() { //denote kore kon marker ar info window te click hoise
			
			@Override
			public void onInfoWindowClick(Marker marker1) {
				// TODO Auto-generated method stub
				
				String title=marker1.getTitle();
			    Toast.makeText(getApplicationContext(), title+"info window is clicked", Toast.LENGTH_SHORT).show();
				
			}
		});
	}
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		locationClient.disconnect();
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		locationClient.connect();
	}
	
	
	public boolean isMapAvailable(){
		int result=GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
		if(result==ConnectionResult.SUCCESS){
			
			return true;
		}
		else if(GooglePlayServicesUtil.isUserRecoverableError(result))
			{
			Dialog d=GooglePlayServicesUtil.getErrorDialog(result, this,1);
			d.show();
			}
		else{
			 Toast.makeText(getApplicationContext(), "it is not supported in this device", Toast.LENGTH_SHORT).show();
			 finish();
		}
		return false;
	}


	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onConnected(Bundle arg0) {
		// TODO Auto-generated method stub
		Location location=locationClient.getLastLocation();
		try{
			myLat=location.getLatitude();
			myLon=location.getLongitude();
			myLoc=new LatLng(myLat,myLon);
			myMarker=map.addMarker(new MarkerOptions().position(myLoc).title("I am Here").snippet("Click Here!!"));
			myMarker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
			myMarker.showInfoWindow();
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(myLoc, 15));
			Toast.makeText(getApplicationContext(), "found it!!", Toast.LENGTH_SHORT).show();
	
		}
		catch(Exception e){
			
			
		}
	}


	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
	
	  
	 /** A method to download json data from url */

	    private String downloadUrl(String strUrl) throws IOException{
	        String data = "";
	        InputStream iStream = null;
	        HttpURLConnection urlConnection = null;
	        try{
	            URL url = new URL(strUrl);
	            // Creating an http connection to communicate with url
	            urlConnection = (HttpURLConnection) url.openConnection();
	            // Connecting to url
	            urlConnection.connect();
	            // Reading data from url
	            iStream = urlConnection.getInputStream();
	            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
	            StringBuffer sb = new StringBuffer();
	            String line = "";
	            while( ( line = br.readLine()) != null){
	                sb.append(line);
	            }
	            data = sb.toString();
	            br.close();
	 
	        }catch(Exception e){
	            Log.d("Exception while downloading url", e.toString());
	        }finally{
	            iStream.close();
	            urlConnection.disconnect();
	        }
	        return data;
	    }

	
	    
	    


	    private class DownloadTask extends AsyncTask<String, Void, String>{

	        // Downloading data in non-ui thread
	        @Override
	        protected String doInBackground(String... url) {

	            // For storing data from web service
	            String data = "";

	            try{
	                // Fetching the data from web service
	                data = downloadUrl(url[0]);
	            }catch(Exception e){
	                Log.d("Background Task",e.toString());
	            }
	            return data;
	        }

	        // Executes in UI thread, after the execution of
	        // doInBackground()
	        @Override
	        protected void onPostExecute(String result) {
	            super.onPostExecute(result);

	            ParserTask parserTask = new ParserTask();

	            // Invokes the thread for parsing the JSON data
	            parserTask.execute(result);
	        }
	    }

	

	    /** A class to parse the Google Places in JSON format */
	    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>> >{

	        // Parsing the data in non-ui thread
	        @Override
	        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

	            JSONObject jObject;
	            List<List<HashMap<String, String>>> routes = null;

	            try{
	                jObject = new JSONObject(jsonData[0]);
	                DirectionsJSONParser parser = new DirectionsJSONParser();

	                // Starts parsing data
	                routes = parser.parse(jObject);
	            }catch(Exception e){
	                e.printStackTrace();
	            }
	            return routes;
	        }

	        // Executes in UI thread, after the parsing process
	        @Override
	        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
	            ArrayList<LatLng> points = null;
	            PolylineOptions lineOptions = null;
	            MarkerOptions markerOptions = new MarkerOptions();

	            // Traversing through all the routes
	            for(int i=0;i<result.size();i++){
	                points = new ArrayList<LatLng>();
	                lineOptions = new PolylineOptions();

	                // Fetching i-th route
	                List<HashMap<String, String>> path = result.get(i);

	                // Fetching all the points in i-th route
	                for(int j=0;j<path.size();j++){
	                    HashMap<String,String> point = path.get(j);

	                    double lat = Double.parseDouble(point.get("lat"));
	                    double lng = Double.parseDouble(point.get("lng"));
	                    LatLng position = new LatLng(lat, lng);

	                    points.add(position);
	                }

	                // Adding all the points in the route to LineOptions
	                lineOptions.addAll(points);
	                lineOptions.width(8);
	                lineOptions.color(Color.RED);
	            }

	            // Drawing polyline in the Google Map for the i-th route
	            map.addPolyline(lineOptions);
	        }

	    }







	    
	    
	
}
