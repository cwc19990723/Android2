package com.example.day6_shengmingzhouqi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class BActivity extends Activity implements OnClickListener {

	private TextView b_btcloss;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		Log.i("Main", "-----onCreate:B页面创造");
		b_btcloss = (TextView) findViewById(R.id.b_btcloss);
		
		b_btcloss.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
	}
	
	//开始
	@Override
	protected void onStart() {
		super.onStart();
		Log.i("Main", "-----onStart:B页面开始");
	}
	//可视
	@Override
	protected void onResume() {
		super.onResume();
		Log.i("Main", "-----onResume:B页面可视化");
	}
	
	//暂停
	@Override
	protected void onPause() {
		super.onPause();
		Log.i("Main", "-----onPause:B页面暂停");
	}
	
	//停止
	@Override
	protected void onStop() {
		super.onStop();
		Log.i("Main", "-----onStop:B页面停止");
	}
	
	//销毁
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Main", "-----onDestroy:B页面销毁");
	}
	
	//重启
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i("Main", "-----onRestart:B页面重启");
	}
	
}
