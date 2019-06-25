package com.example.zuo1;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

@SuppressLint("InflateParams")
public class MainActivity extends Activity implements OnItemLongClickListener, OnItemClickListener {

	private ListView lv;
	private int index = 0;
	private ArrayList<User> list;
	private AlertDialog dialog;
	private MyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv = (ListView) findViewById(R.id.a_lv);
		
		lv.setOnItemLongClickListener(this);
		lv.setOnItemClickListener(this);
		
		list = new ArrayList<User>();
		list.add(new User(R.drawable.ic_launcher, "111", "1"));
		list.add(new User(R.drawable.ic_launcher, "222", "2"));
		list.add(new User(R.drawable.ic_launcher, "333", "3"));
		list.add(new User(R.drawable.ic_launcher, "444", "4"));
		list.add(new User(R.drawable.ic_launcher, "555", "5"));
		adapter = new MyAdapter(list, MainActivity.this);
		lv.setAdapter(adapter);
		
	}
	//长按删除
	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
		
		AlertDialog dialog3 = new AlertDialog.Builder(MainActivity.this).setTitle("标题")
		.setMessage("是否删除")
		.setPositiveButton("确认", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				list.remove(position);
				
				adapter.notifyDataSetChanged();
			}
		})
		.setNegativeButton("取消", null)
		.create();
		dialog3.show();
		
		return true;
	}
	//点击修改
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		View vv = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog, null);
		final EditText edname = (EditText) vv.findViewById(R.id.log_ed);
		final User user = list.get(position);
		
		edname.setText(user.getName());
		
		AlertDialog dialog3 = new AlertDialog.Builder(MainActivity.this)
		.setView(vv)
		.setPositiveButton("修改", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String ed = edname.getText().toString();
				user.setName(ed);
				
				adapter.notifyDataSetChanged();
			}
		})
		.setNegativeButton("取消", null)
		.create();
		dialog3.show();
	}
}
