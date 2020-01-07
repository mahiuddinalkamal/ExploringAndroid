package com.mak.animationexample;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ImageView animationPanel;
	int state=1;
	AnimationDrawable animeController; //akhane control korbe animation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        animationPanel=(ImageView)findViewById(R.id.imageView1);
        animationPanel.setImageResource(R.drawable.frameanimation); //xml file ti set kore dilam
       
        animeController=(AnimationDrawable)animationPanel.getDrawable();
       
        animationPanel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				 state*=-1;
				 if(state==1)
				 {
					   animeController.start();
				 }
				 else if(state==-1)
					 {
					 
					 animeController.stop();
					 
					 }
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
