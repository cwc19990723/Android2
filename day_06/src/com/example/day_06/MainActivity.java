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
	
	//��ʼ
	@Override
	protected void onStart() {
		super.onStart();
	}
	
	//��ý���
	@Override
	protected void onRestart() {
		super.onRestart();
	}
	
	//��ͣ
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	//��������
	
	
	//ֹͣ
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	//����
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	
}
