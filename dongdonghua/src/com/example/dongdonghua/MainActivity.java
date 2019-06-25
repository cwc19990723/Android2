package com.example.dongdonghua;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
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
			
			@Override
			public void onClick(View v) {
				ObjectAnimator animator = ObjectAnimator.ofFloat(iv,  "alpha", 1,0).setDuration(3000);
				animator.setRepeatCount(animator.INFINITE);
				animator.setRepeatMode(animator.REVERSE);
				ObjectAnimator animator1 = ObjectAnimator.ofFloat(iv,  "rotation", 1,500).setDuration(3000);
				animator1.setRepeatCount(-1);
				animator1.setRepeatMode(animator1.REVERSE);
				
				AnimatorSet set = new AnimatorSet();
				//先播放animator1以后再播放animator
				set.play(animator).with(animator1);
				set.start();
			}
		});
	}
}
