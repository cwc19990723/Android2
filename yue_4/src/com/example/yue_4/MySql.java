package com.example.yue_4;

import java.util.Iterator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import bean.User;
import bean.data;

public class MySql extends SQLiteOpenHelper{
	
	private SQLiteDatabase mydb;
	
	//有参构造
	public MySql(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		if(mydb==null){
			mydb = getWritableDatabase();
		}
		
	}
	//创建数据库 只能第一次使用
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table user(id integer primary key autoincrement,content text)";
		db.execSQL(sql);
		//初始化数据
		
	}
	//数据库升级  暂时用不到
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
	//增
	public void inserUser(data u){
		ContentValues values = new ContentValues();
		values.put("data", u.getContent());
		
		mydb.insert("user", null, values);
		mydb.close();
	}

}
