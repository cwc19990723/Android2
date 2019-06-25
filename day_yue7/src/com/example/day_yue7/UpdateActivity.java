package com.example.day_yue7;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends Activity {

	private EditText bt;
	private EditText wz;
	private EditText nr;
	private Button ok;
	private User user;
	private Intent in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
		
		bt = (EditText) findViewById(R.id.up_bt);
		nr = (EditText) findViewById(R.id.up_nr);
		wz = (EditText) findViewById(R.id.up_wz);
		ok = (Button) findViewById(R.id.up_ok);
		
		in = getIntent();
		user = (User) in.getSerializableExtra("up");
		
		wz.setText(user.getImg());
		nr.setText(user.getInfo());
		bt.setText(user.getName());
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String wz1 = wz.getText().toString();
				String bt1 = bt.getText().toString();
				String nr1 = nr.getText().toString();
				
				user.setImg(wz1);
				user.setName(bt1);
				user.setInfo(nr1);
				
				in.putExtra("context", user);
				setResult(200, in);
				finish();
				
			}
		});
	}
}
