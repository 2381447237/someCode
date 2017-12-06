package com.youli.firstpage.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.youli.firstpage.R;
import com.youli.firstpage.adapter.MyRvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2017/7/14.
 */

public class MoreFragment extends Fragment{

    private TextView tv;
    private int tabIndex;
    public static final String INTENT_INT_INDEX="index";
    private RecyclerView  rv;
    private MyRvAdapter adapter;
    private List<String> data=new ArrayList<>();
    private List<View> vpData=new ArrayList<>();
    private String colors[]={"#ff0000","#00ff00","#0000ff"};

    public static MoreFragment newInstance(int tabIndex){

        Bundle args=new Bundle();
        args.putInt(INTENT_INT_INDEX,tabIndex);
        MoreFragment fragment=new MoreFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        tabIndex=getArguments().getInt(INTENT_INT_INDEX);

        View view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_more,container,false);

        tv= (TextView) view.findViewById(R.id.fragment_more_tv);

        rv= (RecyclerView) view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        for(int i=1;i<50;i++){
            data.add(i+"");
        }

        for(int i=0;i<colors.length;i++){

            ImageView imageView=new ImageView(getActivity());
            imageView.setBackgroundColor(Color.parseColor(colors[i]));
            vpData.add(imageView);

        }

        adapter=new MyRvAdapter(data,vpData,getActivity());

        rv.setAdapter(adapter);
        getData(tabIndex);

        return view;
    }

    private void getData(int index){

               if(index==1){
                   //RecyclerView
                  tv.setVisibility(View.GONE);
                   rv.setVisibility(View.VISIBLE);
               }else {
                   rv.setVisibility(View.GONE);
                   tv.setVisibility(View.VISIBLE);
                   tv.setText("我是fragment" + index);
               }

    }





}
