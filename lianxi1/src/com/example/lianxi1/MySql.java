package com.example.lianxi1;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySql extends SQLiteOpenHelper{

	public MySql(Context context) {
		super(context, "my.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table goods (id integer primary key autoincrement,image,name)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	//插入方法
	public void insert(User s){
		String sql = "insert into goods(image,name) values (?,?)";
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL(sql,new Object[]{s.getImage(),s.getName()});
	}
	//查询所有
	public ArrayList<User> select(){
		String sql = "select * from goods";
		SQLiteDatabase db = getWritableDatabase();
		Cursor query = db.rawQuery(sql, null);
		ArrayList<User> list = new ArrayList<User>();
		while (query.moveToNext()) {
			String image = query.getString(query.getColumnIndex("image"));
			String name = query.getString(query.getColumnIndex("name"));
			list.add(new User(image, name));
		}
		return list;
	}
	//修改方法
	public void update(String image, User s){
		String sql = "update goods set image=?, name=? where image=?";
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL(sql,new Object[]{s.getImage(),s.getName()});
	}

}
