package com.example.day_xiangmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class DActivity extends Activity implements OnClickListener {

	private ImageButton d_imtu;
	private TextView d_geren;
	private TextView d_yaoyiyao;
	private TextView d_tiaobeijing;
	private TextView d_ruanjian;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_d);
		d_geren = (TextView) findViewById(R.id.d_geren);
		d_imtu = (ImageButton) findViewById(R.id.d_imtu);
		d_yaoyiyao = (TextView) findViewById(R.id.d_yaoyiyao);
		d_tiaobeijing = (TextView) findViewById(R.id.d_tiaobeijing);
		d_ruanjian = (TextView) findViewById(R.id.d_ruanjian);
		
		d_geren.setOnClickListener(this);
		d_imtu.setOnClickListener(this);
		d_yaoyiyao.setOnClickListener(this);
		d_tiaobeijing.setOnClickListener(this);
		d_ruanjian.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.d_imtu:
			startActivity(new Intent(DActivity.this,GuanggaoActivity.class));
			break;
		case R.id.d_geren:
			startActivity(new Intent(DActivity.this,EActivity.class));
			break;
		case R.id.d_yaoyiyao:
			startActivity(new Intent(DActivity.this,YaoyiyaoActivity.class));
			break;
		case R.id.d_tiaobeijing:
			startActivity(new Intent(DActivity.this,TiaobeijingActivity.class));
			break;
		case R.id.d_ruanjian:
			startActivity(new Intent(DActivity.this,RuanjianshiyongActivity.class));
			break;

		default:
			break;
		}
	}
}
