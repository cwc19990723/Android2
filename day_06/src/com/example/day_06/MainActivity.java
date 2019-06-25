package com.example.day_06;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	//开始
	@Override
	protected void onStart() {
		super.onStart();
	}
	
	//获得焦点
	@Override
	protected void onRestart() {
		super.onRestart();
	}
	
	//暂停
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	//重新运行
	
	
	//停止
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	//销毁
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	
}
