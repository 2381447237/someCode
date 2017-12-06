package com.example.testrecyclerview2017_4_6.adapter;

import java.util.List;

import com.example.testrecyclerview2017_4_6.R;
import com.example.testrecyclerview2017_4_6.entity.Content;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HeaderAndFooterAdapter extends RecyclerView.Adapter<HeaderAndFooterAdapter.MyViewHolder>{

	class MyViewHolder extends ViewHolder{

		TextView tv;
		
		public MyViewHolder(View arg0) {
			super(arg0);
		tv=(TextView) arg0.findViewById(R.id.tv_header_footer);
		}
		
	}

	private List<Content> data;
	private Context context;
	
	public HeaderAndFooterAdapter(List<Content> data, Context context) {
		super();
		this.data = data;
		this.context = context;
		
	}
	@Override
	public int getItemCount() {
		return data.size();
	}
	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		
		MyViewHolder vh=new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_header_footer,arg0,false));
		
		return vh;
	}

	@Override
	public void onBindViewHolder(MyViewHolder arg0, int arg1) {
		
		arg0.tv.setText(data.get(arg1).getTv());
		
	}

	
}
