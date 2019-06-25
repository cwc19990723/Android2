package com.example.day_yue7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends Activity implements OnClickListener {

	private EditText add_bt;
	private EditText add_wz;
	private EditText add_nr;
	private Button ok;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		
		add_bt = (EditText) findViewById(R.id.add_bt);
		add_wz = (EditText) findViewById(R.id.add_wz);
		add_nr = (EditText) findViewById(R.id.add_nr);
		ok = (Button) findViewById(R.id.add_ok);
		
		ok.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
			String bt = add_bt.getText().toString();
			String wz = add_wz.getText().toString();
			String nr = add_nr.getText().toString();
			
			User user = new User(wz, bt, nr);
			
			Intent in = new Intent();
			in.putExtra("add", user);
			setResult(400, in);
			finish();
	}
}
