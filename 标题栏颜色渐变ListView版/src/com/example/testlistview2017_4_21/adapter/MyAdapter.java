package com.example.testlistview2017_4_21.adapter;

import java.util.List;

import com.example.testlistview2017_4_21.R;
import com.example.testlistview2017_4_21.entity.Content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{

	private List<Content> data;
	private Context context;
	private LayoutInflater inflater;
	
	public MyAdapter(List<Content> data, Context context) {
		super();
		this.data = data;
		this.context = context;
		inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		
		ViewHolder vh;
		
		if(arg1==null){
			vh=new ViewHolder();
			arg1=inflater.inflate(R.layout.item,arg2,false);
			vh.tv=(TextView) arg1.findViewById(R.id.item_tv);
			
			arg1.setTag(vh);
		}else{
			
			vh=(ViewHolder) arg1.getTag();
		}
		
		vh.tv.setText(data.get(arg0).getTv());
		
		return arg1;
	}

	class ViewHolder{
		
		TextView tv;
		
	}
	
}
