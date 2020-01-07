package com.example.ratingexp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;

public class MainActivity extends Activity {
	RatingBar rat; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rat=(RatingBar)findViewById(R.id.ratingBar1);
        rat.setRating(3.7f);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
