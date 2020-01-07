package com.mak.advanceddatabaseexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHandler extends SQLiteOpenHelper{
	


	public static final int    DATABASE_VERSION=1;
	public static final String DATABASE_NAME="contactManager";
	public static final String TABLE_CONTACTS="contacts";
	public static final String CONTACT_ID="id";
	public static final String CONTACT_NAME="name";
	public static final String CONTACT_PHONE="phone";
	
	public DataHandler(Context context) {
		super(context,DATABASE_NAME, null, DATABASE_VERSION);//null disi karon ami standard cursor factory use korbo
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		//String CREATE_CONTACTS_TABLE=" CREATE TABLE " +
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	

}
