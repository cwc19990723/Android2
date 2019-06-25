package com.example.day_yue6;

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
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ListviewActivity extends Activity implements OnClickListener, OnItemLongClickListener, OnItemClickListener {

	private Button add;
	private ListView lv;
	private int index = 0;
	private ArrayList<User> list;
	private MyAdapter adapter;
	
	Handler hand = new Handler(){

		public void handleMessage(android.os.Message msg) {
			list = (ArrayList<User>) msg.obj;
			ArrayList<User> users = list;
			adapter = new MyAdapter(ListviewActivity.this, list);
			lv.setAdapter(adapter);
		};   
	};
	private AlertDialog create;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		
		add = (Button) findViewById(R.id.lv_add);
		lv = (ListView) findViewById(R.id.lv_lv);
		
		new Thread(){
			public void run() {
				try {
					URL url = new URL("http://192.168.1.52:8080/test1/jiexi.txt");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					int responseCode = con.getResponseCode();
					if(responseCode==200){
						InputStream in = con.getInputStream();
						StringBuffer sb = new StringBuffer();
						byte [] by = new byte [1024];
						int a =0;
						while ((a=in.read(by))!=-1) {
							sb.append(new String(by,0,a,"gbk"));
						}
						
						Log.i("msg", "msg"+sb.toString());
						/*User aa = JSON.parseObject(sb.toString(),User.class);*/
						Gson gson = new Gson();
						ArrayList<User> user = gson.fromJson(sb.toString(), new TypeToken<ArrayList<User>>(){}.getType());
						Log.i("tag", "tag"+user.toString());
						Message msg = new Message();
						msg.obj = user;
						
						hand.sendMessage(msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
		
		add.setOnClickListener(this);//添加条目
		lv.setOnItemLongClickListener(this);//删除条目
		lv.setOnItemClickListener(this);//修改条目
		//弹窗
		create = new AlertDialog.Builder(this).setTitle("是否删除")
		.setPositiveButton("确认", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				list.remove(index);
				  
				adapter.notifyDataSetChanged();
			}
		})
		.setNegativeButton("取消", null).create();
	}
	
	//添加
	@Override
	public void onClick(View v) {
		
		
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
		
	}
	
	
	
}
