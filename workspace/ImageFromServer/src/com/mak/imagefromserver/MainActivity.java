package com.mak.imagefromserver;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends Activity {
	ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.imageView1);
        new ImageHolder().execute();
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public class ImageHolder extends AsyncTask<String, String, String>
    {
    	ProgressDialog dialog=new ProgressDialog(MainActivity.this);

    	@Override
    	protected void onPreExecute() {
    		// TODO Auto-generated method stub
    		dialog.setTitle("Loading...");
    		dialog.setCancelable(false);
    		dialog.show();
    	}
    	
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			Picasso.with(MainActivity.this).load("https://www.facebook.com/bangladeshism/photos/pcb.1071816839512579/1071816212845975/?type=1&theater").into(img);
			   
			  /* try {
				Thread.sleep(Integer.valueOf(5000));
			     } 
			   catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   } 
			   catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			   return null;
			}	
    	@Override
    	protected void onPostExecute(String result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);
    		dialog.cancel();
    	}
    }
    
}
