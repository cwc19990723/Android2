package com.example.lian11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Zhuce extends Activity {

	private EditText zc_zh;
	private EditText zc_mm;
	private Button zc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhuce);
		
		zc_zh = (EditText) findViewById(R.id.zc_zh);
		zc_mm = (EditText) findViewById(R.id.zc_mm);
		zc = (Button) findViewById(R.id.zc_zc);
		
		zc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String user = zc_zh.getText().toString();
				String psw = zc_mm.getText().toString();
				Intent in = new Intent();
				in.putExtra("zh", user);
				in.putExtra("mm", psw);
				setResult(200, in);
				finish();
			}
		});
	}
}
