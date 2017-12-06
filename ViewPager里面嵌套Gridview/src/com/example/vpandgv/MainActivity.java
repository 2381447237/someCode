package com.example.vpandgv;

import java.util.ArrayList;
import java.util.List;

import com.example.vpandgv.adapter.MyGridViewAdapter;
import com.example.vpandgv.adapter.MyViewPagerAdapter;
import com.example.vpandgv.entity.ProdctBean;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ViewPager viewPager;
	private LinearLayout group;//圆点指示器
	private List<View> viewPagerList=new ArrayList<View>();//GridView作为一个View对象添加到ViewPager集合中
	private String [] proName={"名称0","名称1","名称2","名称3","名称4","名称5",
            "名称6","名称7","名称8","名称9","名称10","名称11","名称12"};
	private List<ProdctBean> listDatas=new ArrayList<ProdctBean>();//总的数据源
	private int totalPage;//总的页数
	private int mPageSize=8;//每页显示的最大的数量
	private ImageView [] ivPoints;//小圆点图片的集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        viewPager=(ViewPager) findViewById(R.id.viewpager);
        group=(LinearLayout) findViewById(R.id.points);
        
        for(int i=0;i<proName.length;i++){
        	listDatas.add(new ProdctBean(proName[i],R.drawable.iv_driving));
        }
      //总的页数向上取整
        totalPage=(int) Math.ceil(listDatas.size()*1.0/mPageSize);
        
        for(int i=0;i<totalPage;i++){
        	//每个页面都是inflate出一个新实例
        	final GridView gridView=(GridView) View.inflate(this,R.layout.item_gridview,null);
        	gridView.setAdapter(new MyGridViewAdapter(this, listDatas,i, mPageSize));
        	//添加item点击监听
        	gridView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					
					Object obj=gridView.getItemAtPosition(position);
					
					if(obj!=null && obj instanceof ProdctBean){
						
						Toast.makeText(MainActivity.this, ((ProdctBean) obj).getName(),0).show();
						//Toast.makeText(MainActivity.this, "位置为"+position,0).show();
					}
					
				}
			});
        	//每一个GridView作为一个View对象添加到ViewPager集合中
        	viewPagerList.add(gridView);
        	
        }
      //设置ViewPager适配器
        viewPager.setAdapter(new MyViewPagerAdapter(viewPagerList));
        
        //添加小圆点
        ivPoints=new ImageView[totalPage];
        
        for(int i=0;i<totalPage;i++){
        	//循坏加入点点图片组
        	ivPoints[i]=new ImageView(this);
        	if(i==0){
        		ivPoints[i].setImageResource(R.drawable.page_focuese);
        	}else{
        		ivPoints[i].setImageResource(R.drawable.page_unfocused);
        	}
        	ivPoints[i].setPadding(8,8,8,8);
        	group.addView(ivPoints[i]);
        }
        
      //设置ViewPager的滑动监听，主要是设置点点的背景颜色的改变
        viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				
				for(int i=0;i<totalPage;i++){
					if(i==position){
						ivPoints[i].setImageResource(R.drawable.page_focuese);
					}else{
						ivPoints[i].setImageResource(R.drawable.page_unfocused);
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
    }
}
