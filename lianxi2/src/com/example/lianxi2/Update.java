package com.example.lianxi2;

import java.io.Serializable;
import java.util.ArrayList;

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

	private EditText up_ed1;
	private EditText up_ed2;
	private Intent in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
		
		up_ed1 = (EditText) findViewById(R.id.up_ed1);
		up_ed2 = (EditText) findViewById(R.id.up_ed2);
		Button ok = (Button) findViewById(R.id.up_ok);
		
		in = getIntent();
		User user = (User) in.getSerializableExtra("count");
		
		up_ed1.setText(user.getImage());
		up_ed2.setText(user.getName());
		
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			String wz = up_ed1.getText().toString();
			String nr = up_ed2.getText().toString();
			User user2 = new User(wz, nr);
			
			in.putExtra("context", user2);
			setResult(200,in);
			finish();
			
			}
		});
	}
}
