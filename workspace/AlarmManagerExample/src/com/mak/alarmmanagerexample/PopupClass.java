package com.mak.alarmmanagerexample;
import android.app.Activity;
import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

public class PopupClass extends Activity{
 Button btn;
 Uri uri;
 Ringtone ringtone;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.popup_layout);
		btn=(Button)findViewById(R.id.pop);
		
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		uri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
		ringtone=RingtoneManager.getRingtone(getApplicationContext(), uri);
		
		ringtone.play();
		Vibrator vibrator=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(1000);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ringtone.stop();
			}
		});
	}
	
	

	
}
