package com.example.universitywebsite;

import java.util.ArrayList;
import java.util.Arrays;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class MainActivity extends Activity implements OnItemClickListener{
	
	ListView listView;
	ArrayList<String>item;
	
	String[] names = {"BUET","CUET","KUET","RUET","SUST","DU","CU"};
	
	String[] sites = {"http://www.buet.ac.bd/",
			"http://www.cuet.ac.bd/",
			"http://www.kuet.ac.bd/",
			"http://www.ruet.ac.bd/",
            "http://www.sust.edu/",
			"http://www.du.ac.bd",
			"http://www.cu.ac.bd/ctguni/"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listView = (ListView)findViewById(R.id.listView1);
        item = new ArrayList<String> (Arrays.asList(names));
        
        CustomAdapter adapter=new CustomAdapter(this, item);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		
		String selected = sites[position];
		Intent intent = new Intent(MainActivity.this,WebsiteActivity.class);
		intent.putExtra("key", selected);
		startActivity(intent);
		
	}
    
}
