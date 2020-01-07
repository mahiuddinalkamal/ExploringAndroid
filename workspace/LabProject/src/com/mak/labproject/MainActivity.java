package com.mak.labproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	Button go;
	MediaPlayer player;
	boolean startedStatus;
	ImageView animationPanel;
	int state=1;
	AnimationDrawable animeController; //akhane control korbe animation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationPanel=(ImageView)findViewById(R.id.imageView1);
        go=(Button)findViewById(R.id.button1);
        
        player=MediaPlayer.create(this,R.raw.song);
        player.setLooping(true);
        startedStatus=false;
        if(startedStatus==false)	
		{
		
			player.start();
			startedStatus=true;
		}
        
        animationPanel.setImageResource(R.drawable.frameanimation);
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
        
        go.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(startedStatus){
					
					player.pause();
					startedStatus=false;
				}
				
				 Intent intent = new Intent(MainActivity.this,SecondActivity.class);
					
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
