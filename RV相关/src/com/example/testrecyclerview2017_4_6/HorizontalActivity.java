package com.example.testrecyclerview2017_4_6;

import java.util.ArrayList;
import java.util.List;

import com.example.testrecyclerview2017_4_6.adapter.HorizontalAdapter;
import com.example.testrecyclerview2017_4_6.entity.HorizontalContent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

public class HorizontalActivity extends Activity{

	private RecyclerView rv;
	private List<HorizontalContent> data=new ArrayList<HorizontalContent>();
	private HorizontalAdapter hAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_horizontal);
		
		rv=(RecyclerView) findViewById(R.id.h_rv);
		rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
		someData();
		hAdapter=new HorizontalAdapter(data,this);
		rv.setAdapter(hAdapter);
	}
	
	private void someData(){
		
		for(int i=1;i<101;i++){
			
			data.add(new HorizontalContent(""+i));
			
		}
		
	}
	
}
