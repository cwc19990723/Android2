package com.example.zuoye1;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import bean.datas;

public class MySql extends SQLiteOpenHelper{

	public MySql(Context context) {
		super(context, "my.db", null, 2);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table cwc( id integer primary key autoincrement, chapterName,publishTime,envelopePic)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
	public void insert(datas s){
		String sql = "insert into cwc(chapterName,envelopePic,publishTime) values (?,?,?)";
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL(sql,new Object[]{s.getChapterName(),s.getEnvelopePic(),s.getPublishTime()});
	}
	
	public ArrayList<datas> select(){
		String sql = "select * from cwc";
		SQLiteDatabase db = getWritableDatabase();
		Cursor query = db.rawQuery(sql, null);
		ArrayList<datas> list = new ArrayList<datas>();
		while (query.moveToNext()) {
			String chapterName = query.getString(query.getColumnIndex("chapterName"));
			String envelopePic = query.getString(query.getColumnIndex("envelopePic"));
			String publishTime = query.getString(query.getColumnIndex("publishTime"));
			list.add(new datas(chapterName, envelopePic, publishTime));
		}
		return list;
	}
	
	/*public ArrayList<datas> select(){
		SQLiteDatabase db = getReadableDatabase();
		Cursor query = db.query("cwc", null, null, null, null, null, null);
		ArrayList<datas> list = new  ArrayList<datas>();
		while(query.moveToNext()){
			String chapterName = query.getString(query.getColumnIndex("chapterName"));
			String publishTime = query.getString(query.getColumnIndex("publishTime"));
			String envelopePic = query.getString(query.getColumnIndex("envelopePic"));
			list.add(new datas(chapterName,envelopePic,publishTime));
		}
		return list;
	}*/

}
