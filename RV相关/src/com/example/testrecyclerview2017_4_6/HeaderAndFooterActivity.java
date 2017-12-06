package com.example.testrecyclerview2017_4_6;

import java.util.ArrayList;
import java.util.List;

import com.example.testrecyclerview2017_4_6.adapter.HeaderAndFooterAdapter;
import com.example.testrecyclerview2017_4_6.entity.Content;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

public class HeaderAndFooterActivity extends Activity{

	private RecyclerView rv;
	private List<Content> data=new ArrayList<Content>();
	private HeaderAndFooterAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_header_footer);
		
		rv=(RecyclerView) findViewById(R.id.rv_header_footer);
		rv.setLayoutManager(new LinearLayoutManager(this));
		someData();
		mAdapter=new HeaderAndFooterAdapter(data, this);
		rv.setAdapter(mAdapter);
		
	}
	
	private void someData(){
		
		for(int i=1;i<21;i++){
			data.add(new Content("ÄÚÈÝ"+i));
		}
		
	}
	
}
