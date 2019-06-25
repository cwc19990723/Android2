package com.example.zuo_day5;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add extends Activity {

	private EditText add_wz;
	private EditText add_bt;
	private EditText add_nr;
	private Button ok;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		
		add_wz = (EditText) findViewById(R.id.add_wz);
		add_bt = (EditText) findViewById(R.id.add_bt);
		add_nr = (EditText) findViewById(R.id.add_nr);
		ok = (Button) findViewById(R.id.add_ok);
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String string = add_wz.getText().toString();
			}
		});
	}
}
