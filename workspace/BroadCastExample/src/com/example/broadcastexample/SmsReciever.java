package com.example.broadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReciever extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED"))
		{
			Bundle bundle=intent.getExtras();
			SmsMessage[] allMessages=null;
			String number=null;
			String message=""; //pdus mane "protocol data units"; msg ar datatype janina bole object cls thke nicchi karon sob data type akhane thake
			Object[] obj=(Object[]) bundle.get("pdus");
			
			allMessages=new SmsMessage[obj.length]; //initialization
			
			for(int i=0;i<obj.length;i++)
			{ 
				allMessages[i]=SmsMessage.createFromPdu((byte[]) obj[i]);
				if(number==null)number=allMessages[i].getOriginatingAddress();
				message+=allMessages[i].getMessageBody();
			}
			
			SmsManager manager=SmsManager.getDefault();
			manager.sendTextMessage(number, null,message,null,null);
			Toast.makeText(context,"SMS recieved from "+number, Toast.LENGTH_SHORT).show();
			
			Intent intent2 =new Intent (context ,MainActivity.class);
			intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			
			context.startActivity(intent2);
			
			
			
			
		}
	}

}
