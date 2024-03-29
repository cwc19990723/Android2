package com.example.time;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class LActivity extends Activity {
	
	Handler hand = new Handler(){
		public void handleMessage(android.os.Message msg) {
			ArrayList<datas> list = (ArrayList<datas>) msg.obj;
			MyAdapter adapter = new MyAdapter(list, LActivity.this);
			lv.setAdapter(adapter);
		};
	};

	private ListView lv;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_l);
		
		lv = (ListView) findViewById(R.id.lv_lv);
		tv = (TextView) findViewById(R.id.lv_tv);
		
		Intent in = getIntent();
		String user = in.getStringExtra("s");
		tv.setText("��ӭ"+user);
		
		new Thread(){
			public void run() {
				try {
					URL url = new URL("http://www.wanandroid.com/article/list/1/json");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					int code = con.getResponseCode();
					if(code==200){
						InputStream in = con.getInputStream();
						StringBuffer sb = new StringBuffer();
						byte [] by = new byte [1024];
						int a = 0;
						while ((a=in.read(by))!=-1) {
							sb.append(new String(by,0,a));
						}
						
						Gson gson = new Gson();
						Cwc cwc = gson.fromJson(sb.toString(), Cwc.class);
						data data = cwc.getData();
						List<datas> list = data.getDatas();
						
						Message msg = new Message();
						msg.obj = list;
						hand.sendMessage(msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
		
		
		
	}
}
