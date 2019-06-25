package com.example.day_lian;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("InflateParams")
public class GActivity extends Activity {

	private Button dl;
	private Button zc;
	private EditText g_zh;
	private EditText g_mm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_g);
		
		dl = (Button) findViewById(R.id.g_dl);
		zc = (Button) findViewById(R.id.g_zc);
		g_zh = (EditText) findViewById(R.id.g_zh);
		g_mm = (EditText) findViewById(R.id.g_mm);
		
		zc.setOnClickListener(new View.OnClickListener() {
			
			private AlertDialog builder;
			private View view;

			@Override
			public void onClick(View v) {
				view = LayoutInflater.from(GActivity.this).inflate(R.layout.item, null);
				
				builder = new AlertDialog.Builder(GActivity.this)
				.setTitle("标题")
				.setView(view)
				.setIcon(R.drawable.hj)
				.create();
				builder.show();
				
				Button it_quxiao = (Button) view.findViewById(R.id.it_quxiao);
				it_quxiao.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						builder.cancel();
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
						  
						g_zh.setText(user);
						g_mm.setText(psw);
						
						builder.cancel();
					}
				});
				
			}
		});
		
		//登陆
		Button dl = (Button) findViewById(R.id.g_dl);
		dl.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String ss = g_zh.getText().toString();
				Toast.makeText(GActivity.this, ss+"欢迎 :", Toast.LENGTH_SHORT).show();
			}
		});
		
	}
}
