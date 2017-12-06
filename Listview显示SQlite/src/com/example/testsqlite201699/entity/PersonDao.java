package com.example.testsqlite201699.entity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;

import com.example.testsqlite201699.MySQLiteHelper;

public class PersonDao {

MySQLiteHelper helper;

	public PersonDao(Context context) {
		
		helper=new MySQLiteHelper(context);
		
	}
	
	//����
	public void add(Content ct){
		
		// �õ��������ʵ����Ȼ��ȥ�������ݿ�
		SQLiteDatabase db=helper.getWritableDatabase();
		
		//ִ��sql���
		db.execSQL("insert into personInfo values(null,?,?,?)",new Object[]{ct.getName(),ct.getPhone(),ct.getTime()});
	}
	
	//ɾ��
	public void delete(String id){
		
		// �õ��������ʵ����Ȼ��ȥ�������ݿ�
		SQLiteDatabase db=helper.getWritableDatabase();
		
		//ִ��sql���
		db.execSQL("delete from personInfo where _id=?",new Object[]{id});
		
	}
	
	//�޸�
	public void update(Content ct){
		// �õ��������ʵ����Ȼ��ȥ�������ݿ�
		SQLiteDatabase db=helper.getWritableDatabase();
		
		//ִ��sql���
		db.execSQL("update personInfo set name=?,phone=?,time=? where_id=?",new Object[]{ct.getName(),ct.getPhone(),ct.getTime()});
	}
	
	public Content find(String id){
		// �õ��������ʵ����Ȼ��ȥ�������ݿ�
		SQLiteDatabase db=helper.getReadableDatabase();
		
		Cursor cursor=db.rawQuery("select * from personInfo where _id=?",new String[]{id});
		//���α�������һλ
		boolean result=cursor.moveToNext();
		
		Content ct=null;
		
		if(result){
			
			int _id=cursor.getInt(cursor.getColumnIndex("_id"));
			
			String name=cursor.getString(cursor.getColumnIndex("name"));
			
			String phone=cursor.getString(cursor.getColumnIndex("phone"));
			
			String time=cursor.getString(cursor.getColumnIndex("time"));
			
			ct=new Content(String.valueOf(_id),name,phone,time);
			
		}
		//�ͷ���Դ
		cursor.close();
		
		return ct;
	}
	
	//��ѯ��������ѧ������Ϣ
	public List<Content> getAll(){
		
		List<Content> list=new ArrayList<Content>();
		
		SQLiteDatabase db=helper.getReadableDatabase();
		
		Cursor cursor=db.rawQuery("select * from personInfo",null);
		
		while(cursor.moveToNext()){
			
			int _id=cursor.getInt(cursor.getColumnIndex("_id"));
			String name=cursor.getString(cursor.getColumnIndex("name"));
            String phone=cursor.getString(cursor.getColumnIndex("phone"));
			
			String time=cursor.getString(cursor.getColumnIndex("time"));
			Content ct=new Content(String.valueOf(_id),name,phone,time);
			list.add(ct);
			
		}
		
		return list;
	}
}
