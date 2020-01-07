package com.mak.listwebviewexample;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class List_Web_MainActivity extends Activity {
ListView listView;
ArrayList<String> data;
ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__web__main);
        listView=(ListView)findViewById(R.id.listView1);
        
        data=new ArrayList<String>();
        data.add("DU");
        data.add("CUET"); //sob string type ar input
        data.add("BUET");
        data.add("KUET");
        data.add("RUET");
        data.add("SUST");
        
        adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
    
        listView.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> adapter, View v, int position,
				long arg3) {
			
			String selectedData=((TextView)v).getText().toString();
			Intent intent=new Intent(List_Web_MainActivity.this,SecondActivity.class);
			intent.putExtra("mak", selectedData);
			startActivity(intent);
			
		}
    	
	});
    
    }
        


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list__web__main, menu);
        return true;
    }
	
	
    
}
