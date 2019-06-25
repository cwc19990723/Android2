package com.example.lian5;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv = (ListView) findViewById(R.id.a_lv);
		
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User(R.drawable.a1, "Öí", "°®Ë¯¾õ"));
		list.add(new User(R.drawable.a2, "¹·", "°®³Ô¹ÇÍ·"));
		list.add(new User(R.drawable.a3, "Ã¨", "°®³ÔÓã"));
		list.add(new User(R.drawable.a4, "Öí", "°®³ÔºúÂÜ²·"));
		list.add(new User(R.drawable.a5, "¼¦", "°®´òÃù"));
		list.add(new User(R.drawable.a6, "°ßÂí", "°®³Ô²İ"));
		MyAdapter adapter = new MyAdapter(list, MainActivity.this);
		lv.setAdapter(adapter);
	}
}
