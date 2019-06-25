package com.example.qizhong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button dl;
	private EditText dl_phone;
	private EditText dl_psw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dl = (Button) findViewById(R.id.dl_dl);
		dl_phone = (EditText) findViewById(R.id.dl_phone);
		dl_psw = (EditText) findViewById(R.id.dl_psw);
		
		dl.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String phone = dl_phone.getText().toString();
				String psw = dl_psw.getText().toString();
				
				if(phone.equals("110")&&psw.equals("123")){
					Toast.makeText(MainActivity.this, "手机号为"+phone+"\n"+"密码为"+psw, Toast.LENGTH_SHORT).show();
					startActivity(new Intent(MainActivity.this,Listview.class));
				}else {  
					Toast.makeText(MainActivity.this, "账号或密码不符合要求", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
