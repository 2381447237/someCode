package com.youli.firstpage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youli.firstpage.R;
import com.youli.firstpage.adapter.MyFragmentPageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2017/7/14.
 */

public class BigFragmentOne extends Fragment{

    private List<Fragment> fragmentList=new ArrayList<Fragment>();
    private MyFragmentPageAdapter adapter;
    private ViewPager vp;
    private TabLayout tl;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment1,container,false);
        vp= (ViewPager) view.findViewById(R.id.vp);
        tl= (TabLayout) view.findViewById(R.id.tl);

         for(int i=1;i<20;i++){
             fragmentList.add(MoreFragment.newInstance(i));
         }
        FragmentManager fm=getChildFragmentManager();
        vp.setAdapter(new MyFragmentPageAdapter(fm,fragmentList));

        tl.setupWithViewPager(vp);

        for(int i=0;i<tl.getTabCount();i++){

            TabLayout.Tab tab=tl.getTabAt(i);
            tab.setCustomView(setTabView(i));
        }

        return view;
    }

    private View setTabView(int position){

        View view=LayoutInflater.from(getActivity()).inflate(R.layout.tab_item,null,false);
        ImageView iv= (ImageView) view.findViewById(R.id.tab_item_iv);
        TextView tv= (TextView) view.findViewById(R.id.tab_item_tv);
        iv.setImageResource(R.drawable.sel_image);
        tv.setText("Tab"+(position+1));
        return view;
    }

}
