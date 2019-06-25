package com.example.zhou8;

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

public class Denglu extends Activity {

	private Button dl;
	private EditText dl_mm;
	private EditText dl_zh;
	private CheckBox jzmm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_denglu);
		
		dl = (Button) findViewById(R.id.dl_dl);
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
		
		dl.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
				Editor edit = sp.edit();
				boolean checked = jzmm.isChecked();
				if(checked){
					String user = dl_zh.getText().toString();
					String psw = dl_mm.getText().toString();
					
					edit.putString("z", user);
					edit.putString("m", psw);
					
					if(user.matches("[a-zA-Z]{5,8}")&&psw.matches("[0-9]{6,8}")){
						startActivity(new Intent(Denglu.this,CActivity.class));
					}else {
						Toast.makeText(Denglu.this, "账号或密码不符合规定", Toast.LENGTH_SHORT).show();
					}
					
				}
				edit.putBoolean("issave", checked);
				edit.commit();
			}
		});
		
	}
}
