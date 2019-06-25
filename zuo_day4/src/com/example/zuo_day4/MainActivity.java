package com.example.zuo_day4;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	Handler hand = new Handler(){
		public void handleMessage(android.os.Message msg) {
			ArrayList<User> list = (ArrayList<User>) msg.obj;
			MyAdapter adapter = new MyAdapter(list, MainActivity.this);
			lv.setAdapter(adapter);
		};
	};

	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv = (ListView) findViewById(R.id.lv_lv);
		
		new Thread(){
			public void run() {
				try {
					URL url = new URL("http://192.168.1.52:8080/text1/javaweb.txt");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					int responseCode = con.getResponseCode();
					if(responseCode==200){
						InputStream in = con.getInputStream();
						StringBuffer sb = new StringBuffer();
						byte [] by = new byte [1024];
						int a =0;
						while ((a=in.read(by))!=-1) {
							sb.append(new String(by,0,a));
						}
						
						Log.i("msg", "msg"+sb.toString());
						
						Gson gson = new Gson();
						ArrayList<User> user = gson.fromJson(sb.toString(),new TypeToken<ArrayList<User>>(){}.getType());
						
						Log.i("ccc", "ccc"+user.toString());
						
						Message msg = new Message();
						msg.obj = user;
						hand.sendMessage(msg);
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
	}
}
