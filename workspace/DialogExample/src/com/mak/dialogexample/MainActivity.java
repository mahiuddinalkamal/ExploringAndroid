package com.mak.dialogexample;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button simple,item,multiChoice,custom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simple=(Button)findViewById(R.id.button1);
        item=(Button)findViewById(R.id.button2);
        multiChoice=(Button)findViewById(R.id.button3);
        custom=(Button)findViewById(R.id.button4);
    
        
        simple.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this); //alert dialog ta ke build korar jonno obj nilam
			builder.setTitle("this is simple dialog");
			builder.setIcon(R.drawable.ic_launcher);
			builder.setMessage("Do You Wanna Exit??");
			builder.setCancelable(false); //jodi user dialog ar onno kothao click kore tokhn ati cancel hobena.by default true thake
		    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int position) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Ok button is Clicked!!", Toast.LENGTH_SHORT).show();
				}
			});
		    
		    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "No button is Clicked!!", Toast.LENGTH_SHORT).show();
					
				}
			});
		    
		    AlertDialog simpleDialog=builder.create();
		    simpleDialog.show();
		}
	
        });
    
    
        item.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this); //alert dialog ta ke build korar jonno obj nilam
			builder.setTitle("this is item dialog");
			builder.setIcon(R.drawable.ic_launcher);	
			builder.setCancelable(false);
			
			//item ready korte hobe
			
			final String[] items={"Red","Green","Blue","Purple"}; //onclick listener ar jonno local variable access korte chaile final korte hoy
			builder.setItems(items, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface konDialogInterface, int position) {
					// TODO Auto-generated method stub
					
				/*if(){
					Toast.makeText(getApplicationContext(), "no item is selected", Toast.LENGTH_SHORT).show();
				}
				else*/
					
					Toast.makeText(getApplicationContext(), items[position]+"  is clicked", Toast.LENGTH_SHORT).show();
					
				}
			});
			
			builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					
					Toast.makeText(getApplicationContext(), "Negative Button is Clicked!!", Toast.LENGTH_SHORT).show();
					
				}
			});
			
			AlertDialog itemDialog=builder.create();
			itemDialog.show();
		}
	
        });
    
    
        multiChoice.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			

			AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this); //alert dialog ta ke build korar jonno obj nilam
			builder.setTitle("Multiple Choice Dialog");
			builder.setIcon(R.drawable.ic_launcher);	
			builder.setCancelable(false);
			
			//item ready korte hobe
			
			final String[] items={"Red","Green","Blue","Purple"};
			boolean[] selected={false,true,false,true};
			
			//user je item gula add korbe ta amra akta arraylist a rakhbo
			
			final ArrayList<String> all=new ArrayList<String>();
			all.add(items[1]);
			all.add(items[3]);
			
			
			builder.setMultiChoiceItems(items, selected,new DialogInterface.OnMultiChoiceClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int position, boolean checked) { //checked false hole unselected korse,true hole selected korese
					// TODO Auto-generated method stub
				
				if(checked) all.add(items[position]);
				else all.remove(items[position]);
					
					
				}
			});
			
			builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					String data="Selected Items ";
					for(int i=0;i<all.size();i++)
					{
						data=data+all.get(i)+"  ";
						
					}
				Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
				}
			});
			
				AlertDialog multipleDialog =builder.create();
				multipleDialog.show();
			
		}
	
        });
    
    
        custom.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
		
			LayoutInflater li=LayoutInflater.from(MainActivity.this);
		
			View view=li.inflate(R.layout.custom_layout, null); //amdr custom layout ta akta view hisebe use hocche tai inflate kora lagbe
			
			Button close=(Button)view.findViewById(R.id.mak); //button initailize korlam
			
			AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
			builder.setView(view);
			builder.setCancelable(false);
			
			final AlertDialog customDialog=builder.create();
			close.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "dialog cancelled!!", Toast.LENGTH_SHORT).show();
				    customDialog.cancel(); //button ke cancel korte bola hocche
				}
			});
			customDialog.show();
			
		}
	
        });
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
