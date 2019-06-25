package com.example.day_yue6;

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

public class MainActivity extends Activity implements OnClickListener {

	private Button dl;
	private Button zc;
	private EditText dl_zh;
	private EditText dl_mm;
	private CheckBox jzmm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dl = (Button) findViewById(R.id.dl_dl);
		zc = (Button) findViewById(R.id.dl_zc);
		dl_zh = (EditText) findViewById(R.id.dl_zh);
		dl_mm = (EditText) findViewById(R.id.dl_mm);
		jzmm = (CheckBox) findViewById(R.id.dl_jzmm);
		
		SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
		boolean boolean1 = sp.getBoolean("issave", false);
		if(boolean1){
			String user = sp.getString("z", "");
			String psw = sp.getString("m", "");
			
			dl_zh.setText(user);
			dl_mm.setText(psw);
		}
		jzmm.setChecked(boolean1);
		
		dl.setOnClickListener(this);
		zc.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dl_dl:
			denglu();
			break;
		case R.id.dl_zc:
			Intent in = new Intent(MainActivity.this,ZhuceActivity.class);
			startActivityForResult(in, 100);
			break;

		default:
			break;
		}
	}

	private void denglu() {
		SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
		Editor edit = sp.edit();
		boolean checked = jzmm.isChecked();
		if(checked){
			String user = dl_zh.getText().toString();
			String psw = dl_mm.getText().toString();
			
			edit.putString("z", user);
			edit.putString("m", psw);
			
			//非空判断
			if(!user.isEmpty()&&!psw.isEmpty()){
				//判断账号密码是否符合规定
				if(user.matches("[0-9]{6}")&&psw.matches("[0-9a-zA-Z]{8,18}")){
					
					//符合就条转
					startActivity(new Intent(MainActivity.this,ListviewActivity.class));
					
				}else {
					Toast.makeText(MainActivity.this, "账号或者密码不符合规定", Toast.LENGTH_LONG).show();
				}
			}else {
				Toast.makeText(MainActivity.this, "账号或者密码不能为空", Toast.LENGTH_LONG).show();
			}
		}
		
		edit.putBoolean("issave", checked);
		edit.commit();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==100&&resultCode==200){
			String user = data.getStringExtra("zh");
			String psw = data.getStringExtra("mm");
			dl_zh.setText(user);
			dl_mm.setText(psw);
		}
	}
	
}
