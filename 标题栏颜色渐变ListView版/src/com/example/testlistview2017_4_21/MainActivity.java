package com.example.testlistview2017_4_21;

import java.util.ArrayList;
import java.util.List;

import com.example.testlistview2017_4_21.adapter.MyAdapter;
import com.example.testlistview2017_4_21.entity.Content;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView lv;
	private MyAdapter mAdapter;
	private List<Content> data=new ArrayList<Content>();
	private LinearLayout ll_header,ll_main;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        ll_main=(LinearLayout) findViewById(R.id.ll_main);
        ll_main.setBackgroundColor(Color.RED);
       // ll_main.getBackground().setAlpha(0xff);
        lv=(ListView) findViewById(R.id.lv);
        ll_header=(LinearLayout) LayoutInflater.from(this).inflate(R.layout.header, null,false);
        lv.addHeaderView(ll_header);
        
        for(int i=1;i<101;i++){
        	data.add(new Content("ÄÚÈÝ"+i));
        }
        
        mAdapter=new MyAdapter(data,this);
        lv.setAdapter(mAdapter);
        lv.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView arg0, int arg1) {
				
			}
			
			@Override
			public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
				if (getScrollY() <= 0) {
                    ll_main.getBackground().setAlpha(0);
                } else if (getScrollY() > 0 && getScrollY() <= lv.getChildAt(0).getHeight()-ll_main.getHeight()) {
                    float scale = (float) getScrollY() / lv.getChildAt(0).getHeight();
                    float alpha = (255 * scale);
                    ll_main.getBackground().setAlpha((int) alpha);
                } else {
                	ll_main.getBackground().setAlpha(255);
                }
			}
		});
    }
    
    public int getScrollY() {
        View c = lv.getChildAt(0);
        if (c == null) {
            return 0;
        }
        int firstVisiblePosition = lv.getFirstVisiblePosition();
        int top = c.getTop();
        return -top + firstVisiblePosition * c.getHeight();
    }
}
