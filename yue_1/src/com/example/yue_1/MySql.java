package com.example.yue_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySql extends SQLiteOpenHelper{
	//有参构造
	public MySql(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	//创建数据库
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table goods(id Integer primary key autoincrement ,img text,name text,info text )";
		//执行创建命令
		db.execSQL(sql);
		
		//初始化数据
		for (int i = 0; i < 10; i++) {
			ContentValues values = new ContentValues();
			values.put("name", "小刚"+i);
			values.put("info", "爱读书"+i);
			
			db.insert("goods", null, values);
		}
		
		
	}
	//用于升级数据库  版本变更时使用
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
