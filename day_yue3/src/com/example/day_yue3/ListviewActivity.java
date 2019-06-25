package com.example.day_yue3;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import bean.User;
import bean.forecast;

public class ListviewActivity extends Activity {

	private ListView lv;
	private ArrayList<forecast> list;
	private MyAdapter adapter;
	
	Handler hand = new Handler(){

		public void handleMessage(android.os.Message msg) {
			list = (ArrayList<forecast>) msg.obj;
			adapter = new MyAdapter(ListviewActivity.this, list);
			lv.setAdapter(adapter);
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		
		lv = (ListView) findViewById(R.id.lv_lv);
		
		new Thread(){
			public void run() {
				try {
					URL url = new URL("http://192.168.1.52:8080/xml/test.txt");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					int responseCode = con.getResponseCode();
					if(responseCode==200){
						InputStream in = con.getInputStream();
						StringBuffer sb = new StringBuffer();
						byte [] by = new byte [1024];
						int a = 0;
						while ((a=in.read(by))!=-1) {
							sb.append(new String(by,0,a));
						}
						Log.i("msg", "msg"+sb.toString());
						
						User user = JSON.parseObject(sb.toString(),User.class);
						List<forecast> forecast = user.getForecast();
						
						Message msg = new Message();
						msg.obj = forecast;
						
						hand.sendMessage(msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
	}
}
