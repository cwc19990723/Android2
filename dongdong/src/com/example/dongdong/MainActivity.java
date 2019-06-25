package com.example.dongdong;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private Button bt;
	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt = (Button) findViewById(R.id.bt);
		iv = (ImageView) findViewById(R.id.iv);
		
		bt.setOnClickListener(new OnClickListener() {
			
			private ValueAnimator animator;

			@Override
			public void onClick(View v) {
				animator = ValueAnimator.ofFloat(0,1080);
				animator.addUpdateListener(new AnimatorUpdateListener() {
					
					@Override
					public void onAnimationUpdate(ValueAnimator animation) {
						float value = (Float) animator.getAnimatedValue();
						Log.i("msg", value+"");
						iv.setRotation(value);
						iv.setY(value);
						
					}
				});
				animator.setDuration(5000);
				animator.start();
				
			}
		});
	}
}
