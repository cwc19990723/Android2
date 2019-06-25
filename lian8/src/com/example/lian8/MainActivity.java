package com.example.lian8;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	Handler hand = new Handler(){
		public void handleMessage(Message msg) {
			if(msg.what==10){
				ed.setText(msg.obj.toString());
			}else if (msg.what==12) {
				ed.setText("xun彭涛最沙雕");
			}
		};
	};

	private Button bt;
	private EditText ed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt = (Button) findViewById(R.id.a_bt);
		ed = (EditText) findViewById(R.id.a_ed);
		
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new Thread(){
					public void run() {
						try {
							sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Message msg = new Message();
						msg.obj = "沙雕xun彭涛";
						msg.what = 10;
						hand.sendMessage(msg);
					};
				}.start();
				
				//第二个子线程
				
				new Thread(){
					public void run() {
						try {
							sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						hand.sendEmptyMessage(12);
					};
				}.start();
			}
		});
	}
}
