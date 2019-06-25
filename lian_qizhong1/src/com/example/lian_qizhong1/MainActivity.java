package com.example.lian_qizhong1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private EditText dl_yhm;
	private Button dl;
	private Button zc;
	private EditText dl_mm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dl = (Button) findViewById(R.id.dl_dl);
		zc = (Button) findViewById(R.id.dl_zc);
		dl_yhm = (EditText) findViewById(R.id.dl_yhm);
		dl_mm = (EditText) findViewById(R.id.dl_mm);
		
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
			Intent in = new Intent(MainActivity.this,Zhuce.class);
			startActivityForResult(in, 100);
			break;

		default:
			break;
		}
	}

	private void denglu() {
		String yhm = dl_yhm.getText().toString();
		String mm = dl_mm.getText().toString();
		
		if(!yhm.isEmpty()&&!mm.isEmpty()){
			Toast.makeText(MainActivity.this, "键盘敲烂,月薪过万", Toast.LENGTH_SHORT).show();
		}else {
			Toast.makeText(MainActivity.this, "账号或者密码不能为空", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==100&&resultCode==200){
			String user = data.getStringExtra("zh");
			String psw = data.getStringExtra("mm");
			
			dl_yhm.setText(user);
			dl_mm.setText(psw);
		}
		
	}
	
}
