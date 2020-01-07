package com.example.customlistexample;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter{

	Context context;
	ArrayList<String>data;
	LayoutInflater inflater;
	Typeface customFont;
	public CustomAdapter(Context context, ArrayList<String> data)
	{
	
		this.context=context;
		this.data=data;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//layout ke run time a design korte use kora hoy
		customFont=Typeface.createFromAsset(context.getAssets(), "font/LCALLIG.TTF");
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int pos) {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parentGroup) {
		// TODO Auto-generated method stub
	
		ViewHolder holder=null;
		if(convertView==null)
		{
			convertView = inflater.inflate(R.layout.item, null);
			holder=new ViewHolder();
			holder.text1=(TextView)convertView.findViewById(R.id.textView1);
			holder.text2=(TextView)convertView.findViewById(R.id.textView2);
			
			holder.text1.setTypeface(customFont);
			
			convertView.setTag(holder);
			
			Toast.makeText(context,"inflated"+" "+position+" "+convertView, Toast.LENGTH_SHORT).show();
		}
		else Toast.makeText(context,"not inflated "+position+" "+convertView, Toast.LENGTH_SHORT).show();

		holder=(ViewHolder)convertView.getTag();
		holder.text1.setText(data.get(position));
		holder.text2.setText(""+position);
		
		
				//TextView text1=(TextView)convertView.findViewById(R.id.textView1);
		//TextView text2=(TextView)convertView.findViewById(R.id.textView2);
		
		//text1.setText(data.get(position));
		//text2.setText(""+position);
		
		return convertView;
	}
	
	public static class ViewHolder{
		
		TextView text1,text2;
		
		
	}

}
