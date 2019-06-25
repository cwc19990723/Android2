package com.example.day_zhou_sql4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySql extends SQLiteOpenHelper{
	

	private SQLiteDatabase mydb;

	public MySql(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		if(mydb==null){
			mydb = getWritableDatabase();
		}
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String sql = "create table user (id Integer primary key autoincrement ,image text, name text, address text, sex text, techang text)";
		db.execSQL(sql);
		for (int i = 0; i < 5; i++) {
			ContentValues values = new ContentValues();
			values.put("image", "http://192.168.1.52:8080/test1/t1.jpg");
			values.put("name", "小花");
			values.put("address", "住在村头");
			values.put("sex", "女");
			values.put("techang", "能歌善舞");
			db.insert("user", null, values);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
	public void insert(User u){
		ContentValues values = new ContentValues();
		values.put("image", u.getImage());
		values.put("name", u.getName());
		values.put("address", u.getAddress());
		values.put("sex", u.getSex());
		values.put("techang", u.getTechang());
		
		mydb.insert("user", null, values);
		mydb.close();
	}

}
