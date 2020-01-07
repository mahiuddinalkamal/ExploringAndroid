package com.dreamers.customlist;
import java.util.ArrayList;



import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	
	

	ArrayList <String> countryItem;
	ArrayList <String> champion;
	private Activity context;
	
	public CustomAdapter(Activity context, ArrayList<String> country,ArrayList<String> champion) {
		
		// TODO Auto-generated constructor stub
		this.context=context;
		this.countryItem=country;
		this.champion=champion;
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		 return countryItem.size();
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
		
		

		 if (convertView == null) {
		        convertView =LayoutInflater.from(context)
					      .inflate(R.layout.row, parent, false);
		    }
	   
		
		 
		 
		 
		 TextView countryName = (TextView)convertView.findViewById(R.id.country);
		 TextView time=(TextView)convertView.findViewById(R.id.time);
		 ImageView flag = (ImageView)convertView.findViewById(R.id.flag);
	   
		 
		 String name=countryItem.get(position);
		 countryName.setText(name);
		 time.setText(champion.get(position));
		 if(name.contains("Argentina"))
		 {
			
					 flag.setImageResource(R.drawable.argentina);
		 } 
		 
		 else if(name.contains("Brazil"))
		 {
			 
			 flag.setImageResource(R.drawable.brazil);
	 
		 }
		 
		 else if(name.contains("Croatia"))
		 {
			 
			 flag.setImageResource(R.drawable.croatia);
	 
		 }
		 else if(name.contains("Denmark"))
		 {
			 
			 flag.setImageResource(R.drawable.denmark);
	 
		 }
		 else if(name.contains("England"))
		 {
			 
			 flag.setImageResource(R.drawable.england);
	 
		 }
		 else if(name.contains("Germany"))
		 {
			 
			 flag.setImageResource(R.drawable.germany);
	 
		 }
		 else if(name.contains("Italy"))
		 {
			 
			 flag.setImageResource(R.drawable.italy);
	 
		 }
		 else 
		 {
			 
			 flag.setImageResource(R.drawable.spain);
	 
		 }
		
	 
		
		return convertView;
	}

}
