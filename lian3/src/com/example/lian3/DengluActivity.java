package com.example.lian3;

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

public class DengluActivity extends Activity implements OnClickListener {

	private Button dl;
	private EditText dl_yhm;
	private Button zc;
	private EditText dl_mm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_denglu);
		
		dl_yhm = (EditText) findViewById(R.id.dl_yhm);
		dl_mm = (EditText) findViewById(R.id.dl_mm);
		dl = (Button) findViewById(R.id.dl_dl);
		zc = (Button) findViewById(R.id.dl_zc);
		
		zc.setOnClickListener(this);
		dl.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dl_zc:
			Intent in = new Intent(DengluActivity.this,ZhuceActivity.class);
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
		
		Toast.makeText(DengluActivity.this, "µÇÂ½³É¹¦", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==100&&resultCode==200){
			String user = data.getStringExtra("yhm");
			String psw = data.getStringExtra("mm");
			
			dl_yhm.setText(user);
			dl_mm.setText(psw);
			
		}
		
	}
	
}
