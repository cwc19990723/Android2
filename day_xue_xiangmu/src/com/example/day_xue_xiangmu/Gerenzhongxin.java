package com.example.day_xue_xiangmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

public class Gerenzhongxin extends Activity implements OnClickListener {

	private TextView zhongxin_zh;
	private TextView zhongxin_name;
	private TextView zhongxin_sex;
	private TextView zhongxin_shengri;
	private TextView zhongxin_dengji;
	private TextView zhongxin_ziliao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gerenzhongxin);
		
		zhongxin_zh = (TextView) findViewById(R.id.zhongxin_zh);
		zhongxin_name = (TextView) findViewById(R.id.zhongxin_name);
		zhongxin_sex = (TextView) findViewById(R.id.zhongxin_sex);
		zhongxin_shengri = (TextView) findViewById(R.id.zhongxin_shengri);
		zhongxin_dengji = (TextView) findViewById(R.id.zhongxin_dengji);
		zhongxin_ziliao = (TextView) findViewById(R.id.zhongxin_ziliao);
		
		zhongxin_zh.setOnClickListener(this);
		zhongxin_name.setOnClickListener(this);
		zhongxin_sex.setOnClickListener(this);
		zhongxin_shengri.setOnClickListener(this);
		zhongxin_dengji.setOnClickListener(this);
		zhongxin_ziliao.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.zhongxin_zh:
			Intent in = new Intent(Gerenzhongxin.this,Xiugaiziliao.class);
			startActivityForResult(in, 100);
			break;
		case R.id.zhongxin_ziliao:
			startActivity(new Intent(Gerenzhongxin.this,Xiugaiziliao.class));
			break;
			
		default:
			break;
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==100&&resultCode==200){
			String name = data.getStringExtra("name");
			/*String nan = data.getStringExtra("nan");
			String nv = data.getStringExtra("nv");*/
			String shengri = data.getStringExtra("shengri");
			/*String dengji = data.getStringExtra("dengji");*/
			
			View view = LayoutInflater.from(Gerenzhongxin.this).inflate(R.layout.activity_xiugaiziliao, null);
			
			RadioButton ziliao_nan = (RadioButton) view.findViewById(R.id.ziliao_nan);
			RadioButton ziliao_nv = (RadioButton) view.findViewById(R.id.ziliao_nv);
			RatingBar ziliao_rb = (RatingBar) view.findViewById(R.id.ziliao_rb);
			
			String nan = ziliao_nan.getText().toString();
			String nv = ziliao_nv.getText().toString();
			int den = ziliao_rb.getTextAlignment();
			String dengji = String.valueOf(den);
			
			zhongxin_name.setText(name);
			zhongxin_sex.setText(nan);
			zhongxin_sex.setText(nv);
			zhongxin_shengri.setText(shengri);
			zhongxin_dengji.setText(dengji);
		}
	}
	
}
