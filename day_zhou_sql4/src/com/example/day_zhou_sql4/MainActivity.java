package com.example.day_zhou_sql4;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private Button a_add;
	private Button a_cha;
	private EditText a_name;
	private EditText a_techang;
	private EditText a_address;
	private EditText a_sex;
	
	Handler hand = new Handler(){
		private ArrayList<User> list;

		public void handleMessage(android.os.Message msg) {
			list = (ArrayList<User>) msg.obj;
			
			
			
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		a_add = (Button) findViewById(R.id.a_add);
		a_cha = (Button) findViewById(R.id.a_cha);
		a_name = (EditText) findViewById(R.id.a_name);
		a_address = (EditText) findViewById(R.id.a_address);
		a_sex = (EditText) findViewById(R.id.a_sex);
		a_techang = (EditText) findViewById(R.id.a_techang);
		
		a_add.setOnClickListener(this);
		a_cha.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.a_add://添加
			charu();
			break;
		case R.id.a_cha://查询
			Intent intent = new Intent(MainActivity.this,ListviewActivity.class);
			break;

		default:
			break;
		}
	}
	//插入方法
	private void charu() {
		String name = a_name.getText().toString();
		String address = a_address.getText().toString();
		String sex = a_sex.getText().toString();
		String techang = a_techang.getText().toString();
		
		MySql sql = new MySql(MainActivity.this, "my.db", null, 1);
		sql.insert(new User(0, "http://192.168.1.52:8080/test1/t1.jpg", name, address, sex, techang));
	}
}
