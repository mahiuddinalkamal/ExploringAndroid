package com.mak.labproject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity{
	TextView user_name,pass_word;
	EditText user,pass;
	Button reg;
	String tableName="student";
	SharedPreferences pref;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_layout);
		reg=(Button)findViewById(R.id.button1);
		user_name=(TextView)findViewById(R.id.textView1);
		pass_word=(TextView)findViewById(R.id.textView2);
		user=(EditText)findViewById(R.id.editText1);
		pass=(EditText)findViewById(R.id.editText2);
		
		
	
		
		   pref=getSharedPreferences("Database",0 );
		   String status=pref.getString("load", "NO");//load name a kisu na paile no show korbe
	        if(status.equals("NO"))
	        {
	        	   createDatabase();
	        	   SharedPreferences.Editor editor=pref.edit();
	        	   editor.putString("load", "YES");
	        	   editor.commit(); //editor ke save korlam
	        }
	    	
			
	        reg.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					String text1=user.getText().toString();
					String text2=pass.getText().toString();

					text1 = "'" + text1 + "'";
					text2 = "'" + text2 + "'";
					
					SQLiteDatabase db=openOrCreateDatabase("MyDatabase",MODE_PRIVATE, null);
			        String insert1="INSERT INTO "+ tableName +" VALUES(" + text1 + "," + text2 + ");";
					db.execSQL(insert1);
					db.close();
					Toast.makeText(getApplicationContext(), "Congratulation!!You are now a registerd member!!",Toast.LENGTH_SHORT).show();
				}
			});
	}
	 public void createDatabase()
	    
	    {
	    	//Toast.makeText(getApplicationContext(), "database created", Toast.LENGTH_SHORT).show();
	    	SQLiteDatabase db=openOrCreateDatabase("MyDatabase",MODE_PRIVATE, null);
	        String create="CREATE TABLE IF NOT EXISTS "+tableName+"(name VARCHAR, pass VARCHAR);";
	        
	    	db.execSQL(create);
	    	db.close();
	    	
	    	
	    }
	

}
