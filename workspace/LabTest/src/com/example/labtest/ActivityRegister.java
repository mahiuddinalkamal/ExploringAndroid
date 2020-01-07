package com.example.labtest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegister extends Activity {

	Button btnReg;
	EditText txtUser, txtPass;
	SharedPreferences pref;
	String tableName = "mydata";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		btnReg = (Button) findViewById(R.id.btnLog);
		txtUser = (EditText) findViewById(R.id.editText1);
		txtPass = (EditText) findViewById(R.id.editText2);

		pref = getSharedPreferences("Database", 0);
		String status = pref.getString("load", "no");

		if (status.equals("no")) //Database not created
		{
			createDatabase();

			SharedPreferences.Editor editor = pref.edit();
			editor.putString("load", "yes");
			editor.commit();
		}

		btnReg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub

				String user = txtUser.getText().toString();
				String pass = txtPass.getText().toString();

				user = "'" + user + "'";
				pass = "'" + pass + "'";

				SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
				String insertSQL = "INSERT INTO " + tableName + " VALUES(" + user + "," + pass + ");";
				db.execSQL(insertSQL);
				db.close();

				Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();

			}
		});

	}

	public void createDatabase()
	{
		SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
		String createSQL = "CREATE TABLE IF NOT EXISTS " + tableName + " (name VARCHAR, pass VARCHAR);";
		db.execSQL(createSQL);
		db.close();

		Toast.makeText(getApplicationContext(), "Database created", Toast.LENGTH_LONG).show();
	}

}
