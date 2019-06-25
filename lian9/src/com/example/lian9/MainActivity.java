package com.example.lian9;

import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener, OnItemLongClickListener, OnItemClickListener {
	
	private List<forecast> list;
	private MyAdapter adapter;
	
	Handler hand = new Handler(){

		@SuppressWarnings("unchecked")
		public void handleMessage(android.os.Message msg) {
			list = (List<forecast>) msg.obj;
			adapter = new MyAdapter(list, MainActivity.this);
			lv.setAdapter(adapter);
			/*if(11==msg.what){
				new Arraylist
			}*/
			
		};
	};

	private ListView lv;
	private int index = 0;
	private Button add;
	private AlertDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv = (ListView) findViewById(R.id.lv_lv);
		add = (Button) findViewById(R.id.lv_add);
		
		add.setOnClickListener(this);
		lv.setOnItemLongClickListener(this);
		lv.setOnItemClickListener(this);
		
		new Thread(){
			public void run() {
				try { 
					URL url = new URL("http://192.168.1.52:8080/text1/test.json");
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
						User user = gson.fromJson(sb.toString(), User.class);
						data data = user.getData();
						List<forecast> list = data.getForecast();
						
						Log.i("ccc", "ccc"+list.toString());
						
						Message msg = new Message();
						msg.obj = list;
						/*msg.what=11;
						msg.obj= list;*/
						hand.sendMessage(msg);
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
		
		dialog = new AlertDialog.Builder(MainActivity.this)
		.setTitle("是否删除")
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
	//添加
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.lv_add:
			Intent in = new Intent(MainActivity.this,Add.class);
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
		
		dialog.show();
		
		return true;
	}
	
	//修改
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		index = position;
		
		forecast forecast = list.get(position);
		Intent in = new Intent(MainActivity.this,Update.class);
		in.putExtra("up", forecast);
		startActivityForResult(in, 300);
		
	}
	
	//接收回传数据
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//添加
		if(requestCode==100&&resultCode==200){
			forecast forecast = (com.example.lian9.forecast) data.getSerializableExtra("add");
			list.add(forecast);
			adapter.notifyDataSetChanged();
		}
		//修改
		if(requestCode==300&&resultCode==400){
			
			forecast forecast = (com.example.lian9.forecast) data.getSerializableExtra("context");
			
			list.set(index, forecast);
		}
		adapter.notifyDataSetChanged();
	}
	
}
