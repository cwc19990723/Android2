package com.example.zhou6;

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
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

public class CActivity extends Activity implements OnItemLongClickListener {
	
	Handler hand = new Handler(){

		public void handleMessage(android.os.Message msg) {
			list = (ArrayList<User>) msg.obj;
			adapter = new MyAdapter(list, CActivity.this);
			lv.setAdapter(adapter);
		};
	};

	private ListView lv;
	private int index = 0;
	private ArrayList<User> list;
	private MyAdapter adapter;

	private AlertDialog create;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_c);
		
		lv = (ListView) findViewById(R.id.lv);
		
		lv.setOnItemLongClickListener(this);
		
		new Thread(){
			public void run() {
				try {
					URL url = new URL("http://192.168.1.52:8080/test1/jiexi.txt");
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
						
						//ArrayList<User> user = JSON.parseObject(sb.toString(),new TypeToken<ArrayList<User>>(){}.getType());
						
						Message msg = new Message();
						msg.obj = list;
						
						hand.sendMessage(msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
		
		create = new AlertDialog.Builder(CActivity.this).setTitle("是否删除")
		.setPositiveButton("确认", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				list.remove(index);
				adapter.notifyDataSetChanged();
			}
		})
		.setNegativeButton("取消", null)
		.create();
		
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		
		index = position;
		create.show();
		
		return true;
	}
}
