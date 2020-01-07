package com.mak.musicplayerexample;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button play,pause;
	MediaPlayer player;
	boolean startedStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=(Button)findViewById(R.id.button1);
        pause=(Button)findViewById(R.id.button2);
        player=MediaPlayer.create(this,R.raw.song);
        player.setLooping(true);
        startedStatus=false;
        
    play.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		if(startedStatus==false)	
		{
		
			player.start();
			startedStatus=true;
		}
		}
	});
    pause.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		if(startedStatus){
			
			player.pause();
			startedStatus=false;
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
