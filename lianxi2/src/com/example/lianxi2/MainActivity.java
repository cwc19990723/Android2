package com.example.lianxi2;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private ViewPager viewpager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
		boolean boolean1 = sp.getBoolean("issave", false);
		if(boolean1){
			startActivity(new Intent(MainActivity.this,BActivity.class));
			finish();
		}
		
		
		ViewPager vp = (ViewPager) findViewById(R.id.vp);
		
		ArrayList<View> list = new ArrayList<View>();
		
		LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
		
		list.add(inflater.inflate(R.layout.image1, null));
		list.add(inflater.inflate(R.layout.image2, null));
		
		View view = inflater.inflate(R.layout.image3, null);
		list.add(view);
		
		Adapter adapter = new Adapter(list, MainActivity.this);
		vp.setAdapter(adapter);
		
		Button bt = (Button) view.findViewById(R.id.iv_bt);
		
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,BActivity.class));
				SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
				Editor edit = sp.edit();
				edit.putBoolean("issave", true);
				edit.commit();
			}
		});
	}
}
