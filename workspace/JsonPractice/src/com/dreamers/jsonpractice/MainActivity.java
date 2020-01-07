package com.dreamers.jsonpractice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	ArrayList<String>name=new ArrayList<String>(); 
	ArrayList<String>age=new ArrayList<String>(); 
	JSONParser jParser = new JSONParser();
	Button btn;
	boolean availableProduct=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn=(Button)findViewById(R.id.button1);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new AsyncTaskRunnerCurrent().execute();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

	//----------- Fetching Current Project
	class AsyncTaskRunnerCurrent extends AsyncTask<String, String, String>
	{
		 ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
		
		String error="";
		
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub

			try
			{
				
			

				List<NameValuePair> pair= new ArrayList<NameValuePair>();
				
				
			//JSONObject json=jParser.makeHttpRequest("http://everestdiners.com/market/get_product_name.php", "GET", pair)	;
				JSONObject json=jParser.makeHttpRequest("http://192.168.0.106/practice/get_data.php", "GET", pair)	;
	
				name.clear();
				age.clear();
				
				int success=json.getInt("success");
				
				if(success==1)
				{
					
					
				JSONArray	 product= json.getJSONArray("product");
					
					
					for(int i=0;i<product.length();i++)
					{
						JSONObject item=product.getJSONObject(i);
						
						
						name.add(item.getString("name"));
						age.add(item.getString("age"));
					}
					
					
			         availableProduct=true;		
					
					
				}
				else
				{
					//Toast.makeText(getApplicationContext(), "Sorry a problem occured", Toast.LENGTH_LONG).show();
				Log.d("NOOOOOOOOOOOOOOOOOOOOOOOOOOO", "NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
				 availableProduct=false;
				}
				
				
				
				
			}
			catch(Exception e)
			{
				//Toast.makeText(getApplicationContext(),"A problem occured. Please restart the application once again", Toast.LENGTH_LONG).show();
			
			  Log.d("Problemasdddddddddddddd", e+"");
			  error =e+"";
			}
			return null;
		}
		
		
		
		protected void onPostExecute(String string)
		{
			
			progressDialog.dismiss();
			Intent intent=null;
			if(availableProduct==true)
			{
					Toast.makeText(getApplicationContext(), name.get(0),Toast.LENGTH_LONG).show();
			}
			
			else
			{
				Toast.makeText(getApplicationContext(), "There is no available project "+error, Toast.LENGTH_LONG).show();
			}
		
		}
		
		protected void onPreExecute()
		{
			
			progressDialog.setMessage("Please wait. Loading..");
			progressDialog.setCancelable(false);
			progressDialog.show();
		}
		
		
		
		
			}
	
	
	
	//------------------------------------------------------------------


	
	
	
	

}
