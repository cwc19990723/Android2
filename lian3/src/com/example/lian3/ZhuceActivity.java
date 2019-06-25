package com.example.lian3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ZhuceActivity extends Activity {

	private EditText zc_yhm;
	private EditText zc_mm;
	private EditText zc_cfmm;
	private Button zc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhuce);
		
		zc_yhm = (EditText) findViewById(R.id.zc_yhm);
		zc_mm = (EditText) findViewById(R.id.zc_mm);
		zc_cfmm = (EditText) findViewById(R.id.zc_cfmm);
		zc = (Button) findViewById(R.id.zc_zc);
		
		zc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String yhm = zc_yhm.getText().toString();
				String mm = zc_mm.getText().toString();
				String cfmm = zc_cfmm.getText().toString();
				
				if(!yhm.isEmpty()&&!mm.isEmpty()&&!cfmm.isEmpty()){
					if(mm.equals(cfmm)){
						Intent in = new Intent();
						in.putExtra("yhm", yhm);
						in.putExtra("mm", mm);
						setResult(200,in);
						finish();
					}else {
						Toast.makeText(ZhuceActivity.this, "密码和重复密码不一致", Toast.LENGTH_SHORT).show();
					}
				}else {
					Toast.makeText(ZhuceActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
