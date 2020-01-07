package com.mak.listviewexample;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
ListView list;
ArrayList<String> data;
ArrayAdapter<String> adapter;
    
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    list=(ListView)findViewById(R.id.listView1);
    data=new ArrayList<String>();
    adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,data);
   list.setAdapter(adapter); //save korlam
data.add("cuet");
data.add("buet");
data.add("kuet");
data.add("ruet");
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
