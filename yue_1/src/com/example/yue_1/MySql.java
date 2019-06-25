package com.example.yue_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySql extends SQLiteOpenHelper{
	//�вι���
	public MySql(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	//�������ݿ�
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table goods(id Integer primary key autoincrement ,img text,name text,info text )";
		//ִ�д�������
		db.execSQL(sql);
		
		//��ʼ������
		for (int i = 0; i < 10; i++) {
			ContentValues values = new ContentValues();
			values.put("name", "С��"+i);
			values.put("info", "������"+i);
			
			db.insert("goods", null, values);
		}
		
		
	}
	//�����������ݿ�  �汾���ʱʹ��
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
