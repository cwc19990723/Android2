package com.example.lianxi2;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;

public class BActivity extends Activity implements OnItemClickListener {
	
	Handler hand = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==100){
				adapter.notifyDataSetChanged();
			}
		};
	};

	private ArrayList<User> list;
	private MyAdapter adapter;
	private int index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		//插入10条数据
		MySql sql = new MySql(BActivity.this);
		for (int i = 0; i < 10; i++) {
			sql.insert(new User("http://www.wanandroid.com/resources/image/pc/default_project_img.jpg", "xun彭涛傻吊"));
		}
		initView();
	}
	
	private void initView() {
		GridView lv = (GridView) findViewById(R.id.lv);
		
		list = new ArrayList<User>();
		adapter = new MyAdapter(list, BActivity.this);
		lv.setAdapter(adapter);
		
		initData();
		
		lv.setOnItemClickListener(this);
	}
	//查询
	private void initData() {
		ArrayList<User> list2 = new MySql(BActivity.this).select();
		list.addAll(list2);
		adapter.notifyDataSetChanged();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		index= position;
		User user = list.get(position);
		Intent in = new Intent(BActivity.this,Update.class);
		in.putExtra("count", user);
		setResult(100, in);
		startActivity(in);
	}
	
	//回传接收数据
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==100&&resultCode==200){
			User user = (User) data.getSerializableExtra("context");
			String image = user.getImage();
			new MySql(BActivity.this).update(image, user);
			list.add(index, user);
			adapter.notifyDataSetChanged();
		}
	}
	
}
