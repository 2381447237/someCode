package com.example.testrecyclerview2017_4_6.adapter;

import java.util.List;

import com.example.testrecyclerview2017_4_6.R;
import com.example.testrecyclerview2017_4_6.entity.ManyContent;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ManyAdapter extends RecyclerView.Adapter<ManyAdapter.MyViewHolder>{

	private Context context;
	private List<ManyContent> data;

	public ManyAdapter(Context context, List<ManyContent> data) {
		super();
		this.context = context;
		this.data = data;
	}

	@Override
	public int getItemCount() {
		return data.size();
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		
		MyViewHolder viewHolder=new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_many,arg0,false));
		
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(MyViewHolder arg0, final int arg1) {
	
		arg0.tv.setText(data.get(arg1).getTv());
		if(data.get(arg1).isSelected()){
			arg0.tv.setTextColor(Color.argb(0xff,0xff,0x00,0x00));
		}else{
			arg0.tv.setTextColor(Color.argb(0xff,0x00,0xff,0x00));
		}
		arg0.tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				data.get(arg1).setSelected(!data.get(arg1).isSelected());
				notifyDataSetChanged();
				
				String str="";
				
				for(ManyContent mc:data){
					
					if(mc.isSelected()){
						str+=mc.getTv()+"、";
					}
					
				}
				
				Toast.makeText(context,"当前选中的有:"+str,0).show();
				
			}
		});
	}

	class MyViewHolder extends ViewHolder{
		
		TextView tv;
		
		public MyViewHolder(View arg0) {
			super(arg0);
			tv=(TextView) arg0.findViewById(R.id.tv_many);
		}
			
	}
	
}
