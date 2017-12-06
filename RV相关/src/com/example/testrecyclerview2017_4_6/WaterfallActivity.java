package com.example.testrecyclerview2017_4_6;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.example.testrecyclerview2017_4_6.adapter.WaterfallAdapter;
import com.example.testrecyclerview2017_4_6.entity.Content;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Window;

public class WaterfallActivity extends Activity{

	private WaterfallAdapter mAdapter;
	private List<Content> data=new ArrayList<Content>();
	private RecyclerView rv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_waterfall);
		
		rv=(RecyclerView) findViewById(R.id.waterfall_rv);
		rv.setLayoutManager(new StaggeredGridLayoutManager(3,LinearLayoutManager.VERTICAL));
		someData();
		mAdapter=new WaterfallAdapter(this, data);
		rv.setAdapter(mAdapter);
	}
	
	private void someData(){
		
		for(int i=1;i<101;i++){
			data.add(new Content(""+i));
		}
		
	}
	
}
