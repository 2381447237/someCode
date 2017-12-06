package com.example.testrecyclerview2017_4_6;

import java.util.ArrayList;
import java.util.List;

import com.example.testrecyclerview2017_4_6.adapter.ManyAdapter;
import com.example.testrecyclerview2017_4_6.entity.ManyContent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

public class ManyActivity extends Activity{

	private List<ManyContent> data=new ArrayList<ManyContent>();
	private ManyAdapter mAdapter;
	private RecyclerView rv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_many);
		
		someData();
		rv=(RecyclerView) findViewById(R.id.many_rv);
		rv.setLayoutManager(new LinearLayoutManager(this));
		mAdapter=new ManyAdapter(this, data);
		rv.setAdapter(mAdapter);
	}
	
	private void someData(){
		
		for(int i=1;i<101;i++){
			data.add(new ManyContent(""+i,false));
		}
		
	}
	
}
