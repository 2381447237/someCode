package com.example.testrecyclerview2017_4_6;

import java.util.ArrayList;
import java.util.List;

import com.example.testrecyclerview2017_4_6.adapter.MyAdapter;
import com.example.testrecyclerview2017_4_6.adapter.MyAdapter.MyOnItemClickListener;
import com.example.testrecyclerview2017_4_6.entity.Content;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends Activity implements MyOnItemClickListener{

	private List<Content> data=new ArrayList<Content>();
	private MyAdapter mAdapter;
	private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        setData();
        rv=(RecyclerView) findViewById(R.id.rv);
      //���ò��ֹ�����
        rv.setLayoutManager(new LinearLayoutManager(this));
        
        mAdapter=new MyAdapter(this, data);
        
        rv.setAdapter(mAdapter);
        mAdapter.setOnMyItemClickListener(this);
    }
    
    private void setData(){
    		
    		data.add(new Content("��ѡRecyclerView�б�ѡ"));
    		data.add(new Content("��ѡRecyclerView"));
    		data.add(new Content("ȫѡ����ѡRecyclerView"));
    		data.add(new Content("��ѡRecyclerView�ޱ�ѡ"));
    		data.add(new Content("����RecyclerView"));
    		data.add(new Content("RecyclerView��gridview"));
    		data.add(new Content("RecyclerView�ٲ���"));
    		data.add(new Content("RecyclerViewʵ�ֶ��ֲ���"));
    	    data.add(new Content("����ͷ����β����RecyclerView"));
    	    data.add(new Content("����ˢ�º��������ظ���"));
    	    data.add(new Content("����ˢ��"));
    	    data.add(new Content("����ˢ�º��������ظ�����ʽ2"));
    	    data.add(new Content("̫����ʽ������ˢ��"));
    }

	@Override
	public void myOnItemClickListener(View view, int position) {
		
		switch (position) {
		case 0:
			
			Intent intent=new Intent(MainActivity.this,RadioIsNeedActivity.class);
			startActivity(intent);
			break;

		case 1:
			
			Intent intent1=new Intent(MainActivity.this,ManyActivity.class);
			startActivity(intent1);
			
			break;
			
         case 2:
			
			Intent intent2=new Intent(MainActivity.this,AllActivity.class);
			startActivity(intent2);
			
			break;
			
         case 3:
 			
 			Intent intent3=new Intent(MainActivity.this,RadioNoNeedActivity.class);
 			startActivity(intent3);
 			
 			break;
			
         case 4:
  			
  			Intent intent4=new Intent(MainActivity.this,HorizontalActivity.class);
  			startActivity(intent4);
  			
  			break;
  			
         case 5:
   			
   			Intent intent5=new Intent(MainActivity.this,GridViewActivity.class);
   			startActivity(intent5);
   			
   			break;
 			
         case 6:
    			
    			Intent intent6=new Intent(MainActivity.this,WaterfallActivity.class);
    			startActivity(intent6);
    			
    			break;
         case 7:
 			
 			Intent intent7=new Intent(MainActivity.this,ManyLayoutActivity.class);
 			startActivity(intent7);
 			
 			break;
 			
         case 8:
        	 Intent intent8=new Intent(MainActivity.this,HeaderAndFooterActivity.class);
        	 startActivity(intent8);
        	 break;
   			
         case 9:
        	 Intent intent9=new Intent(MainActivity.this,RefreshActivity.class);
        	 startActivity(intent9);
        	 break;
        	 
         case 10:
        	 Intent intent10=new Intent(MainActivity.this,PullDownActivity.class);
        	 startActivity(intent10);
        	 break; 
        	 
         case 11:
        	 Intent intent11=new Intent(MainActivity.this,LoadMoreActivity.class);
        	 startActivity(intent11);
        	 break; 
        	 
         case 12:
        	 Intent intent12=new Intent(MainActivity.this,SunActivity.class);
        	 startActivity(intent12);
        	 break; 	 
        	 
		default:
			break;
		}
		
	}
    
}
