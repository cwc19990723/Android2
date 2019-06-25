package com.example.day_14_sql1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private EditText ed_name;
	private EditText ed_age;
	private EditText ed_sex;
	private Button insert;
	private Button select;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ed_name = (EditText) findViewById(R.id.ed_name);
		ed_age = (EditText) findViewById(R.id.ed_age);
		ed_sex = (EditText) findViewById(R.id.ed_sex);
		insert = (Button) findViewById(R.id.bt_insert);
		select = (Button) findViewById(R.id.bt_select);
		
		insert.setOnClickListener(this);
		select.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_insert:
			//insert();
			break;

		default:
			break;
		}
	}

	/*private void insert() {
		String name = ed_name.getText().toString();
		String age = ed_name.getText().toString();
		String sex = ed_name.getText().toString();
		
		new Sql(MainActivity.this).insert(new Ccc(0, name, Integer.parseInt(age), sex));
	}*/
	
	
	
}
