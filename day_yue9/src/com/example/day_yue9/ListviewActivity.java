package com.example.day_yue9;

import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

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
import android.widget.Button;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import bean.User;
import bean.lol;

public class ListviewActivity extends Activity implements OnItemClickListener, OnItemLongClickListener, OnClickListener {

	private ListView lv;
	private int index = 0;
	private ArrayList<lol> list;
	private MyAdapter adapter;
	
	Handler hand = new Handler(){

		public void handleMessage(android.os.Message msg) {
			list = (ArrayList<lol>) msg.obj;
			adapter = new MyAdapter(ListviewActivity.this, list);
			lv.setAdapter(adapter);
		};
	};
	private AlertDialog create;
	private Button add;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		
		lv = (ListView) findViewById(R.id.lv_lv);
		add = (Button) findViewById(R.id.lv_add);
		
		lv.setOnItemClickListener(this);
		lv.setOnItemLongClickListener(this);
		add.setOnClickListener(this);
		
		new Thread(){
			public void run() {
				try {   
					URL url = new URL("http://192.168.1.52:8080/xml/test.txt");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					int responseCode = con.getResponseCode();
					if(responseCode==200){
						InputStream in = con.getInputStream();
						StringBuffer sb = new StringBuffer();
						byte [] by = new byte[1024];
						int a = 0;
						while ((a=in.read(by))!=-1) {
							sb.append(new String(by,0,a,"gbk"));
						}
						Log.i("msg", "msg"+sb.toString());
						
						User user = JSON.parseObject(sb.toString(),User.class);
						List<lol> lol = user.getLol();
						
						Message msg = new Message();
						msg.obj = lol;
						
						hand.sendMessage(msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
		
		create = new AlertDialog.Builder(this).setTitle("�Ƿ�ɾ��")
		.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				list.remove(index);
				
				adapter.notifyDataSetChanged();
				
			}
		})
		.setNegativeButton("ȡ��", null).create();
		
	}
	//�޸�
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		index = position;
		
		lol lol = list.get(position);
		Intent in = new Intent(ListviewActivity.this,UpdateActivity.class);
		in.putExtra("up", lol);
		startActivityForResult(in, 300);
		
	}
	//ɾ��
	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		
		index = position;
		
		create.show();
		
		return true;
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.lv_add:
			Intent in = new Intent(ListviewActivity.this,AddActivity.class);
			startActivityForResult(in, 100);
			break;

		default:
			break;
		}
	}
	
	//���ջش�������
		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			super.onActivityResult(requestCode, resultCode, data);
			
			//���
			if(requestCode==100&&resultCode==200){
				lol lol = (bean.lol) data.getSerializableExtra("add");
				
				list.add(lol);
				adapter.notifyDataSetChanged();
			}
			
			//�޸�
			if(requestCode==300&&resultCode==400){
				
				lol lol = (bean.lol) data.getSerializableExtra("context");
				
				list.set(index, lol);
			}
			adapter.notifyDataSetChanged();
		}
	
}
