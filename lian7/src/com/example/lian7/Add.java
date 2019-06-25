package com.example.lian7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add extends Activity {

	private EditText add_ed1;
	private EditText add_ed2;
	private Button ok;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		
		add_ed1 = (EditText) findViewById(R.id.add_ed1);
		add_ed2 = (EditText) findViewById(R.id.add_ed2);
		ok = (Button) findViewById(R.id.add_ok);
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String bt = add_ed1.getText().toString();
				String nr = add_ed2.getText().toString();
				
				User user = new User(1, bt, nr);
				
				Intent in = new Intent();
				in.putExtra("add", user);
				setResult(400,in);
				finish();
			}
		});
	}
}
