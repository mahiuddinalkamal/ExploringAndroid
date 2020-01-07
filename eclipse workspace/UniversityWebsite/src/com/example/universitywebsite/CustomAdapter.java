package com.example.universitywebsite;
import java.util.ArrayList;



import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	
	

	ArrayList <String> item;
	private Activity context;
	
	public CustomAdapter(Activity context, ArrayList<String> country) {
		
		// TODO Auto-generated constructor stub
		this.context=context;
		this.item=country;;
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		 return item.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		

		 if (convertView == null) 
		 {
		        convertView =LayoutInflater.from(context)
					      .inflate(R.layout.row, parent, false);
		 }
	   
		
		 
		 TextView txt = (TextView)convertView.findViewById(R.id.textView1);
		 ImageView logo = (ImageView)convertView.findViewById(R.id.imageView1);
	   
		 
		 String name=item.get(position);
		 txt.setText(name);
		 
		 if(name.contains("BUET"))
		 {
			
			logo.setImageResource(R.drawable.buet);
		 }
		 else if(name.contains("CUET"))
		 {
			
			logo.setImageResource(R.drawable.cuet);
		 }
		 else if(name.contains("KUET"))
		 {
			
			logo.setImageResource(R.drawable.kuet);
		 }
		 else if(name.contains("RUET"))
		 {
			
			logo.setImageResource(R.drawable.ruet);
		 }
		 else if(name.contains("SUST"))
		 {
			
			logo.setImageResource(R.drawable.sust);
		 }
		 else if(name.contains("DU"))
		 {
			
			logo.setImageResource(R.drawable.du);
		 }
		 else if(name.contains("CU"))
		 {
			
			logo.setImageResource(R.drawable.cu);
		 }
		 
		return convertView;
	}

}
