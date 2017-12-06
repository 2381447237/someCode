package com.example.testrecyclerview2017_4_6.adapter;

import java.util.List;

import com.andview.refreshview.util.BaseRecyclerAdapter;
import com.andview.refreshview.util.DensityUtil;
import com.example.testrecyclerview2017_4_6.R;
import com.example.testrecyclerview2017_4_6.entity.Content;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RefreshAdapter extends BaseRecyclerAdapter<RefreshAdapter.RefreshViewHolder>{

	class RefreshViewHolder extends RecyclerView.ViewHolder{

		TextView tv;
		LinearLayout rootView;
		int position;
		public RefreshViewHolder(View arg0,boolean isItem) {
			super(arg0);
			if(isItem){
			tv=(TextView) arg0.findViewById(R.id.tv_refresh);
			rootView=(LinearLayout) arg0.findViewById(R.id.item_ll_refresh);
		}
		
		}
		
		public Content getItem(int position){
			
			if(position<data.size()){
				return data.get(position);
			}else{
				return null;
			}
			
		}
		
	}

	private List<Content> data;
	private Context context;
	private int largeCardHeight, smallCardHeight;
	
	public RefreshAdapter(List<Content> data, Context context) {
		super();
		this.data = data;
		this.context = context;
		largeCardHeight=DensityUtil.dip2px(context, 150);
		smallCardHeight=DensityUtil.dip2px(context, 100);
	}

	@Override
	public void onBindViewHolder(RefreshViewHolder holder, int position,
			boolean isItem) {
		Content c=data.get(position);
		holder.tv.setText(c.getTv());
		ViewGroup.LayoutParams layoutParams=holder.itemView.getLayoutParams();
		if(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams){
			holder.rootView.getLayoutParams().height=position%2!=0?largeCardHeight:smallCardHeight;
		}
		
	}
	@Override
	public int getAdapterItemViewType(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int getAdapterItemCount() {
		return data.size();
	}
	@Override
	public RefreshViewHolder getViewHolder(View view) {
		return new RefreshViewHolder(view, false);
	}

	@Override
	public RefreshViewHolder onCreateViewHolder(ViewGroup parent, int viewType,
			boolean isItem) {
		
		RefreshViewHolder rvh=new RefreshViewHolder
				(LayoutInflater.from(context).
				inflate(R.layout.item_refresh,parent,false),true);
		
		return rvh;
	}

	

	
	
	
	
}
