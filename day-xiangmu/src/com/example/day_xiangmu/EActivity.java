package com.example.day_xiangmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class EActivity extends Activity implements OnClickListener {

	private Button e_ziliao;
	private TextView e_xiugai;
	private Button e_fanhui;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_e);
		
		e_ziliao = (Button) findViewById(R.id.e_ziliao);
		e_xiugai = (TextView) findViewById(R.id.e_xiugai);
		e_fanhui = (Button) findViewById(R.id.e_fanhui);
		
		
		e_ziliao.setOnClickListener(this);
		e_xiugai.setOnClickListener(this);
		e_fanhui.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.e_ziliao:
			ziliao();
			break;
		case R.id.e_xiugai:
			xiugai();
			break;
		case R.id.e_fanhui:
			fanhui();
			break;	

		default:
			break;
		}
	}

	private void fanhui() {
		startActivity(new Intent(EActivity.this,DActivity.class));
	}

	private void xiugai() {
		startActivity(new Intent(EActivity.this,FGaiActivity.class));
	}

	private void ziliao() {
		startActivity(new Intent(EActivity.this,FActivity.class));
		
	}
}
