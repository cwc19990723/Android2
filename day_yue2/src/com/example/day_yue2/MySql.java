package com.example.day_yue2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySql extends SQLiteOpenHelper{
	//�вι���
	private SQLiteDatabase mydb;

	public MySql(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		if(mydb==null){
			mydb = getWritableDatabase();
		}
	}
	//�������ݿ�
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String sql = "create table user (id Integer primary key autoincrement ,imgurl text,name text,department text,title text,level text,thosptail text) ";
		mydb.execSQL(sql);
		
		for (int i = 0; i < 5; i++) {
			ContentValues values = new ContentValues();
			values.put("imgurl", "http://192.168.1.52:8080/test1/t1.jpg");
			values.put("name", "������");
			values.put("department", "���Ŀ�");
			values.put("level", "����ҽʦ");
			values.put("title", "����");
			values.put("hosptail", "����ʡ�ؿ�ҽԺ");
			mydb.insert("user", null, values);
			
		}
	
	}
	//���ݿ�����
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
