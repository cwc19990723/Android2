package com.example.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add extends Activity {

	private EditText add_zi1;
	private EditText add_zi2;
	private EditText add_zi3;
	private Button ok;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		
		add_zi1 = (EditText) findViewById(R.id.add_zi1);
		add_zi2 = (EditText) findViewById(R.id.add_zi2);
		add_zi3 = (EditText) findViewById(R.id.add_zi3);
		ok = (Button) findViewById(R.id.add_ok);
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in = new Intent();
				String wz = add_zi1.getText().toString();
				String bt = add_zi2.getText().toString();
				String nr = add_zi3.getText().toString();
				
				User user = new User(wz, bt, nr);
				in.putExtra("add", user);
				setResult(200, in);
				finish();
			}
		});
	}
}
