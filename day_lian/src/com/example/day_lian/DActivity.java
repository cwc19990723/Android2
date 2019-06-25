package com.example.day_lian;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class DActivity extends Activity implements OnClickListener {

	private CheckBox lq;
	private CheckBox zq;
	private CheckBox ymq;
	private RadioButton nv;
	private RadioButton nan;
	private Button zc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_d);
		
		lq = (CheckBox) findViewById(R.id.d_lq);
		zq = (CheckBox) findViewById(R.id.d_zq);
		ymq = (CheckBox) findViewById(R.id.d_ymq);
		
		nv = (RadioButton) findViewById(R.id.id_nv);
		nan = (RadioButton) findViewById(R.id.id_nan);
		
		zc = (Button) findViewById(R.id.d_zc);
		
		nan.setOnClickListener(this);
		nv.setOnClickListener(this);
		ymq.setOnClickListener(this);
		zq.setOnClickListener(this);
		lq.setOnClickListener(this);
		zc.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String s = "";
		switch (v.getId()) {
		case R.id.d_zc:
			if(nan.isChecked()){
				Toast.makeText(DActivity.this, "男", Toast.LENGTH_SHORT).show();
			}else {
				Toast.makeText(DActivity.this, "女", Toast.LENGTH_SHORT).show();
			}
			if(lq.isChecked()&&zq.isChecked()&&ymq.isChecked()){
				Toast.makeText(DActivity.this, "爱好", Toast.LENGTH_SHORT).show();
			}
			zhuce();
			break;

		default:
			break;
		}
	}

	private void zhuce() {
		
		if(nv.isChecked()&&zq.isChecked()){
			Toast.makeText(DActivity.this, "性别女爱好足球", Toast.LENGTH_SHORT).show();
		}else {
			Toast.makeText(DActivity.this, "错误", Toast.LENGTH_SHORT).show();
		}
	}
}
