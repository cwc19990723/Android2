package com.example.day_yue5;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private Button dl;
	private Button zc;
	private EditText dl_zh;
	private EditText dl_mm;
	private CheckBox dl_jzmm;
	private String name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dl = (Button) findViewById(R.id.dl_dl);
		zc = (Button) findViewById(R.id.dl_zc);
		dl_zh = (EditText) findViewById(R.id.dl_zh);
		dl_mm = (EditText) findViewById(R.id.dl_mm);
		dl_jzmm = (CheckBox) findViewById(R.id.dl_jzmm);
		
		SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
		boolean boolean1 = sp.getBoolean("issave", false);
		if(boolean1){
			String user = sp.getString("z", "");
			String psw = sp.getString("m", "");
			//显示到上面
			dl_zh.setText(user);
			dl_mm.setText(psw);
			
		}
		
		dl_jzmm.setChecked(boolean1);
		
		dl.setOnClickListener(this);
		zc.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dl_zc:
			Intent in = new Intent(MainActivity.this,ZhuceActivity.class);
			startActivityForResult(in, 100);
			break;
		case R.id.dl_dl:
			dl();
			break;

		default:
			break;
		}
	}
	//登陆
	private void dl() {
		SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
		Editor edit = sp.edit();
		//记住密码状态
		boolean checked = dl_jzmm.isChecked();
		if(checked){
			String user = dl_zh.getText().toString();
			String psw = dl_mm.getText().toString();
			edit.putString("z", user);
			edit.putString("m", psw);
			
			Intent in = new Intent(MainActivity.this,ListviewActivity.class);
			in.putExtra("n", name);
			startActivity(in);
		}
		//记住密码状态
		edit.putBoolean("issave", checked);
		//提交数据
		edit.commit();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==100&&resultCode==200){
			String zhang = data.getStringExtra("zh");
			String mi = data.getStringExtra("mm");
			dl_zh.setText(zhang);
			dl_mm.setText(mi);
		}
	}
	
}
