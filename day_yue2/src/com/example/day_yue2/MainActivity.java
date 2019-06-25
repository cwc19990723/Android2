package com.example.day_yue2;

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

public class MainActivity extends Activity implements OnClickListener {

	private EditText dl_mm;
	private EditText dl_zh;
	private Button zc;
	private Button dl;
	private CheckBox jzmm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dl_mm = (EditText) findViewById(R.id.dl_mm);
		dl_zh = (EditText) findViewById(R.id.dl_zh);
		zc = (Button) findViewById(R.id.dl_zc);
		dl = (Button) findViewById(R.id.dl_dl);
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
		case R.id.dl_zc:
			Intent in = new Intent(MainActivity.this,ZhuceActivity.class);
			startActivityForResult(in, 100);
			break;
		case R.id.dl_dl:
			denglu();
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
			
			startActivity(new Intent(MainActivity.this,ListviewActivity.class));
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
