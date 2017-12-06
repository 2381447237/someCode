package com.example.viewpager2016_1_7;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ViewPager vp;
	private List<View> data=new ArrayList<View>();
	private ImageView iv,iv2;//iv代表小圆点,iv2代表viewPager的图片
	private int iv_id []={R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5};
	private int Images []={R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l};
	
	private MyAdapter mAdapter;
	
	private final int AUTO_MSG=1;
	//private final int HANDLE_MSG=AUTO_MSG+1;
	private static final int PHOTO_CHANGE_TIME=2000;
	private int index=0;
	//Handler导包为android.os.Handler
	private Handler mHandler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case AUTO_MSG:
				if(index==Images.length){
					index=0;
				}
				vp.setCurrentItem(index++);//收到消息后设置当前要显示的图片
			
				mHandler.sendEmptyMessageDelayed(AUTO_MSG,2000);//2000毫秒
				
				break;

			/*case HANDLE_MSG:
				mHandler.sendEmptyMessageDelayed(AUTO_MSG, 2000);
				break;*/
			default:
				break;
			}
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		vp=(ViewPager) findViewById(R.id.vp);
		
		for(int i=0;i<Images.length;i++){
			iv2=new ImageView(this);
			iv2.setImageResource(Images[i]);
			data.add(iv2);
		}
		
		mAdapter=new MyAdapter();
		vp.setAdapter(mAdapter);
		vp.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				iv=(ImageView) MainActivity.this.findViewById(iv_id[arg0]);
				iv.setImageResource(R.drawable.go_next);
				
				for(int i=0;i<iv_id.length;i++){
					if(i!=arg0){
					iv=(ImageView) MainActivity.this.findViewById(iv_id[i]);
					iv.setImageResource(R.drawable.next_null);
					}
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
		
		mHandler.sendEmptyMessageDelayed(AUTO_MSG,2000);
		
	}

	private class MyAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return data.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			ViewPager vp=(ViewPager) container;
			vp.removeView(data.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, final int position) {
			View v=data.get(position);
			v.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					int i=position+1;
					Toast.makeText(MainActivity.this,"这是第"+i+"张图片",Toast.LENGTH_SHORT).show();
				}
			});
			ViewPager vp=(ViewPager) container;
			vp.addView(data.get(position),0);
			return data.get(position);
		}
		
	}
	
}
