package com.example.testrecyclerview2017_4_6;

import java.util.ArrayList;
import java.util.List;

import com.andview.refreshview.util.XRefreshView;
import com.andview.refreshview.util.XRefreshView.XRefreshViewListener;
import com.andview.refreshview.util.XRefreshViewFooter;
import com.example.testrecyclerview2017_4_6.adapter.RefreshAdapter;
import com.example.testrecyclerview2017_4_6.entity.Content;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

public class RefreshActivity extends Activity{

	private RecyclerView rv;
	private RefreshAdapter mAdapter;
	private List<Content> data=new ArrayList<Content>();
	private XRefreshView xRefreshView;
	private int lastVisibleItem = 0;
    private boolean isBottom = false;
    private int mLoadCount = 0;
    private boolean isList = true;//false 为grid布局
    private int a=1;
    private int b=1;
    private Handler mHandler=new Handler(){
    	public void handleMessage(android.os.Message msg) {
    		
    		switch (msg.what) {
			case 10000:
				
				data.add(new Content("下拉刷新"+a++));
				mAdapter.notifyDataSetChanged();
				xRefreshView.stopRefresh();
				break;

			case 20000:
				
				if(b>=5){
				xRefreshView.setLoadComplete(true);//模拟没有更多数据的情况
				}else{
					data.add(new Content("上拉加载更多"+b++));
					mAdapter.notifyDataSetChanged();
					//xRefreshView.stopLoadMore(false);//加载失败，请重试
					xRefreshView.stopLoadMore(true);//加载完成
				}
				break;
				
			default:
				break;
			}
    		
    	};
    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_refresh);
		
		xRefreshView=(XRefreshView) findViewById(R.id.xrefreshview);
		rv=(RecyclerView) findViewById(R.id.rv_refresh);
		rv.setHasFixedSize(true);
		someData();
		mAdapter=new RefreshAdapter(data,this);
		rv.setLayoutManager(new LinearLayoutManager(this));
		rv.setAdapter(mAdapter);
		
		 xRefreshView.setPinnedTime(1000);//设置刷新完成以后，headerview固定的时间
	        xRefreshView.setMoveForHorizontal(true);
	        xRefreshView.setPullLoadEnable(true);
	        xRefreshView.setAutoLoadMore(false);
	        mAdapter.setCustomLoadMoreView(new XRefreshViewFooter(this));
	        xRefreshView.enableReleaseToLoadMore(true);
	        xRefreshView.enableRecyclerViewPullUp(true);
	        xRefreshView.enablePullUpWhenLoadCompleted(true);
	        
	        xRefreshView.setXRefreshViewListener(new XRefreshViewListener() {
				
				@Override
				public void onRelease(float direction) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onRefresh(boolean isPullDown) {//下拉刷新
					Message msg=Message.obtain();
					msg.what=10000;
					mHandler.sendEmptyMessageDelayed(10000,500);
				}
				
				@Override
				@Deprecated
				public
				void onRefresh() {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onLoadMore(boolean isSilence) {//上拉加载更多
					Message msg=Message.obtain();
					msg.what=20000;
					mHandler.sendEmptyMessageDelayed(20000,500);
				}
				
				@Override
				public void onHeaderMove(double headerMovePercent, int offsetY) {
					// TODO Auto-generated method stub
					
				}
			});
	}
	
	
	private void someData(){
		
		for(int i=1;i<6;i++){
			
			data.add(new Content("内容"+i));
			
		}
		
	}
	
}
