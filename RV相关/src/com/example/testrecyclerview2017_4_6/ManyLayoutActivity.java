package com.example.testrecyclerview2017_4_6;

import java.util.ArrayList;
import java.util.List;

import com.example.testrecyclerview2017_4_6.adapter.ManyLayoutAdapter;
import com.example.testrecyclerview2017_4_6.entity.ManyLayoutContent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

public class ManyLayoutActivity extends Activity{

	private RecyclerView rv;
	private List<ManyLayoutContent> data=new ArrayList<ManyLayoutContent>();
	private ManyLayoutAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_manylayout);
		
		rv=(RecyclerView) findViewById(R.id.rv_manylayout);
		rv.setLayoutManager(new LinearLayoutManager(this));
		someData();
		mAdapter=new ManyLayoutAdapter(data, this);
		rv.setAdapter(mAdapter);
	}
	
	private void someData(){
		
		for(int i=0;i<101;i++){
			
			data.add(new ManyLayoutContent("ÎÄ×Ö"+i));
			
		}
		
	}
	
}
