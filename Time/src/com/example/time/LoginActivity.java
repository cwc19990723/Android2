package com.example.time;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {

	private EditText log_zh;
	private EditText log_mm;
	private CheckBox jzmm;
	private Button dl;
	private Button zc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
		boolean boolean1 = sp.getBoolean("issave", false);
		if(boolean1){
			String user = sp.getString("z", "");
			String psw = sp.getString("z", "");
			
			Intent in = new Intent(LoginActivity.this,LActivity.class);
			in.putExtra("s", user);
			startActivity(in);
		}
		
		initView();
	}

	private void initView() {
		log_zh = (EditText) findViewById(R.id.log_zh);
		log_mm = (EditText) findViewById(R.id.log_mm);
		jzmm = (CheckBox) findViewById(R.id.log_jzmm);
		dl = (Button) findViewById(R.id.log_dl);
		zc = (Button) findViewById(R.id.log_zc);
		
		dl.setOnClickListener(this);
		zc.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.log_dl:
			denglu();
			break;
		case R.id.log_zc:
			Intent in = new Intent(LoginActivity.this,ZhuceActivity.class);
			startActivityForResult(in, 100);
			break;

		default:
			break;
		}
	}

	private void denglu() {
		String user = log_zh.getText().toString();
		String psw = log_mm.getText().toString();
		
		if(!user.isEmpty()&&!psw.isEmpty()){
			if(user.matches("[0-9]{6,16}")&&psw.matches("[0-9a-zA-Z]{6,16}")){
				startActivity(new Intent(LoginActivity.this,LActivity.class));
				
				if(jzmm.isChecked()){
					SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
					Editor edit = sp.edit();
					edit.putBoolean("issave", true);
					edit.putString("z", user);
					edit.putString("m", psw);
					edit.commit();
				}
			}else {
				Toast.makeText(LoginActivity.this, "账号或密码不符合规定", Toast.LENGTH_SHORT).show();
			}
		}else {
			Toast.makeText(LoginActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		String user = data.getStringExtra("zh");
		String psw = data.getStringExtra("mm");
		
		log_zh.setText(user);
		log_mm.setText(psw);
	}
	
}
