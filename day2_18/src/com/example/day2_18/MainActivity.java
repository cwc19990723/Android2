package com.example.day2_18;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

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
			ArrayList<data> list = (ArrayList<data>) msg.obj;
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
			public void run() {			//http://192.168.1.52:8080/test1/a.txt
				try {					
					URL url = new URL("http://v.juhe.cn/toutiao/index?type=guoji&key=4c4826357bfa9a983038c2a61071f1a5");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					int responseCode = con.getResponseCode();
					if(responseCode==200){
						InputStream in = con.getInputStream();
						StringBuffer sb = new StringBuffer();
						byte [] by = new byte [1024];
						int a = 0;
						while ((a=in.read(by))!=-1) {
							sb.append(new String(by,0,a,"utf-8"));
						}
						
						Log.i("msg", "msg"+sb.toString());
						
						Gson gson = new Gson();
						User user = gson.fromJson(sb.toString(), User.class);
						result result = user.getResult();
						List<data> list = result.getData();
						  
						Log.i("ccc", "ccc"+list.toString());
						     
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
