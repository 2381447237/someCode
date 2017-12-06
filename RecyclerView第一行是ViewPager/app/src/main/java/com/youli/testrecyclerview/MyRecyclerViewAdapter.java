package com.youli.testrecyclerview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by liutao on 2017/7/17.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<String> data;
    private Context context;
    private List<View> vpData;
    private int HEADER=1;
    private int BODY=2;
    private int FOOTER=3;

    private MyViewPagerAdapter mvpAdapter;

    private LinearLayout ll;

    public MyRecyclerViewAdapter(List<String> data,Context context,List<View> vpData){

        this.data=data;
        this.context=context;
        this.vpData=vpData;
    }

    @Override
    public int getItemViewType(int position) {

        if(position==0){
            return  HEADER;
        }else if(position==(data.size()+1)){
            return FOOTER;
        }

        return BODY;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater mInflater=LayoutInflater.from(context);

        RecyclerView.ViewHolder vh=null;

        if(viewType==HEADER){

            vh=new HeaderViewHolder(mInflater.inflate(R.layout.item_vp,parent,false));

        }else if(viewType==BODY){

            vh=new MyRvViewHolder(mInflater.inflate(R.layout.item,parent,false));

        }else if(viewType==FOOTER){

            vh=new FooterViewHolder(mInflater.inflate(R.layout.item_footer,parent,false));

        }

        return vh;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

       // holder.tv.setText("第"+data.get(position)+"条数据");

        if(holder instanceof HeaderViewHolder){

            if(mvpAdapter==null) {

                mvpAdapter=new MyViewPagerAdapter();
                ((HeaderViewHolder) holder).vp.setAdapter(mvpAdapter);

                LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.setMargins(50,0,50,0);

                for(int i=0;i<3;i++){

                    ImageView point=new ImageView(context);
                    if(i==0){
                        point.setImageResource(R.drawable.shape_point_selected);
                    }else {
                        point.setImageResource(R.drawable.shape_point_unselected);
                    }
                    point.setLayoutParams(lp);
                    ((HeaderViewHolder)holder).ll.addView(point);
                }

            }

            ((HeaderViewHolder)holder).vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    ((HeaderViewHolder)holder).ll.removeAllViews();

                    LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    lp.setMargins(50,0,50,0);

                    for(int i=0;i<3;i++){
                        ImageView point=new ImageView(context);
                        if(i==position){
                            point.setImageResource(R.drawable.shape_point_selected);
                        }else {
                            point.setImageResource(R.drawable.shape_point_unselected);
                        }
                        point.setLayoutParams(lp);
                        ((HeaderViewHolder)holder).ll.addView(point);
                    }

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

        }else if(holder instanceof MyRvViewHolder){

            ((MyRvViewHolder)holder).tv.setText("第"+data.get(position-1)+"条数据");

        }

    }


    @Override
    public int getItemCount() {
        return data.size()+2;
    }

    class MyRvViewHolder extends RecyclerView.ViewHolder{

        TextView tv;

        public MyRvViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.item_tv);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{

        ViewPager vp;

        LinearLayout ll;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            vp= (ViewPager) itemView.findViewById(R.id.item_vp);
            ll= (LinearLayout) itemView.findViewById(R.id.item_ll);
        }
    }

    class  FooterViewHolder extends RecyclerView.ViewHolder{


        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    class MyViewPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return vpData.size();
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ViewPager vp= (ViewPager) container;
            vp.removeView(vpData.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ViewPager vp= (ViewPager) container;
            vp.addView(vpData.get(position),0);

            return vpData.get(position);
        }
    }

}
