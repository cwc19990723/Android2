package com.example.lianxi1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class BActivity extends Activity implements OnItemClickListener {

	private GridView lv;
	private ArrayList<User> list;
	private MyAdapter adapter;
	private int index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		MySql sql = new MySql(BActivity.this);
		for (int i = 0; i<10; i++) {
			sql.insert(new User("http://192.168.1.52:8080/test1/t1.jpg", "xunÅíÌÎ"));
		}
		initView();
		
	}

	private void initView() {
		lv = (GridView) findViewById(R.id.lv);
		
		list = new ArrayList<User>();
		adapter = new MyAdapter(list, BActivity.this);
		lv.setAdapter(adapter);
		
		initData();
		
		lv.setOnItemClickListener(this);
	}

	private void initData() {
		ArrayList<User> list2 = new MySql(BActivity.this).select();
		list.addAll(list2);
		adapter.notifyDataSetChanged();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		index = position;
		User user = list.get(position);
		Intent in = new Intent(BActivity.this,Update.class);
		in.putExtra("up", user);
		setResult(100, in);
		startActivity(in);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==100&&resultCode==200){
			User user = (User) data.getSerializableExtra("context");
			String image = user.getImage();
			new MySql(BActivity.this).update(image, user);
			list.set(index, user);
			adapter.notifyDataSetChanged();
		}
		
	}
	
}
