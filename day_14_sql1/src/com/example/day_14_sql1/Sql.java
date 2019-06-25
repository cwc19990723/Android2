package com.example.day_14_sql1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Sql extends SQLiteOpenHelper{

	public Sql(Context context) {
		super(context, "my.db", null, 2);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String sql = "create table cwc(id integer primary key autoincrement,name,age,sex)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	//����
	public void insert(Ccc c){
		//String sql = "insert into cwc(name,age,sex) values (?,?,?)";
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", c.getName());
		values.put("age",c.getAge());
		values.put("sex", c.getSex());
		db.insert("cwc", "Ccc", values);
		//db.execSQL(sql,new Object[]{c.getName(),c.getAge(),c.getSex()});
	}
	
	

}
