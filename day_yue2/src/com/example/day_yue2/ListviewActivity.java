package com.example.day_yue2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class ListviewActivity extends Activity {

	private ListView lv;
	private ArrayList<User> list;
	
	Handler hand = new Handler(){

		private MyAdapter adapter;

		public void handleMessage(android.os.Message msg) {
			list = (ArrayList<User>) msg.obj;
			adapter = new MyAdapter(ListviewActivity.this, list);
			lv.setAdapter(adapter);
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		
		lv = (ListView) findViewById(R.id.lv_lv);
		
		MySql sql = new MySql(this, "my.db", null, 1);
	}
}
