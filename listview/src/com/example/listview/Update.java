package com.example.listview;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Update extends Activity {

	private Button ok;
	private EditText up_zi1;
	private EditText up_zi2;
	private EditText up_zi3;
	private Intent in;
	private User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
		
		up_zi1 = (EditText) findViewById(R.id.up_zi1);
		up_zi2 = (EditText) findViewById(R.id.up_zi2);
		up_zi3 = (EditText) findViewById(R.id.up_zi3);
		ok = (Button) findViewById(R.id.up_ok);
		
		in = getIntent();
		user = (User) in.getSerializableExtra("up");
		
		up_zi1.setText(user.getImg());
		up_zi2.setText(user.getName());
		up_zi3.setText(user.getInfo());
		
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String wz = up_zi1.getText().toString();
				String bt = up_zi2.getText().toString();
				String nr = up_zi3.getText().toString();
				
				user.setImg(wz);
				user.setName(bt);
				user.setInfo(nr);
				
				in.putExtra("context", user);
				setResult(400,in);
				finish();
			}
		});
	}
}
