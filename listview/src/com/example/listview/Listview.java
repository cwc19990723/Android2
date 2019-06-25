package com.example.listview;

import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.MainThread;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;

public class Listview extends Activity implements OnClickListener, OnItemLongClickListener, OnItemClickListener {
	
	private ArrayList<User> list;
	private MyAdapter adapter;
	private int index = 0;
	
	Handler hand = new Handler(){

		public void handleMessage(android.os.Message msg) {
			list = (ArrayList<User>) msg.obj;
			adapter = new MyAdapter(list, Listview.this);
			lv.setAdapter(adapter);
		};
	};

	private ListView lv;
	private Button add;
	private AlertDialog create;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		
		add = (Button) findViewById(R.id.lv_add);
		lv = (ListView) findViewById(R.id.lv_lv);
		
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
						
						Log.i("msg", sb.toString());
						
						Gson gson = new Gson();
						ArrayList<User> list = gson.fromJson(sb.toString(),new TypeToken<ArrayList<User>>(){}.getType());
						
						Message msg = new Message();
						msg.obj=list;
						hand.sendMessage(msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
		
		create = new AlertDialog.Builder(Listview.this).setTitle("是否删除")
		.setPositiveButton("确认", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				  
				list.remove(index);
				
				adapter.notifyDataSetChanged();
				
			}
		})
		.setNegativeButton("取消", null)
		.create();
		
		add.setOnClickListener(this);
		lv.setOnItemLongClickListener(this);
		lv.setOnItemClickListener(this);
		
	}
	//添加
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.lv_add:
			Intent in = new Intent(Listview.this,Add.class);
			startActivityForResult(in, 100);
			break;

		default:
			break;
		}
	}
	//删除
	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		
		index = position;
		
		create.show();
		
		return true;
	}
	//修改
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		index = position;
		
		User user = list.get(position);
		Intent in = new Intent(Listview.this,Update.class);
		in.putExtra("up", user);
		startActivityForResult(in, 300);
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//添加
		if(requestCode==100&&resultCode==200){
			User user = (User) data.getSerializableExtra("add");
			
			list.add(user);
			adapter.notifyDataSetChanged();
		}
		//修改
		if(requestCode==300&&resultCode==400){
			User user = (User) data.getSerializableExtra("context");
			
			list.set(index, user);
			
		}
		adapter.notifyDataSetChanged();
	}
	
}
