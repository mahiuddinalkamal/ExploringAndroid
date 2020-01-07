package com.mak.sharedpreferredexample;

import java.util.Random;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static String HIGH_SCORE="high_score";
	
	TextView highScore,score;
	Button play,reset;
	int highScoreNow;
	SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref=getPreferences(MODE_PRIVATE);
        
        setContentView(R.layout.activity_main);
        
        int high=pref.getInt(HIGH_SCORE, 0);
        
    
    highScore=(TextView)findViewById(R.id.textView2);
    score=(TextView)findViewById(R.id.textView4);
 
    play=(Button)findViewById(R.id.button1);
    reset=(Button)findViewById(R.id.button2);
    
    highScore.setText(high+"");
    score.setText("0");
    
    play.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Random r=new Random();
			int value=r.nextInt(1000);
		score.setText(value+"");
		
	     highScoreNow=pref.getInt(HIGH_SCORE, 0);
		
		if(value>highScoreNow)
		{
		SharedPreferences.Editor editor= pref.edit();
		editor.putInt(HIGH_SCORE, value);
		editor.commit();
		highScore.setText(value+"");
		Toast.makeText(getApplicationContext(), "congratulation high score!!!", Toast.LENGTH_SHORT).show();
		
		}
	
		}	
		});
    
    reset.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			SharedPreferences.Editor editor= pref.edit();
			editor.putInt(HIGH_SCORE, 0);
			editor.commit();
            highScore.setText("000");
            score.setText("000");
			
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
