package com.example.lian7;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

	private Button add;
	private ListView lv;
	private int index = 0;
	private MyAdapter adapter;
	private ArrayList<User> list;
	private AlertDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		add = (Button) findViewById(R.id.a_add);
		lv = (ListView) findViewById(R.id.a_lv);
		
		list = new ArrayList<User>();
		list.add(new User(R.drawable.ic_launcher, "111", "1"));
		list.add(new User(R.drawable.ic_launcher, "222", "2"));
		list.add(new User(R.drawable.ic_launcher, "333", "3"));
		list.add(new User(R.drawable.ic_launcher, "444", "4"));
		list.add(new User(R.drawable.ic_launcher, "555", "5"));
		adapter = new MyAdapter(list, MainActivity.this);
		lv.setAdapter(adapter);
		
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
		
		add.setOnClickListener(this);
		lv.setOnItemLongClickListener(this);
		lv.setOnItemClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.a_add:
			Intent in = new Intent(MainActivity.this,Add.class);
			startActivityForResult(in, 300);
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
		
		User user = list.get(position);
		
		Intent in = new Intent(MainActivity.this,Update.class);
		in.putExtra("up", user);
		startActivityForResult(in, 100);
		
	}
	//接收回传数据
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//添加
		if(requestCode==300&&resultCode==400){
			
			User user = (User) data.getSerializableExtra("add");
			
			list.add(user);
			adapter.notifyDataSetChanged();
		}
		
		//修改
		if(requestCode==100&&resultCode==200){
			User user = (User) data.getSerializableExtra("context");
			list.set(index, user);
		}
		adapter.notifyDataSetChanged();
	}
	
}
