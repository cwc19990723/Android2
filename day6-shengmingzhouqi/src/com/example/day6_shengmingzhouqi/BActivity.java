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
		
		Log.i("Main", "-----onCreate:Bҳ�洴��");
		b_btcloss = (TextView) findViewById(R.id.b_btcloss);
		
		b_btcloss.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
	}
	
	//��ʼ
	@Override
	protected void onStart() {
		super.onStart();
		Log.i("Main", "-----onStart:Bҳ�濪ʼ");
	}
	//����
	@Override
	protected void onResume() {
		super.onResume();
		Log.i("Main", "-----onResume:Bҳ����ӻ�");
	}
	
	//��ͣ
	@Override
	protected void onPause() {
		super.onPause();
		Log.i("Main", "-----onPause:Bҳ����ͣ");
	}
	
	//ֹͣ
	@Override
	protected void onStop() {
		super.onStop();
		Log.i("Main", "-----onStop:Bҳ��ֹͣ");
	}
	
	//����
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Main", "-----onDestroy:Bҳ������");
	}
	
	//����
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i("Main", "-----onRestart:Bҳ������");
	}
	
}
