package com.example.simpledatabaseproject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button btnInsert, btnShow,btnDelete;
	
    String tableName="student";
    
    SharedPreferences prefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnInsert=(Button)findViewById(R.id.btnInsert);
		btnShow=(Button)findViewById(R.id.btnShow);
		btnDelete=(Button)findViewById(R.id.btnDelete);
		
		prefs=getSharedPreferences("DB", 0);
		String loadStatus=prefs.getString("load", "no");
		if(loadStatus.equals("no"))
		{
			createDatabase();
			SharedPreferences.Editor editor=prefs.edit();
			editor.putString("load", "yes");
			editor.commit();
		}
		
		btnInsert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// third parameter cursorfactory
				
				String insert1="INSERT INTO "+tableName+" VALUES(1,'Peaal','018....');";
				String insert2="INSERT INTO "+tableName+" VALUES(2,'Sajid','017....');";
				
				SQLiteDatabase db=openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
				db.execSQL(insert1);
				db.execSQL(insert2);
				db.close();
				Toast.makeText(getApplicationContext(), "Data inserted", Toast.LENGTH_LONG).show();
			}
		});
		
		btnDelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SQLiteDatabase db=openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
				String delete="DELETE FROM "+tableName+";";
				db.execSQL(delete);
				db.close();
				Toast.makeText(getApplicationContext(), "Data deleted", Toast.LENGTH_LONG).show();
			}
		});
		
		
		btnShow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SQLiteDatabase db=openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
				Cursor cursor=db.rawQuery("SELECT * FROM student;", null);
				int a=cursor.getCount();
				if(a<1) Toast.makeText(getApplicationContext(), "No data available", Toast.LENGTH_LONG).show();
				else
				{
					cursor.moveToFirst();
					String allData="";
					do
					{
						String name=cursor.getString(cursor.getColumnIndex("name"));
						String phone=cursor.getString(cursor.getColumnIndex("phone"));
						allData+=name +" "+phone+"\n";
					}
					while(cursor.moveToNext());
					db.close();
					Toast.makeText(getApplicationContext(), allData, Toast.LENGTH_LONG).show();
				}
			}
		});
		
		
		
	}
	
	
	public void createDatabase()
	{
		SQLiteDatabase db=openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
		String create="CREATE TABLE IF NOT EXISTS "+tableName+" (id INTEGER, name VARCHAR, phone VARCHAR);";
		db.execSQL(create);
		db.close();
		Toast.makeText(getApplicationContext(), "Database created", Toast.LENGTH_LONG).show();
	}
	
	

}
