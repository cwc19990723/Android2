package com.example.yue_1;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.GridView;

public class BActivity extends Activity implements OnClickListener {

	private GridView b_gr;
	private ArrayList<User> al;
	private EditText zi1;
	private EditText zi2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		b_gr = (GridView) findViewById(R.id.b_gr);
		
		zi1 = (EditText) findViewById(R.id.it_zi1);
		zi2 = (EditText) findViewById(R.id.it_zi2);
		
		
		al = new ArrayList<User>();
		
		shujuku();
		
		add();
		
		MyAdapter adapter = new MyAdapter(BActivity.this, al);
		
		b_gr.setAdapter(adapter);
		
		//b_gr.setOnClickListener(this);
	}

	private void add() {
		String ziyi = zi1.getText().toString();
		String zier = zi2.getText().toString();
		
		MySql mySql = new MySql(BActivity.this, "my.db", null, 1);
		
		SQLiteDatabase dbadd = mySql.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		
		values.put("name", ziyi);
		values.put("info", zier);
		
		dbadd.insert("user", null, values);
		
		dbadd.close();
		
	}

	private void shujuku() {
		MySql mySql = new MySql(BActivity.this, "my,db", null, 1);
		
		SQLiteDatabase db = mySql.getWritableDatabase();
		
	}

	@Override
	public void onClick(View v) {
		
	}


	
	
}
