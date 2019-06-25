package com.example.lian7;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends Activity {

	private EditText up_ed1;
	private EditText up_ed2;
	private Button ok;
	private Intent in;
	private User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
		
		up_ed1 = (EditText) findViewById(R.id.up_ed1);
		up_ed2 = (EditText) findViewById(R.id.up_ed2);
		ok = (Button) findViewById(R.id.up_ok);
		
		in = getIntent();
		user = (User) in.getSerializableExtra("up");
		
		up_ed1.setText(user.getName());
		up_ed2.setText(user.getContext());
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String ed1 = up_ed1.getText().toString();
				String ed2 = up_ed2.getText().toString();
				
				user.setName(ed1);
				user.setContext(ed2);
				
				in.putExtra("context", user);
				setResult(200,in);
				finish();
			}
		});
	}
}
