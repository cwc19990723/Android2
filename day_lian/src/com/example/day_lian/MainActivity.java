package com.example.day_lian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private RadioButton nan;
	private RadioButton nv;
	private Button tiao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		nan = (RadioButton) findViewById(R.id.id_nan);
		nv = (RadioButton) findViewById(R.id.id_nv);
		tiao = (Button) findViewById(R.id.a_tiao);
		
		nan.setOnClickListener(this);
		nv.setOnClickListener(this);
		tiao.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.id_nan:
			Toast.makeText(this, "ÄÐ", Toast.LENGTH_SHORT).show();
			break;
		case R.id.id_nv:
			Toast.makeText(this, "Å®", Toast.LENGTH_SHORT).show();
			break;
		case R.id.a_tiao:
			startActivity(new Intent(MainActivity.this,BActivity.class));
			break;

		default:
			break;
		}
	}
}
