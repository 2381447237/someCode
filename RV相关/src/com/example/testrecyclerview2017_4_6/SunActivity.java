package com.example.testrecyclerview2017_4_6;
import com.example.materialrefreshlayout.view.MaterialRefreshLayout;
import com.example.materialrefreshlayout.view.MaterialRefreshListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SunActivity extends Activity{

	private MaterialRefreshLayout materialRefreshLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_listview);
		String[] array=new String[20];
		for(int i=0;i<array.length;i++){
			array[i]="拜仁慕尼黑"+i;
		}
		
		ListView listView=(ListView) findViewById(R.id.lv);
		listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array));
		materialRefreshLayout=(MaterialRefreshLayout) findViewById(R.id.refresh);
		materialRefreshLayout.setSunStyle(true);
		materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
			
			@Override
			public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
				materialRefreshLayout.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						materialRefreshLayout.finishRefresh();
					}
				},3000);
			}
			
			@Override
			public void onfinish() {
				super.onfinish();
				Toast.makeText(SunActivity.this,"刷新完成",0).show();
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
//						Toast.makeText(SunActivity.this,"sun加载更多完成",0).show();
//					}
//				},3000);
//			}
		});
	}
	
}
