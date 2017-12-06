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

public class PullDownAdapter extends BaseRecyclerAdapter<PullDownAdapter.MyViewHolder>{

	class MyViewHolder extends ViewHolder{

		TextView tv;
		LinearLayout rootView;
		int position;
		public MyViewHolder(View arg0,boolean isItem) {
			super(arg0);
		   if(isItem){
			tv=(TextView) arg0.findViewById(R.id.tv_pull_down);
			rootView=(LinearLayout) arg0.findViewById(R.id.item_ll_pull_down);
		   }
		}	
		
	}

	private List<Content> data;
	private Context context;
	private int largeCardHeight, smallCardHeight;
	
	public PullDownAdapter(List<Content> data, Context context) {
		super();
		this.data = data;
		this.context = context;
		largeCardHeight=DensityUtil.dip2px(context, 150);
		smallCardHeight=DensityUtil.dip2px(context, 100);
	}


	@Override
	public MyViewHolder getViewHolder(View view) {
		return new MyViewHolder(view,false);
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType,
			boolean isItem) {

		MyViewHolder vh=new MyViewHolder(LayoutInflater.from(context).
				inflate(R.layout.item_pull_down,parent,false), true);
		
		return vh;
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position,
			boolean isItem) {
		Content c=data.get(position);
		holder.tv.setText(c.getTv());
		ViewGroup.LayoutParams layoutParams=holder.itemView.getLayoutParams();
		if(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams){
			holder.rootView.getLayoutParams().height=position%2!=0?largeCardHeight:smallCardHeight;
		}
	}

	@Override
	public int getAdapterItemCount() {
		return data.size();
	}

	
}
