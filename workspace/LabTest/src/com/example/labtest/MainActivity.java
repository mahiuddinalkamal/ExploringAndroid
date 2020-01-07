package com.example.labtest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView img;
	AnimationDrawable animationControler;
	Button btnGo;
	MediaPlayer player;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		img = (ImageView) findViewById(R.id.imageView1);
		img.setImageResource(R.drawable.frameanimation);

		animationControler = (AnimationDrawable) img.getDrawable();
		animationControler.start();

		player = MediaPlayer.create(this, R.raw.song);
		player.setLooping(true);
		player.start();

		btnGo = (Button) findViewById(R.id.btnLog);

		btnGo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub

				player.stop();

				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				startActivity(intent);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
