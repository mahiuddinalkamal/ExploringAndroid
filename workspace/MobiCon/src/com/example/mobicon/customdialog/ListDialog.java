package com.example.mobicon.customdialog;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class ListDialog {

	public ListDialog(final Activity activity, ArrayList<String> data_lists, final EditText editText)
	{
		// TODO Auto-generated constructor stub

		AlertDialog.Builder builderSingle = new AlertDialog.Builder(activity);
		builderSingle.setTitle("Select One Model:");

		final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, data_lists);

		builderSingle.setNegativeButton("cancel",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						dialog.dismiss();
					}
				});

		builderSingle.setAdapter(arrayAdapter,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						String strName = arrayAdapter.getItem(which);
						editText.setText(strName);
					}
				});
		builderSingle.show();
	}

}
