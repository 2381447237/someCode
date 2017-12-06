package com.example.testrecyclerview2017_4_6.adapter;

import java.util.List;

import com.example.testrecyclerview2017_4_6.R;
import com.example.testrecyclerview2017_4_6.entity.Content;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

	private Context context;
	private List<Content> data;
	
	public MyAdapter(Context context, List<Content> data) {
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
		
		MyViewHolder holder=new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false));
		
		return holder;
	}

	@Override
	public void onBindViewHolder(final MyViewHolder holder, int position) {
		
		holder.tv.setText(data.get(position).getTv());
		
		if(mOnItemClickListener!=null){
			
	     holder.tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				int pos=holder.getPosition();
				mOnItemClickListener.myOnItemClickListener(holder.tv, pos);
				
			}
		});
			
		}
		
	}

	
	class MyViewHolder extends ViewHolder{
		
		TextView tv;
		
		public MyViewHolder(View arg0) {
			super(arg0);
			tv=(TextView)arg0.findViewById(R.id.tv);
		}
		
	}
	
	public interface MyOnItemClickListener{
		
		void myOnItemClickListener(View view,int position);
		
	}
	
	private MyOnItemClickListener mOnItemClickListener;
	
	public void setOnMyItemClickListener(MyOnItemClickListener mOnItemClickListener){
		
		this.mOnItemClickListener=mOnItemClickListener;
		
	}
	
}
