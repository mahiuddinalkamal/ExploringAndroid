package com.example.labtest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends Activity {

	Button btnLogin;
	EditText txtUser, txtPass;
	CheckBox checkBox;
	String tableName = "mydata";
	SharedPreferences pref;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		btnLogin = (Button) findViewById(R.id.btnLog);
		txtUser = (EditText) findViewById(R.id.editText3);
		txtPass = (EditText) findViewById(R.id.editText4);
		checkBox = (CheckBox) findViewById(R.id.checkBox1);

		pref = getPreferences(MODE_PRIVATE);
		String str = pref.getString("U", "null");
		String str2 = pref.getString("P", "null");

		if (!str.equals("null"))
		{
			txtUser.setText(str);
			txtPass.setText(str2);
		}

		btnLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub

				String user = txtUser.getText().toString();
				String pass = txtPass.getText().toString();
				boolean check = checkBox.isChecked();

				//String ret = pass;
				String ret = checkPass(user);

				if (ret.equals(pass))
				{
					if (check)
					{
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("U", user);
						editor.putString("P", pass);
						editor.commit();
					}
					else
					{
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("U", "null");
						editor.putString("P", "null");
						editor.commit();
					}
					Intent intent = new Intent(ActivityLogin.this, ActivityList.class);
					startActivity(intent);
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Not matched", Toast.LENGTH_LONG).show();
				}

			}
		});
	}

	String checkPass(String user)
	{
		user = "'" + user + "'";

		SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
		String querySQL = "SELECT pass FROM " + tableName + " WHERE name = " + user + ";";
		String pass = "null";

		Cursor cursor = db.rawQuery(querySQL, null);
		if (cursor.getCount() >= 1)
		{
			cursor.moveToFirst();
			pass = cursor.getString(cursor.getColumnIndex("pass"));
		}

		db.close();

		return pass;

	}

}
