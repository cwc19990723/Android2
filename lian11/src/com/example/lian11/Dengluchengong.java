package com.example.lian11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Dengluchengong extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dengluchengong);
		
		TextView tv = (TextView) findViewById(R.id.dlvg_tv);
		
		Intent in = getIntent();
		String user = in.getStringExtra("name");
		
		tv.setText("»¶Ó­  :"+ user);
	}
}
