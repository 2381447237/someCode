package com.example.gvandlv.adapter;

import java.util.List;

import com.example.gvandlv.R;
import com.example.gvandlv.entity.GvContent;
import com.example.gvandlv.entity.GvContent.LvContent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LvAdapter extends BaseAdapter{

	private List<LvContent> data;
	private Context context;
	private LayoutInflater inflater;
	
	public LvAdapter(List<LvContent> data, Context context) {
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
	public View getView(int position, View convertView, ViewGroup arg2) {
		
		ViewHolder vh;
		
		if(convertView==null){
			
			vh=new ViewHolder();
			
			convertView=inflater.inflate(R.layout.item_lv,arg2,false);
			
			vh.tv=(TextView) convertView.findViewById(R.id.item_lv_tv);
			
			convertView.setTag(vh);
		}else{
			
			vh=(ViewHolder) convertView.getTag();
			
		}
		
		LvContent lc=data.get(position);
		
		vh.tv.setText(lc.getLv_tv());
		
		return convertView;
	}

	class ViewHolder{
		
		TextView tv;
		
	}
	
}
