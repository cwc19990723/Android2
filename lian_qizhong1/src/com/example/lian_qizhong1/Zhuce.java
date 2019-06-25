package com.example.lian_qizhong1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Zhuce extends Activity {

	private EditText zc_yhm;
	private EditText zc_mm;
	private RadioButton zc_nan;
	private RadioButton zc_nv;
	private CheckBox zc_ymq;
	private CheckBox zc_yy;
	private CheckBox zc_lq;
	private Button zc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhuce);
		
		zc_yhm = (EditText) findViewById(R.id.zc_yhm);
		zc_mm = (EditText) findViewById(R.id.zc_mm);
		zc_nan = (RadioButton) findViewById(R.id.zc_nan);
		zc_nv = (RadioButton) findViewById(R.id.zc_nv);
		zc_ymq = (CheckBox) findViewById(R.id.zc_yumaoqiu);
		zc_yy = (CheckBox) findViewById(R.id.zc_youyong);
		zc_lq = (CheckBox) findViewById(R.id.zc_lanqiu);
		zc = (Button) findViewById(R.id.zc_zc);
		
		zc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in = new Intent();
				String nan = zc_nan.getText().toString();
				String nv = zc_nv.getText().toString();
				if(zc_nan.isChecked()){
					zc_yhm.setText(nan);
				}else {
					zc_yhm.setText(nv);
				}
				
				String user = zc_yhm.getText().toString();
				String psw = zc_mm.getText().toString();
				
				if(!user.isEmpty()&&!psw.isEmpty()){
					in.putExtra("zh", user);
					in.putExtra("mm", psw);
					setResult(200,in);
					finish();
				}else {
			 		Toast.makeText(Zhuce.this, "账号或者密码不能为空", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
