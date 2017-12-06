package com.example.vpandgv.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class MyViewPagerAdapter extends PagerAdapter{

	private List<View> viewList;

	public MyViewPagerAdapter(List<View> viewList) {
		super();
		this.viewList = viewList;
	}

	@Override
	public int getCount() {
		
		return viewList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		
		ViewPager vp=(ViewPager) container;
		
		vp.addView(viewList.get(position),0);
		
		return viewList.get(position);
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
	
		ViewPager vp=(ViewPager) container;
		
		vp.removeView(viewList.get(position));
		
	}
	
}
