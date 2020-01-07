package com.mak.asyntaskexample;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText txt;
    Button button;
    String time="";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(EditText)findViewById(R.id.editText1);
        button=(Button)findViewById(R.id.button1);
        
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		    time=txt.getText().toString();
			new AsyncTaskRunner().execute();
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public class AsyncTaskRunner extends AsyncTask<String, String, String>
    {
    	
    	ProgressDialog dialog=new ProgressDialog(MainActivity.this);
    	
       @Override
        protected void onPreExecute() {
	     // TODO Auto-generated method stub
           
    	   dialog.setTitle("Please Wait for "+time+" millisecond");
    	   dialog.setCancelable(false);
    	   dialog.show();
        }
	   @Override
		protected String doInBackground(String... parameter) {
			// TODO Auto-generated method stub
			
		   //String time2=parameter[0];
		   
		   try {
			Thread.sleep(Integer.valueOf(time));
		     } 
		   catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return null;
		}
       @Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			dialog.dismiss();
			Toast.makeText(getApplicationContext(), "task completed!!", Toast.LENGTH_SHORT).show();
			
		}   	
    	
    }
    
}
