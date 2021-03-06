package com.example.labtest;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ActivityList extends Activity implements OnItemClickListener {

	ListView list;
	ArrayList<String> data;
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		list = (ListView) findViewById(R.id.listView1);
		data = new ArrayList<String>();

		data.add("Facebook");
		data.add("Google");
		data.add("Gmail");
		

		adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, data);

		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		// TODO Auto-generated method stub

		String selected = (String) parent.getItemAtPosition(position);
		Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_LONG).show();

		boolean internetStatus = isConnectedToInternet();
		if (internetStatus)
		{
			Intent intent = new Intent(ActivityList.this, ActivityWeb.class);
			intent.putExtra("site", selected);
			startActivity(intent);
		} else
		{
			Intent intent = new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS);
			// For Android 4.0 and earlier
			/*ComponentName cName = new ComponentName("com.android.phone", "com.android.phone.Settings");
			intent.setComponent(cName);*/
			startActivity(intent);
		}

	}

	public boolean isConnectedToInternet()
	{
		ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null)
		{
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null)
			{
				for (int i = 0; i < info.length; i++)
				{
					if (info[i].getState() == NetworkInfo.State.CONNECTED) return true;
				}
			}
		}
		return false;
	}

}
