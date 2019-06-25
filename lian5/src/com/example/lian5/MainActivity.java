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
		list.add(new User(R.drawable.a1, "��", "��˯��"));
		list.add(new User(R.drawable.a2, "��", "���Թ�ͷ"));
		list.add(new User(R.drawable.a3, "è", "������"));
		list.add(new User(R.drawable.a4, "��", "���Ժ��ܲ�"));
		list.add(new User(R.drawable.a5, "��", "������"));
		list.add(new User(R.drawable.a6, "����", "���Բ�"));
		MyAdapter adapter = new MyAdapter(list, MainActivity.this);
		lv.setAdapter(adapter);
	}
}
