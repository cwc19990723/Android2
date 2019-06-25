package com.example.zhou1;

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
import bean.User;
import bean.data;
import bean.result;

public class BActivity extends Activity {
	
	Handler hand = new Handler(){
		private ArrayList<data> list;
		private MyAdapter adapter;

		public void handleMessage(android.os.Message msg) {
			list = (ArrayList<data>) msg.obj;
			adapter = new MyAdapter(list, BActivity.this);
			lv.setAdapter(adapter);
		};
	};

	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		lv = (ListView) findViewById(R.id.lv);
		
		new Thread(){
			public void run() {
				try {
					URL url = new URL("http://v.juhe.cn/toutiao/index?type=guoji&key=4c4826357bfa9a983038c2a61071f1a5");
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
						
						Log.i("msg", "msg"+sb.toString());
						
						Gson gson = new Gson();
						User user = gson.fromJson(sb.toString(), User.class);
						result result = user.getResult();
						List<data> list = result.getData();
						
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
