package com.example.day_yue2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySql extends SQLiteOpenHelper{
	//有参构造
	private SQLiteDatabase mydb;

	public MySql(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		if(mydb==null){
			mydb = getWritableDatabase();
		}
	}
	//创建数据库
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String sql = "create table user (id Integer primary key autoincrement ,imgurl text,name text,department text,title text,level text,thosptail text) ";
		mydb.execSQL(sql);
		
		for (int i = 0; i < 5; i++) {
			ContentValues values = new ContentValues();
			values.put("imgurl", "http://192.168.1.52:8080/test1/t1.jpg");
			values.put("name", "董立国");
			values.put("department", "内心科");
			values.put("level", "主任医师");
			values.put("title", "教授");
			values.put("hosptail", "湖南省胸科医院");
			mydb.insert("user", null, values);
			
		}
	
	}
	//数据库升级
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
