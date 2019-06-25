package com.example.day6_shengmingzhouqi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private TextView a_te;
	//����
	@Override	    //��д
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("Main", "=====onCreate:����");
		a_te = (TextView) findViewById(R.id.a_te);
		
		a_te.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.a_te:
			te();
			break;

		default:
			break;
		}
	}

	private void te() {
		startActivity(new Intent(MainActivity.this,BActivity.class));
	}
	//��ʼ
	@Override
	protected void onStart() {
		super.onStart();
		Log.i("Main", "=====onStart:��ʼ");
	}
	
	//��ý���
	@Override
	protected void onResume() {
		super.onResume();
		Log.i("Main", "=====onResume:����");
	}
	
	//��ͣ
	@Override
	protected void onPause() {
		super.onPause();
		Log.i("Main", "=====onPause:��ͣ");
	}
	
	//ֹͣ
	@Override
	protected void onStop() {
		super.onStop();
		Log.i("Main", "=====onStop:ֹͣ");
	}
	
	//����
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Main", "=====onDestroy:����");
	}
	
	//��������
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i("Main", "=====onRestart:��������");
	}
}
