package com.example.day_donghua;

import android.R.anim;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private Button yinxing;
	private ImageView iv;
	private Button yidong;
	private Button zhen;
	private ImageView zhen_iv;
	private Button btzhen;
	private ImageView tu;
	private Button jihe;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		yinxing = (Button) findViewById(R.id.bt_yinxing);
		iv = (ImageView) findViewById(R.id.iv);
		yidong = (Button) findViewById(R.id.bt_yidong);
		zhen = (Button) findViewById(R.id.bt_zhen);
		zhen_iv = (ImageView) findViewById(R.id.zhen_iv);
		btzhen = (Button) findViewById(R.id.btzhen);
		tu = (ImageView) findViewById(R.id.iv_tu);
		jihe = (Button) findViewById(R.id.bt_jihe);
		
		btzhen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AnimationDrawable aiAnimation = (AnimationDrawable) tu.getBackground();
				aiAnimation.start();
			}
		});
		
		zhen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AnimationDrawable aiAnimation = (AnimationDrawable) zhen_iv.getBackground();
				aiAnimation.start();
			}
		});
		
		yidong.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_translate);
				yidong.startAnimation(animation);
			}
		});
		
		jihe.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_jihe);
				iv.startAnimation(animation);
			}
		});
		
		yinxing.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_alpha);
				yinxing.startAnimation(animation);
			}
		});
		
		
	}
}
