package com.mak.databasesimpleexample;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button insert,show;
	String tableName="student";
	SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert=(Button)findViewById(R.id.button1);
        show=(Button)findViewById(R.id.button2);
        pref=getSharedPreferences("Database",0 );
        String status=pref.getString("load", "NO");//load name a kisu na paile no show korbe
        if(status.equals("NO"))
        {
        	   createDatabase();
        	   SharedPreferences.Editor editor=pref.edit();
        	   editor.putString("load", "YES");
        	   editor.commit(); //editor ke save korlam
        }
     
        insert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SQLiteDatabase db=openOrCreateDatabase("MyDatabase",MODE_PRIVATE, null);
				String insert1="INSERT INTO "+ tableName +" VALUES(1, 'KAMAL', '01686975074');";
				String insert2="INSERT INTO "+ tableName +" VALUES(2, 'Arif', '0196123456');";
				db.execSQL(insert1);
				db.execSQL(insert2);
				db.close();
				Toast.makeText(getApplicationContext(), "Data inserted",Toast.LENGTH_SHORT).show();
			}
		});
        show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SQLiteDatabase db=openOrCreateDatabase("MyDatabase",MODE_PRIVATE, null);
				String retrieve="SELECT * FROM "+tableName+ "; ";
				Cursor cursor=db.rawQuery(retrieve, null);
				if(cursor.getCount()<1){
					Toast.makeText(getApplicationContext(), "no data here", Toast.LENGTH_SHORT).show();
				}
				else{
					String alldata="";
					cursor.moveToFirst();
					do{
						
						String name1=cursor.getString(cursor.getColumnIndex("name"));
						String phone1=cursor.getString(cursor.getColumnIndex("phone"));
						alldata+=name1+" "+ phone1 +"\n";
					}
					while(cursor.moveToNext());
					Toast.makeText(getApplicationContext(), alldata, Toast.LENGTH_SHORT).show();
					db.close();
				}
				
				
				
				
				
				
			}
		});
    }
    public void createDatabase()
    
    {
    	Toast.makeText(getApplicationContext(), "database created", Toast.LENGTH_SHORT).show();
    	SQLiteDatabase db=openOrCreateDatabase("MyDatabase",MODE_PRIVATE, null);
        String create="CREATE TABLE IF NOT EXISTS "+tableName+"(id INTEGER, name VARCHAR, phone VARCHAR);";
        
    	db.execSQL(create);
    	db.close();
    	
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
