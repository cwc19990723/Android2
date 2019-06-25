package com.example.yue_4;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	String s [] = {"一","二","三","四","五"};
	
	int i = 4;
	
	private TextView tv;
	
	Handler hand = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(i>0){
				i--;
				tv.setText(s[i]);
			}else {
				//结束任务
				timer.cancel();
				//转跳到下一个界面
				startActivity(new Intent(MainActivity.this,BActivity.class));
			}
		};
	};



	private Timer timer;	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.a_tv);
		
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				hand.sendEmptyMessage(1);
			}
		};
		
		timer = new Timer();
		
		timer.schedule(timerTask, 1000,1000);
	}
}
