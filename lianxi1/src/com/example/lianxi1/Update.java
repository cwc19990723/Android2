package com.example.lianxi1;

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
	private Intent in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
		
		ok = (Button) findViewById(R.id.up_ok);
		up_zi1 = (EditText) findViewById(R.id.up_zi1);
		up_zi2 = (EditText) findViewById(R.id.up_zi2);
		
		in = getIntent();
		User user = (User) in.getSerializableExtra("up");
		
		up_zi1.setText(user.getImage());
		up_zi2.setText(user.getName());
		
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String wz = up_zi1.getText().toString();
				String nr = up_zi2.getText().toString();
				User user2 = new User(wz, nr);
				
				in.putExtra("context", user2);
				setResult(200, in);
				finish();
			}
		});
	}
}
