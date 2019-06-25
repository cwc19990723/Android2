package com.example.yue_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class AddActivity extends Activity implements OnClickListener {

	private EditText add_ed;
	private TextView add_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		
		add_ed = (EditText) findViewById(R.id.add_ed);
		add_tv = (TextView) findViewById(R.id.add_tv);
		
		add_tv.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		Intent intent = new Intent();
		
		intent.putExtra("context",add_ed.getText().toString());
		setResult(200, intent);
		finish();
	}
}
