package com.example.testrecyclerview2017_4_6.adapter;

import java.util.List;

import com.example.testrecyclerview2017_4_6.GridViewActivity;
import com.example.testrecyclerview2017_4_6.R;
import com.example.testrecyclerview2017_4_6.entity.Content;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GridviewAdapter extends RecyclerView.Adapter<GridviewAdapter.MyViewHolder>{

	class MyViewHolder extends ViewHolder{

		TextView tv;
		
		public MyViewHolder(View arg0) {
			super(arg0);
			tv=(TextView) arg0.findViewById(R.id.tv_gridview);
		}
		
	}

	private GridViewActivity context;
	private List<Content> data;
	
	public GridviewAdapter(GridViewActivity context, List<Content> data) {
		super();
		this.context = context;
		this.data = data;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {

		MyViewHolder viewHolder=new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_gridview,arg0,false));
		
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(MyViewHolder arg0, int arg1) {
		
		arg0.tv.setText(data.get(arg1).getTv());
	}

	
}
