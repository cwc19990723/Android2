package com.example.day_lian;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Chuanzhi extends Activity {

	private Button bt;
	private EditText aed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chuanzhi);
		
		bt = (Button) findViewById(R.id.chuan_bt);
		aed = (EditText) findViewById(R.id.chuan_aed);
		
		
	}
}
