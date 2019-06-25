package com.example.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Zhuce extends Activity {

	private EditText zh;
	private EditText mm;
	private Button zc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhuce);
		
		zh = (EditText) findViewById(R.id.zc_zh);
		mm = (EditText) findViewById(R.id.zc_zh);
		zc = (Button) findViewById(R.id.zc_zc);
		
		zc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in = new Intent();
				String user = zh.getText().toString();
				String psw = mm.getText().toString();
				in.putExtra("zh", user);
				in.putExtra("mm", psw);
				setResult(200, in);
				finish();
			}
		});
	}
}
