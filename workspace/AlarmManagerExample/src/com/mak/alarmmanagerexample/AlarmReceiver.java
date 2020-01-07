package com.mak.alarmmanagerexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver{

	String action="com.mak.alarmmanagerexample.ALARM";
	
	
	@Override
	public void onReceive(Context context, Intent in) {
		// TODO Auto-generated method stub
		if(in.getAction().equals(action))
		{
			Intent intent=new Intent(context,PopupClass.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //age se check kore dekhbe ai popup activity
			                                            //ta onno kono task/stack ar sathe related kina?
			                                            // jodi thake tahole se take stack ar surute niye ashbe
			                                            //nahole new create korbe
			context.startActivity(intent);
			
			
		}
	}

}
