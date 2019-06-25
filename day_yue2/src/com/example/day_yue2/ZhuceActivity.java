package com.example.day_yue2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ZhuceActivity extends Activity {

	private EditText zc_zh;
	private EditText zc_mm;
	private EditText zc_qrmm;
	private Button ok;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhuce);
		
		zc_zh = (EditText) findViewById(R.id.zc_zh);
		zc_mm = (EditText) findViewById(R.id.zc_mm);
		zc_qrmm = (EditText) findViewById(R.id.zc_qrmm);
		ok = (Button) findViewById(R.id.zc_ok);
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String user = zc_zh.getText().toString();
				String psw = zc_mm.getText().toString();
				String qrmm = zc_qrmm.getText().toString();
				if(psw.equals(qrmm)){
					Intent in = new Intent();
					in.putExtra("zh", user);
					in.putExtra("mm", psw);
					setResult(200, in);
					finish();
				}else {
					Toast.makeText(ZhuceActivity.this, "ÃÜÂë²»Ò»ÖÂ", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}
