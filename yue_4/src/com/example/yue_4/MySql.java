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
	
	//�вι���
	public MySql(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		if(mydb==null){
			mydb = getWritableDatabase();
		}
		
	}
	//�������ݿ� ֻ�ܵ�һ��ʹ��
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table user(id integer primary key autoincrement,content text)";
		db.execSQL(sql);
		//��ʼ������
		
	}
	//���ݿ�����  ��ʱ�ò���
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
	//��
	public void inserUser(data u){
		ContentValues values = new ContentValues();
		values.put("data", u.getContent());
		
		mydb.insert("user", null, values);
		mydb.close();
	}

}
