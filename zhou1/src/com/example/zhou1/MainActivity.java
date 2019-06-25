package com.example.zhou1;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private ViewPager pager;
	private ViewPager vp;
	private ArrayList<View> list;
	private Button bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		vp = (ViewPager) findViewById(R.id.a_vp);
		
		list = new ArrayList<View>();
		
		View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.image1, null);
		View view2 = LayoutInflater.from(MainActivity.this).inflate(R.layout.image2, null);
		View view3 = LayoutInflater.from(MainActivity.this).inflate(R.layout.image3, null);
		View view4 = LayoutInflater.from(MainActivity.this).inflate(R.layout.image4, null);
		
		list.add(view1);
		list.add(view2);
		list.add(view3);
		list.add(view4);
		
		Adapter adapter = new Adapter(list, MainActivity.this);
		vp.setAdapter(adapter);
		
		bt = (Button) view4.findViewById(R.id.img_bt);
		
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,BActivity.class));
			}
		});
	}
}
