package com.example.lian6;

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
		
		ArrayList<Ccc> list = new ArrayList<Ccc>();
		list.add(new Ccc(R.drawable.ic_launcher, "羊羊羊", "我在家"));
		list.add(new Ccc(R.drawable.ic_launcher, "羊羊羊", "我在家"));
		list.add(new Ccc(R.drawable.ic_launcher, "羊羊羊", "我在家"));
		list.add(new Ccc(R.drawable.ic_launcher, "羊羊羊", "我在家"));
		list.add(new Ccc(R.drawable.ic_launcher, "羊羊羊", "我在家"));
		list.add(new Ccc(R.drawable.ic_launcher, "羊羊羊", "我在家"));
		list.add(new Ccc(R.drawable.ic_launcher, "羊羊羊", "我在家"));
		MyAdapter adapter = new MyAdapter(list, MainActivity.this);
		lv.setAdapter(adapter);
		
	}
}
