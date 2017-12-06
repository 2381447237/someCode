package com.example.testsqlite201699.adapter;

import java.util.List;

import com.example.testsqlite201699.R;
import com.example.testsqlite201699.entity.Content;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
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
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;
		
		if(convertView==null){
			
			holder=new ViewHolder();
			
			convertView=inflater.inflate(R.layout.item,null);
			
			holder.ll=(LinearLayout) convertView.findViewById(R.id.ll_item);
			holder.numberTv=(TextView) convertView.findViewById(R.id.item_number);
			holder.nameTv=(TextView) convertView.findViewById(R.id.item_name);
			holder.phoneTv=(TextView) convertView.findViewById(R.id.item_phone);
			holder.timeTv=(TextView) convertView.findViewById(R.id.item_time);
			
			convertView.setTag(holder);
		}else{
			
			holder=(ViewHolder) convertView.getTag();
			
		}
		
		if(position%2!=0){			
			holder.ll.setBackgroundColor(Color.rgb(0xe9,0xf2,0Xf4));
			
		}else{
			holder.ll.setBackgroundColor(Color.rgb(0xbf,0xd9,0Xed));
			
		}
		
		Content c=data.get(position);
		
		holder.numberTv.setText(String.valueOf(c.number));
		holder.nameTv.setText(c.name);
		holder.phoneTv.setText(c.phone);
		holder.timeTv.setText(c.time);
		
		return convertView;
	}

	class ViewHolder{
		
		LinearLayout ll;
		TextView numberTv,nameTv,phoneTv,timeTv;
		
	}
	
}
