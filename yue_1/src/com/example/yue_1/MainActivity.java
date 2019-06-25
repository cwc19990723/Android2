package com.example.yue_1;

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

	private ViewPager vp;
	private Button it_bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		vp = (ViewPager) findViewById(R.id.vp);
		     
		SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
		boolean boolean1 = sp.getBoolean("status", false);
		if(boolean1){
			Intent intent = new Intent(MainActivity.this,BActivity.class);
			startActivity(intent);
		}else {
			
			ArrayList<View> al = new ArrayList<View>();
			al.add(LayoutInflater.from(this).inflate(R.layout.item1, null));
			al.add(LayoutInflater.from(this).inflate(R.layout.item2, null));
			al.add(LayoutInflater.from(this).inflate(R.layout.item3, null));
			View view = LayoutInflater.from(this).inflate(R.layout.item4, null);
			it_bt = (Button) view.findViewById(R.id.it_bt);
			
			al.add(view);
			
			ParseAdapter adapter = new ParseAdapter(al);
			
			vp.setAdapter(adapter);
			
			it_bt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
					Editor edit = sp.edit();
					
					edit.putBoolean("status", true);
					edit.commit();
					
					Intent intent = new Intent(MainActivity.this,BActivity.class);
					startActivity(intent);
				}
			});
		}
		
	}
}
