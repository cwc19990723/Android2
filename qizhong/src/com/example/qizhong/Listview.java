package com.example.qizhong;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

public class Listview extends Activity {

	private GridView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		
		lv = (GridView) findViewById(R.id.lv_lv);
		
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User(R.drawable.ic_launcher, "小王"));
		list.add(new User(R.drawable.ic_launcher, "小李"));
		list.add(new User(R.drawable.ic_launcher, "小红"));
		list.add(new User(R.drawable.ic_launcher, "小张"));
		MyAdapter adapter = new MyAdapter(list, Listview.this);
		lv.setAdapter(adapter);
		
	}
}
