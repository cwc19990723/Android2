package com.example.day_yue9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import bean.lol;

public class AddActivity extends Activity {

	private EditText add_name;
	private EditText add_zhiye;
	private EditText add_address;
	private Button ok;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		
		add_name = (EditText) findViewById(R.id.add_name);
		add_zhiye = (EditText) findViewById(R.id.add_zhiye);
		add_address = (EditText) findViewById(R.id.add_address);
		ok = (Button) findViewById(R.id.add_ok);
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = add_name.getText().toString();
				String zhiye = add_zhiye.getText().toString();
				String address = add_address.getText().toString();
				
				lol lol = new lol(name, zhiye, address);
				
				Intent in = new Intent();
				in.putExtra("add", lol);
				setResult(200, in);
				finish();
			}
		});
	}
}
