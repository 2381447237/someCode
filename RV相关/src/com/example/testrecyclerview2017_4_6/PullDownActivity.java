package com.example.testrecyclerview2017_4_6;

import java.util.ArrayList;
import java.util.List;

import com.andview.refreshview.util.XRefreshView;
import com.andview.refreshview.util.XRefreshView.XRefreshViewListener;
import com.andview.refreshview.util.XRefreshViewFooter;
import com.example.testrecyclerview2017_4_6.adapter.PullDownAdapter;
import com.example.testrecyclerview2017_4_6.entity.Content;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

public class PullDownActivity extends Activity{
	
	private PullDownAdapter mAdapter;
	private List<Content> data=new ArrayList<Content>();
	private RecyclerView rv;
	private XRefreshView xRefreshView;
	private int a=1;
	private Handler mHandler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			
			data.add(new Content("下拉刷新"+a++));
			mAdapter.notifyDataSetChanged();
			xRefreshView.stopRefresh();
		};
	};
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.activity_pull_down);
	
	xRefreshView=(XRefreshView) findViewById(R.id.xrefreshview);
	rv=(RecyclerView) findViewById(R.id.rv_pull_down);
	rv.setHasFixedSize(true);
	someData();
	mAdapter=new PullDownAdapter(data, this);
	rv.setLayoutManager(new LinearLayoutManager(this));
	rv.setAdapter(mAdapter);
	
	xRefreshView.setPinnedTime(1000);
	  xRefreshView.setMoveForHorizontal(true);
      xRefreshView.setPullLoadEnable(false);
      xRefreshView.setAutoLoadMore(false);
      mAdapter.setCustomLoadMoreView(new XRefreshViewFooter(this));
      xRefreshView.enableReleaseToLoadMore(true);
      xRefreshView.enableRecyclerViewPullUp(false);
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
			mHandler.sendEmptyMessageDelayed(10000,1000);
		}
		
		@Override
		@Deprecated
		public
		void onRefresh() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onLoadMore(boolean isSilence) {//上拉加载更多
			// TODO Auto-generated method stub
			
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
