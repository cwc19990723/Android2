package com.example.jiexi1;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class BActivity extends Activity implements OnItemClickListener {
	
	Handler hand = new Handler(){
		

		public void handleMessage(android.os.Message msg) {
			list = (ArrayList<User>) msg.obj;
			MyAdapter adapter = new MyAdapter(list, BActivity.this);
			lv.setAdapter(adapter);
		};
	};

	private ListView lv;
	private ArrayList<User> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		lv = (ListView) findViewById(R.id.b_lv);
		
		lv.setOnItemClickListener(this);
		
		new Thread(){
			public void run() {
				try {
					URL url = new URL("http://192.168.1.52:8080/test1/json.txt");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					int code = con.getResponseCode();
					if(code==200){
						InputStream in = con.getInputStream();
						StringBuffer sb = new StringBuffer();
						byte [] by = new byte[1024];
						int a = 0;
						while ((a=in.read(by))!=-1) {
							sb.append(new String(by,0,a,"gbk"));
						}
						
						Gson gson = new Gson();
						ArrayList<User> list = gson.fromJson(sb.toString(), new TypeToken<ArrayList<User>>(){}.getType());
						
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

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		//startActivity(new Intent(BActivity.this,CActivity.class));
		
		Intent in = new Intent();
		in.putExtra("count", list);
		startActivity(in);
		
	}
}
