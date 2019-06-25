package com.example.day6_intentchuanzhi;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class BActivity extends Activity implements OnClickListener {

	private TextView b_te;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		Intent intent = getIntent();
		
		User u = (User) intent.getSerializableExtra("1");
		
		b_te = (TextView) findViewById(R.id.b_te);
		
		b_te.setText(u.getName()+u.getAge());
		
	}

	@Override
	public void onClick(View v) {
		
	}
}
