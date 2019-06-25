package com.example.yue_4;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import bean.User;
import bean.data;

public class BActivity extends Activity {

	private ListView lv;
	private Button tianjia;
	private TextView zhuan;
	private ArrayList<data> list;
	private MyAdapter adapter;
	
	Handler hand = new Handler(){

		//接受下面发送的数据
		public void handleMessage(android.os.Message msg) {
			list = (ArrayList<data>) msg.obj;
			
			MySql mySql = new MySql(BActivity.this, "my.db", null, 1);
			SQLiteDatabase db = mySql.getWritableDatabase();
			
			ContentValues values = new ContentValues();
			
			values.put("content",list.get(0).getContent());
			
			db.insert("user", null, values);
			db.close();
			
		//找到适配器
			adapter = new MyAdapter(BActivity.this,list);
		//绑定适配器
			lv.setAdapter(adapter);
		
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		lv                                                                                                                                                                             = (ListView) findViewById(R.id.b_lv);
		tianjia = (Button) findViewById(R.id.b_tianjia);
		zhuan = (TextView) findViewById(R.id.b_zhuan);
		
		tianjia.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MySql sql = new MySql(BActivity.this, "my.db", null, 1);
				SQLiteDatabase db = sql.getWritableDatabase();
				
			}
		});
		
		zhuan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(BActivity.this,AddActivity.class);
				startActivityForResult(intent, 100);			}
		});
		
		new Thread(){
			public void run() {
				try {
					URL url = new URL("http://192.168.1.52:8080/xml/s.txt");
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
						Log.i("tag", ""+sb.toString());
						
						Gson gson = new Gson();
						User fromJson = gson.fromJson(sb.toString(), User.class);
						list = (ArrayList<data>) fromJson.getResult().getData();
						
						//将数据发送给上面
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
	//
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==100&&resultCode==200){
			String context = data.getStringExtra("context");
			list.add(new data(context, "2", 3, "4"));
			adapter.notifyDataSetChanged();
		}
	}
	
}
