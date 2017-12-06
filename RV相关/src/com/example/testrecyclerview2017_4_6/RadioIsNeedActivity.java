package com.example.testrecyclerview2017_4_6;

import java.util.ArrayList;
import java.util.List;

import com.example.testrecyclerview2017_4_6.adapter.RadioIsNeedAdapter;
import com.example.testrecyclerview2017_4_6.entity.RadioIsNeedContent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

public class RadioIsNeedActivity extends Activity{

	private RecyclerView rv;
	private RadioIsNeedAdapter mAdapter;
	private List<RadioIsNeedContent> data=new ArrayList<RadioIsNeedContent>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_radio_isneed);
		
		setData();
		rv=(RecyclerView) findViewById(R.id.rv_radio_isneed);
		rv.setLayoutManager(new LinearLayoutManager(this));
		
		mAdapter=new RadioIsNeedAdapter(this, data);
		rv.setAdapter(mAdapter);
	}

	private void setData() {
		for(int i=1;i<101;i++){
			data.add(new RadioIsNeedContent(i+" ",false));
		}
	}
	
}
