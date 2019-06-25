package com.example.day7_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class BActivity extends Activity {

	private Button b_zc;
	private EditText b_zh;
	private EditText b_mm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		b_zc = (Button) findViewById(R.id.b_zc);
		
		b_zh = (EditText) findViewById(R.id.b_zh);
		b_mm = (EditText) findViewById(R.id.b_mm);
		
		b_zc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent id = new Intent();
				if(!b_zh.equals("")&&!b_mm.equals("")){
				String zh = b_zh.getText().toString();
				String mm = b_mm.getText().toString();
				id.putExtra("zh", zh);
				id.putExtra("mm", mm);
				setResult(200, id);
				finish();
				}
			}
		});
	}
}
