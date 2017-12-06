package com.example.testsqlite201699;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper{

	public MySQLiteHelper(Context context) {
		//context:应用上下文
				//name:数据库的名称
				//factory:创建游标的工厂
				//version:数据库的版本
		super(context,"test",null,1);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	
		db.execSQL("create table personInfo(_id integer primary key autoincrement,name varchar(30),phone integer,time varchar(50))");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
