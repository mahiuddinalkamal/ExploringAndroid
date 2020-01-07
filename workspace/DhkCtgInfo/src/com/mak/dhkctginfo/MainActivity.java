package com.mak.dhkctginfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	ImageButton dhk,ctg;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
dhk=(ImageButton)findViewById(R.id.imageButton1);
ctg=(ImageButton)findViewById(R.id.imageButton2);

dhk.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
		intent.putExtra("city","DHAKA");
		startActivity(intent);
		
	}
});
ctg.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		 Intent intent = new Intent(MainActivity.this,SecondActivity.class);
			intent.putExtra("city","Chittagong");
			startActivity(intent);
			
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
