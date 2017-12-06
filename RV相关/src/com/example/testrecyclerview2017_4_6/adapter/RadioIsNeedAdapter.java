package com.example.testrecyclerview2017_4_6.adapter;

import java.util.List;

import com.example.testrecyclerview2017_4_6.R;
import com.example.testrecyclerview2017_4_6.entity.RadioIsNeedContent;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RadioIsNeedAdapter extends RecyclerView.Adapter<RadioIsNeedAdapter.MyViewHolder>{

	private Context context;
	private List<RadioIsNeedContent> data;

	public RadioIsNeedAdapter(Context context, List<RadioIsNeedContent> data) {
		super();
		this.context = context;
		this.data = data;
	}

	@Override
	public int getItemCount() {
		
		return data.size();
	}


	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int  viewType) {
		
		MyViewHolder viewHolder=new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_radio_isneed,parent,false));
		
		return viewHolder;
	}
	@Override
	public void onBindViewHolder(MyViewHolder holder, final int position) {
		
		holder.tv.setText(data.get(position).getTv());
	    if(data.get(position).isSelected()){
	    	holder.tv.setTextColor(Color.argb(0xff,0xff,0x00,0x00));
	    }else{
	    	holder.tv.setTextColor(Color.argb(0xff,0x00,0xff,0x00));
	    }
		holder.tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				for(RadioIsNeedContent mc:data){
				if(mc.isSelected()){
					mc.setSelected(false);
				}
				}
				data.get(position).setSelected(!data.get(position).isSelected());
				notifyDataSetChanged();
				
				String str="";
				
				for(RadioIsNeedContent mc:data){
					if(mc.isSelected()){
						str+=mc.getTv();
					}
					}
				
				Toast.makeText(context,"当前选中的是"+str,0).show();
				
			}
		});
		
	}
	
	class MyViewHolder extends ViewHolder{
		
		TextView tv;
		
		public MyViewHolder(View arg0) {
			super(arg0);
			
			tv=(TextView) arg0.findViewById(R.id.tv_radio_isneed);
		}
		
		
		
	}
	
}
