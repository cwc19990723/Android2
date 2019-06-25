package com.example.day_yue9;

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

public class DengluActivity extends Activity implements OnClickListener {

	private Button dl;
	private Button zc;
	private EditText dl_zh;
	private EditText dl_mm;
	private CheckBox dl_jzmm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_denglu);
		
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
		case R.id.dl_dl:
			denglu();
			break;
		case R.id.dl_zc:
			zhuce();
			break;

		default:
			break;
		}
	}

	private void denglu() {
		SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
		Editor edit = sp.edit();
		boolean checked = dl_jzmm.isChecked();
		if(checked){
			String user = dl_zh.getText().toString();
			String psw = dl_mm.getText().toString();
			
			edit.putString("z", user);
			edit.putString("m", psw);
			
			startActivity(new Intent(DengluActivity.this,ListviewActivity.class));
		}
		
		edit.putBoolean("issave", checked);
		edit.commit();
		
	}

	private void zhuce() {
		Intent in = new Intent(DengluActivity.this,ZhuceActivity.class);
		startActivityForResult(in, 100);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==100&&resultCode==200){
			String user = data.getStringExtra("z");
			String psw = data.getStringExtra("m");
			dl_zh.setText(user);
			dl_mm.setText(psw);
		}
	}
	
}
