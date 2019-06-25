package com.example.lian_donghua;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.a_tv);
		
		Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_rotate);
		tv.setAnimation(animation);
		
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				long duration = animation.getDuration();
				Log.e("anim", duration+"");
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				startActivity(new Intent(MainActivity.this,Socked.class));
			}
		});
	}
}
