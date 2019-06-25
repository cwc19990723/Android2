package com.example.day_xue_xiangmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Zhuce extends Activity {

	private EditText zc_zh;
	private EditText zc_mm;
	private EditText zc_qrmm;
	private Button zc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhuce);
		
		zc_zh = (EditText) findViewById(R.id.zc_zh);
		zc_mm = (EditText) findViewById(R.id.zc_mm);
		zc_qrmm = (EditText) findViewById(R.id.zc_qrmm);
		zc = (Button) findViewById(R.id.zc_zc);
		
		zc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in = new Intent();
				String user = zc_zh.getText().toString();
				String psw = zc_mm.getText().toString();
				String qrmm = zc_qrmm.getText().toString();
				
				if(!user.isEmpty()&&!psw.isEmpty()&&!qrmm.isEmpty()){
					if(psw.equals(qrmm)){
						in.putExtra("zh", user);
						in.putExtra("mm", psw);
						setResult(200, in);
						finish();
					}else {
						Toast.makeText(Zhuce.this, "密码不一致", Toast.LENGTH_SHORT).show();
					}
				}else {
					Toast.makeText(Zhuce.this, "不能为空", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
