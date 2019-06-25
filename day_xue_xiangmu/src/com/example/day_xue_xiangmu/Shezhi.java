package com.example.day_xue_xiangmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Shezhi extends Activity implements OnClickListener {

	private TextView beijing;
	private TextView geren;
	private TextView yaoyiyao;
	private TextView shezhi_shoucang;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shezhi);
		
		beijing = (TextView) findViewById(R.id.shezhi_beijing);
		geren = (TextView) findViewById(R.id.shezhi_geren);
		yaoyiyao = (TextView) findViewById(R.id.shezhi_yaoyiyao);
		shezhi_shoucang = (TextView) findViewById(R.id.shezhi_shoucang);
		
		beijing.setOnClickListener(this);
		geren.setOnClickListener(this);
		yaoyiyao.setOnClickListener(this);
		shezhi_shoucang.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.shezhi_beijing:
			startActivity(new Intent(Shezhi.this,Tiaojiebeijing.class));
			break;
		case R.id.shezhi_geren:
			startActivity(new Intent(Shezhi.this,Gerenzhongxin.class));
			break;
		case R.id.shezhi_yaoyiyao:
			startActivity(new Intent(Shezhi.this,Yaoyiyao.class));
			break;
		case R.id.shezhi_shoucang:
			startActivity(new Intent(Shezhi.this,Shoucang.class));
			break;

		default:
			break;
		}
	}
}
