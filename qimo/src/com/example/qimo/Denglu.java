package com.example.qimo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Denglu extends Activity implements OnClickListener {
	
	//1809a��ΰ����a������

	private EditText dl_zh;
	private EditText dl_mm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_denglu);
		
		dl_zh = (EditText) findViewById(R.id.dl_zh);
		dl_mm = (EditText) findViewById(R.id.dl_mm);
		Button dl = (Button) findViewById(R.id.dl_dl);
		TextView zc = (TextView) findViewById(R.id.dl_zc);
		
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
		String user = dl_zh.getText().toString();
		String psw = dl_mm.getText().toString();
		if(!user.isEmpty()&&!psw.isEmpty()){
			if(user.matches("[0-9]{6,8}")&&psw.matches("[0-9a-zA-Z]{6,8}")){
				startActivity(new Intent(Denglu.this,CActivity.class));
			}else {
				Toast.makeText(Denglu.this, "�˺Ż����벻���Ϲ涨", Toast.LENGTH_SHORT).show();
			}
		}else {
			Toast.makeText(Denglu.this, "�˺Ż����벻��Ϊ��", Toast.LENGTH_SHORT).show();
		}
		
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
