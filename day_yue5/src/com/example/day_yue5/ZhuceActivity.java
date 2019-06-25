package com.example.day_yue5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ZhuceActivity extends Activity {

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
				Intent in = new Intent();
				String zh = zc_zh.getText().toString();
				String mm = zc_mm.getText().toString();
				in.putExtra("zh", zh);
				in.putExtra("mm", mm);
				setResult(200, in);
				finish();
			}
		});
	}
}
