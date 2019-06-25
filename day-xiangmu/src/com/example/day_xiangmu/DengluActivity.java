package com.example.day_xiangmu;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DengluActivity extends Activity implements OnClickListener {

	private EditText ed_zh;
	private EditText ed_mm;
	private Button bt_zc;
	private Button bt_dl;
	private LinearLayout ll_login;
	private String name;
	private String psw;
	
	Handler hand = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 3:
				//注册成功 跳转到主界面
				Intent intent = new Intent(DengluActivity.this,GuanggaoActivity.class);
				intent.putExtra("n", name);
				startActivity(intent);
				break;
			case 2:
				Toast.makeText(DengluActivity.this, "账号或密码不对", Toast.LENGTH_LONG).show();
				break;

			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ed_zh = (EditText) findViewById(R.id.ed_zh);
		ed_mm = (EditText) findViewById(R.id.ed_mm);
		bt_zc = (Button) findViewById(R.id.bt_zc);
		bt_dl = (Button) findViewById(R.id.bt_dl);
		ll_login = (LinearLayout) findViewById(R.id.ll_login);
		//设置监听
		bt_dl.setOnClickListener(this);
		bt_zc.setOnClickListener(this);
		
	}
	//点击处理
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_zc://转跳注册界面
			Intent intent = new Intent(DengluActivity.this,ZhuceActivity.class);
			startActivity(intent);
			break;
		case R.id.bt_dl://转跳登陆界面
			login();//自定义方法名
			break;

		default:
			break;
		}
	}
	//登陆 
	private void login() {
		String zh = ed_zh.getText().toString();
		String mm = ed_mm.getText().toString();
		
		//非空判断
		if(!zh.isEmpty()&&!mm.isEmpty()){
			//一致判断 是否符合 账号密码 条件
			if(zh.matches("[0-9]{6}")&&mm.matches("[0-9a-zA-Z]{8,18}")){
				startActivity(new Intent(DengluActivity.this,GuanggaoActivity.class));
			}else {
				Toast.makeText(DengluActivity.this, "格式不正确", Toast.LENGTH_LONG).show();
			}
			
		}else {
			Toast.makeText(DengluActivity.this, "账号或密码不能为空", Toast.LENGTH_LONG).show();
		}
		
	}

}
