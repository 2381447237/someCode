package com.example.testrecyclerview2017_4_6.adapter;

import java.util.List;

import com.example.testrecyclerview2017_4_6.R;
import com.example.testrecyclerview2017_4_6.entity.Content;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class WaterfallAdapter extends RecyclerView.Adapter<WaterfallAdapter.MyViewHolder>{

	class MyViewHolder extends ViewHolder{

		TextView tv;
		LinearLayout ll;
		
		public MyViewHolder(View arg0) {
			super(arg0);
			tv=(TextView) arg0.findViewById(R.id.tv_waterfall);
			ll=(LinearLayout) arg0.findViewById(R.id.ll_waterfall);
		}
		
	}

	private Context context;
	private List<Content> data;
	
	public WaterfallAdapter(Context context, List<Content> data) {
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
		
		MyViewHolder viewHolder=new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_waterfall,arg0,false));
		
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(MyViewHolder arg0, final int arg1) {
		
		
		LinearLayout.LayoutParams lp=(android.widget.LinearLayout.LayoutParams) arg0.ll.getLayoutParams();
		
		if(arg1%3==0){
			lp.height=60;
		arg0.ll.setLayoutParams(lp);
	}else if(arg1%3==1){
		lp.height=100;
		arg0.ll.setLayoutParams(lp);
	}else{
		lp.height=120;
		arg0.ll.setLayoutParams(lp);
	}
		
		arg0.tv.setText(data.get(arg1).getTv());
	
		arg0.ll.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(context,"你点击了，第"+(arg1+1)+"个",0).show();
			}
		});
	}
     
	
}
