package com.example.testrecyclerview2017_4_6;

import java.util.ArrayList;
import java.util.List;

import com.example.testrecyclerview2017_4_6.adapter.GridviewAdapter;
import com.example.testrecyclerview2017_4_6.entity.Content;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Window;

public class GridViewActivity extends Activity{

	private List<Content> data=new ArrayList<Content>();
	public RecyclerView rv;
	private GridviewAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_gridview);
		
		someData();
		rv=(RecyclerView) findViewById(R.id.rv_gridview);
			
	
		rv.setLayoutManager(new GridLayoutManager(this, 6));//每行显示6个条目
		mAdapter=new GridviewAdapter(this, data);
		rv.setAdapter(mAdapter);
	}
	
	private void someData(){
		
		for(int i=1;i<101;i++){
			
			data.add(new Content(""+i));
			
		}
		
	}
	
}
