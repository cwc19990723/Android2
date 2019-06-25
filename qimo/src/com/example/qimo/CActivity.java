package com.example.qimo;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class CActivity extends Activity {
	
	Handler hand = new Handler(){
		public void handleMessage(android.os.Message msg) {
			ArrayList<datas> list = (ArrayList<datas>) msg.obj;
			MyAdapter adapter = new MyAdapter(list, CActivity.this);
			lv.setAdapter(adapter);
		};
	};
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_c);
		
		lv = (ListView) findViewById(R.id.lv);
		
		new Thread(){
			public void run() {
				try {
					URL url = new URL("http://www.wanandroid.com/article/list/0/json");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					int code = con.getResponseCode();
					if(code==200){
						InputStream in = con.getInputStream();
						StringBuffer sb = new StringBuffer();
						byte [] by = new byte [1024];
						int a =0;
						while ((a=in.read(by))!=-1) {
							sb.append(new String(by,0,a));
						}
						
						Log.i("msg", sb.toString());
						
						Gson gson = new Gson();
						User user = gson.fromJson(sb.toString(), User.class);
						data data = user.getData();
						List<datas> list = data.getDatas();
						
						Log.i("ccc", list.toString());
						
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
