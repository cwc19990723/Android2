package com.example.day_yue3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ZhuceActivity extends Activity {

	private EditText zc_mm;
	private EditText zc_zh;
	private Button ok;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhuce);
		
		zc_mm = (EditText) findViewById(R.id.zc_mm);
		zc_zh = (EditText) findViewById(R.id.zc_zh);
		ok = (Button) findViewById(R.id.zc_ok);
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in = new Intent();
				String user = zc_zh.getText().toString();
				String psw = zc_mm.getText().toString();
				in.putExtra("zh", user);
				in.putExtra("mm", psw);
				setResult(200, in);
				finish();
			}
		});
	}
}
