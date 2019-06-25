package com.example.lian_zuo;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySql extends SQLiteOpenHelper{

	public MySql(Context context) {
		super(context, "my.db", null, 2);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table user(id integer primary key autoincrement , name)";
		
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	//
	public void insert(User s){
		String sql = "insert into user(name) values (?)";
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL(sql,new Object[]{s.getName()});
	}
	//²éÑ¯ËùÓÐ
	public ArrayList<User> select(){
		String sql = "select * from user";
		SQLiteDatabase db = getWritableDatabase();
		Cursor query = db.rawQuery(sql, null);
		ArrayList<User> list = new ArrayList<User>();
		while (query.moveToNext()) {
			int id = query.getInt(query.getColumnIndex("id"));
			String name = query.getString(query.getColumnIndex("name"));
			list.add(new User(id, name));
		}
		return list;
	}

}
