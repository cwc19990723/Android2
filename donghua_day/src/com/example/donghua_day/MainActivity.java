package com.example.donghua_day;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.RotateAnimation;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt = (Button) findViewById(R.id.bt);
		
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ObjectAnimator animator = ObjectAnimator.ofFloat(bt, "rotation", 1f,110f,50f,300f,0f,400f);
				animator.setDuration(5000);
				animator.start();
			}
		});
	}
}
