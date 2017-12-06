package com.example.testrecyclerview2017_4_6;

import com.example.materialrefreshlayout.view.MaterialRefreshLayout;
import com.example.materialrefreshlayout.view.MaterialRefreshListener;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class LoadMoreActivity extends Activity{

	private MaterialRefreshLayout materialRefreshLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fragment_list);
		
		materialRefreshLayout=(MaterialRefreshLayout) findViewById(R.id.refresh);
		materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
			
			@Override
			public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
				materialRefreshLayout.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						materialRefreshLayout.finishRefresh();
					}
				}, 3000);
			}
			
			@Override
			public void onfinish() {
				super.onfinish();
				Toast.makeText(LoadMoreActivity.this,"刷新完成",0).show();
			}
			
//			@Override
//			public void onRefreshLoadMore(
//					final MaterialRefreshLayout materialRefreshLayout) {
//				super.onRefreshLoadMore(materialRefreshLayout);
//				
//				materialRefreshLayout.postDelayed(new Runnable() {
//					
//					@Override
//					public void run() {
//						materialRefreshLayout.finishRefreshLoadMore();
//						Toast.makeText(LoadMoreActivity.this,"123加载更多完成",0).show();
//					}
//				},3000);
//			}
			
		});
		
		RecyclerView rv=(RecyclerView) findViewById(R.id.recyclerview);
		setupRecyclerView(rv);
	}
	
	private void setupRecyclerView(RecyclerView rv){
		rv.setLayoutManager(new LinearLayoutManager(this));
		rv.setAdapter(new SimpleStringRecyclerViewAdapter(this));
		rv.setItemAnimator(new DefaultItemAnimator());
	}
	
	public static class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder>{
		
		public static class ViewHolder extends RecyclerView.ViewHolder{

			public ImageView iv;
			
			public ViewHolder(View arg0) {
				super(arg0);
				
				iv=(ImageView) arg0.findViewById(R.id.avatar);
			}
			
		}

		public SimpleStringRecyclerViewAdapter(Context context){}
		
		@Override
		public int getItemCount() {
			return 3;
		}

		@Override
		public void onBindViewHolder(ViewHolder arg0, int position) {
			
			if(position==0){
				arg0.iv.setImageResource(R.drawable.a5);
			}else if(position==1){
				arg0.iv.setImageResource(R.drawable.a6);
			}
			
		}

		@Override
		public ViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
			
			ViewHolder vh=new ViewHolder(LayoutInflater.from(arg0.getContext()).
					inflate(R.layout.list_item, arg0,false));
			
			return vh;
		}
		
	}
	
}
