package com.example.jiexi1;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_c);
		
		ImageView tu = (ImageView) findViewById(R.id.iv);
		TextView it_zi1 = (TextView) findViewById(R.id.it_zi1);
		TextView it_zi2 = (TextView) findViewById(R.id.it_zi2);
		
		Intent in = getIntent();
		User user = (User) in.getSerializableExtra("count");
		
		MyTask task = new MyTask(tu);
		task.execute(user.getImg());
		it_zi1.setText(user.getName());
		it_zi2.setText(user.getInfo());
		
	}
}
