package com.youli.firstpage.adapter;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.youli.firstpage.R;
import com.youli.firstpage.fragment.MoreFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2017/7/14.
 */
public class MyRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private int Header=1;
    private int Body=2;
    private int Footer=3;

    private List<String> data;

    private List<View> vpData;
    private Context context;
    private  MyViewPagerAdapter mvpAdapter;

    private boolean isPageSelected=false;

    private int numPageSelected;

    public MyRvAdapter(List<String> data, List<View> vpData,Context context) {
        this.data = data;
        this.vpData=vpData;
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater mInflater=LayoutInflater.from(context);

        if(viewType==Header){
            View view=mInflater.inflate(R.layout.rv_item_vp,parent,false);
            HeaderViewHolder viewHolder=new HeaderViewHolder(view);
            return  viewHolder;
        }else if(viewType==Body){

            View view=mInflater.inflate(R.layout.rv_item,parent,false);
            MyViewHolder viewHolder=new MyViewHolder(view);
            return viewHolder;
        }else if(viewType==Footer){

            View view=mInflater.inflate(R.layout.rv_item_footer,parent,false);
            FooterViewHolder viewHolder=new FooterViewHolder(view);
            return  viewHolder;
        }

        //return holder;

        return null;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof MyViewHolder) {

            ((MyViewHolder)holder).tv.setText("第" + data.get(position-1) + "个");
        }else if(holder instanceof HeaderViewHolder){

            if(mvpAdapter==null){
                mvpAdapter=new MyViewPagerAdapter();
                ((HeaderViewHolder)holder).vp.setAdapter(mvpAdapter);
            }

            LinearLayout.LayoutParams layoutParams=
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(50,0,50,0);
            ((HeaderViewHolder)holder).ll.removeAllViews();
            for(int i=0;i<vpData.size();i++){

                ImageView iv=new ImageView(context);

                if(!isPageSelected){
                    if(i==0){
                        iv.setImageResource(R.drawable.shape_point_selected);
                    }else {
                        iv.setImageResource(R.drawable.shape_point_unselected);
                    }
                }else{
                    if(i==numPageSelected){
                        iv.setImageResource(R.drawable.shape_point_selected);
                    }else {
                        iv.setImageResource(R.drawable.shape_point_unselected);
                    }
                }


                iv.setLayoutParams(layoutParams);
                ((HeaderViewHolder)holder).ll.addView(iv);
            }

            ((HeaderViewHolder)holder).vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    isPageSelected=true;
                    numPageSelected=position;
                    ((HeaderViewHolder)holder).ll.removeAllViews();

                    LinearLayout.LayoutParams layoutParams=
                            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(50,0,50,0);

                    for(int i=0;i<vpData.size();i++){

                        ImageView iv=new ImageView(context);
                        if(i==position){
                            iv.setImageResource(R.drawable.shape_point_selected);
                        }else {
                            iv.setImageResource(R.drawable.shape_point_unselected);
                        }
                        iv.setLayoutParams(layoutParams);
                        ((HeaderViewHolder)holder).ll.addView(iv);
                    }


                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });


        }else if(holder instanceof FooterViewHolder){

        }
    }

    @Override
    public int getItemCount() {

        return data.size()+2;
    }

    @Override
    public int getItemViewType(int position) {

        if(position==0){
            return Header;
        }else if(position==(data.size()+1)){
            return Footer;
        }else{
            return Body;
        }


    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.rv_item_tv);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{

        private ViewPager vp;

        private LinearLayout ll;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            vp= (ViewPager) itemView.findViewById(R.id.rv_item_vp);
            ll= (LinearLayout) itemView.findViewById(R.id.rv_item_ll);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder{

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class MyViewPagerAdapter extends PagerAdapter {


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

//                ViewPager vp= (ViewPager) container;
//                vp.removeView(vpData.get(position));
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//                ViewPager vp= (ViewPager) container;
//                vp.addView(vpData.get(position),0);
//                return vpData.get(position);
            container.addView(vpData.get(position));
            return vpData.get(position);
        }
    }

}
