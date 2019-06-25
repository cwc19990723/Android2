package com.example.day_zuo_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button dl;
	private Button zc;
	private EditText a_zh;
	private EditText a_mm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dl = (Button) findViewById(R.id.a_dl);
		zc = (Button) findViewById(R.id.a_zc);
		a_zh = (EditText) findViewById(R.id.a_zh);
		a_mm = (EditText) findViewById(R.id.a_mm);
		
		zc.setOnClickListener(new View.OnClickListener() {
			
			private AlertDialog dialog;

			@Override
			public void onClick(View v) {
				final View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null);
				
				dialog = new AlertDialog.Builder(MainActivity.this).setTitle("标题")
				.setView(view)
				.setIcon(R.drawable.hj)
				.create();
				dialog.show();
				
				//取消
				Button quxiao = (Button) view.findViewById(R.id.it_quxiao);
				quxiao.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						dialog.cancel();
					}
				});
				
				//确认
				Button ok = (Button) view.findViewById(R.id.it_ok);
				ok.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						EditText it_zh = (EditText) view.findViewById(R.id.it_zh);
						EditText it_mm = (EditText) view.findViewById(R.id.it_mm);
						
						String user = it_zh.getText().toString();
						String psw = it_mm.getText().toString();
						
						a_zh.setText(user);
						a_mm.setText(psw);
						
						dialog.cancel();
					}
				});
				
			}
		});
		
		dl.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String user = a_zh.getText().toString();
				String psw = a_mm.getText().toString();
				if(user.equals("jiyun123")&&psw.equals("123jiyun")){
					startActivity(new Intent(MainActivity.this,BActivity.class));
				}else {
					Toast.makeText(MainActivity.this, "账号或密码不正确", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
