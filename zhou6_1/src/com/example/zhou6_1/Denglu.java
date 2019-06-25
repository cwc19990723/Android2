package com.example.zhou6_1;

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

public class Denglu extends Activity implements OnClickListener {

	private EditText dl_zh;
	private EditText dl_mm;
	private Button dl;
	private Button zc;
	private CheckBox jzmm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_denglu);
		
		dl_zh = (EditText) findViewById(R.id.dl_zh);
		dl_mm = (EditText) findViewById(R.id.dl_mm);
		jzmm = (CheckBox) findViewById(R.id.dl_jzmm);
		dl = (Button) findViewById(R.id.dl_dl);
		zc = (Button) findViewById(R.id.dl_zc);
		
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
			Intent in = new Intent(Denglu.this,Zhuce.class);
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
