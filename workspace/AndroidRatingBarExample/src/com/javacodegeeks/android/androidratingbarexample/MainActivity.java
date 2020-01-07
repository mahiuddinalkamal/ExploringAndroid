package com.javacodegeeks.android.androidratingbarexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends Activity {
 
  private RatingBar ratingBar;
  private TextView ratingValue;
  private Button button;
 
  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
 
	addListenerOnRatingBar();
	addListenerOnButton();
 
  }
 
  public void addListenerOnRatingBar() {
 
	ratingBar = (RatingBar) findViewById(R.id.ratingBar);
	ratingValue = (TextView) findViewById(R.id.txtRatingValue);
 
	//if rating value is changed,
	//display the current rating value in the result (textview) automatically
	ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
		
		public void onRatingChanged(RatingBar ratingBar, float rating,	boolean fromUser) {
 
			ratingValue.setText(String.valueOf(rating));
 
		}
	});
  }
 
  public void addListenerOnButton() {
 
	ratingBar = (RatingBar) findViewById(R.id.ratingBar);
	button = (Button) findViewById(R.id.button);
 
	//if click on me, then display the current rating value.
	button.setOnClickListener(new OnClickListener() {
 
		@Override
		public void onClick(View v) {
 
			Toast.makeText(MainActivity.this, String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();
		}
 
	});
 
  }
}