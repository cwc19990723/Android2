package com.example.day_yue5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ListviewActivity extends Activity {

	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		
		tv = (TextView) findViewById(R.id.lv_tv);
		Intent in = getIntent();
		String name = in.getStringExtra("n");
		
		tv.setText("��ӭ:"+name);
		
		
	}
}
