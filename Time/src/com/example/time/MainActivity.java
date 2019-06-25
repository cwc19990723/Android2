package com.example.time;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private int count = 5;
	
	Handler hand = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==1){
				tv.setText(count--+"");
				if(count<0){
					startActivity(new Intent(MainActivity.this,PagerActivity.class));
					finish();
				}else {
					hand.sendEmptyMessageDelayed(1, 1000);
				}
			}
		};
	};

	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.tm_tv);
		hand.sendEmptyMessageDelayed(1, 1000);
		
	}
}
