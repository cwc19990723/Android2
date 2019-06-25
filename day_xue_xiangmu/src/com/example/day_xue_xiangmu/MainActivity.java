package com.example.day_xue_xiangmu;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
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
			}else {
				timerTask.cancel();
			}
		};
	};

	private TimerTask timerTask;

	private Timer timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.a_tv);
		
		
		timerTask = new TimerTask() {
			
			@Override
			public void run() {
				
				timerTask.cancel();
				
			}
		};
		
		timer = new Timer();
		timer.schedule(timerTask, 1000,1000);
	}
}
