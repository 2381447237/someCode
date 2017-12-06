package com.example.liutao.vlayouttest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liutao on 2017/5/27.
 */

public class MyAdapter extends DelegateAdapter.Adapter<MyAdapter.MainViewHolder>{

    private List<Content> data;
    private Context context;
    private LayoutHelper layoutHelper;
    private RecyclerView.LayoutParams layoutParams;
    private int count=0;

    private MyItemClickListener myItemClickListener;

    public MyAdapter(Context context, LayoutHelper layoutHelper, int count, List<Content> data) {
        this(context, layoutHelper, count, new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300), data);
    }

    public MyAdapter(Context context, LayoutHelper layoutHelper, int count, RecyclerView.LayoutParams layoutParams, List<Content> data) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.count = count;
        this.layoutParams = layoutParams;
        this.data = data;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {

        holder.Text.setText(""+data.get(position).getTv());
        holder.image.setImageResource(data.get(position).getIv());
    }

    @Override
    public int getItemCount() {
        return count;
    }

    public void setOnItemClickListener(MyItemClickListener listener){
        myItemClickListener=listener;
    }

    class MainViewHolder extends RecyclerView.ViewHolder{

        TextView Text;
        ImageView image;

        public MainViewHolder(View itemView) {
            super(itemView);

            Text= (TextView) itemView.findViewById(R.id.Item);
            image= (ImageView) itemView.findViewById(R.id.Image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(myItemClickListener!=null){
                        myItemClickListener.onItemClick(v,getPosition());
                    }
                }
            });
        }

        public TextView getText(){
            return  Text;
        }

    }

}
