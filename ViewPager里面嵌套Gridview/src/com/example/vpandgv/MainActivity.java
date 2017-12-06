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
	private LinearLayout group;//Բ��ָʾ��
	private List<View> viewPagerList=new ArrayList<View>();//GridView��Ϊһ��View������ӵ�ViewPager������
	private String [] proName={"����0","����1","����2","����3","����4","����5",
            "����6","����7","����8","����9","����10","����11","����12"};
	private List<ProdctBean> listDatas=new ArrayList<ProdctBean>();//�ܵ�����Դ
	private int totalPage;//�ܵ�ҳ��
	private int mPageSize=8;//ÿҳ��ʾ����������
	private ImageView [] ivPoints;//СԲ��ͼƬ�ļ���
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        viewPager=(ViewPager) findViewById(R.id.viewpager);
        group=(LinearLayout) findViewById(R.id.points);
        
        for(int i=0;i<proName.length;i++){
        	listDatas.add(new ProdctBean(proName[i],R.drawable.iv_driving));
        }
      //�ܵ�ҳ������ȡ��
        totalPage=(int) Math.ceil(listDatas.size()*1.0/mPageSize);
        
        for(int i=0;i<totalPage;i++){
        	//ÿ��ҳ�涼��inflate��һ����ʵ��
        	final GridView gridView=(GridView) View.inflate(this,R.layout.item_gridview,null);
        	gridView.setAdapter(new MyGridViewAdapter(this, listDatas,i, mPageSize));
        	//���item�������
        	gridView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					
					Object obj=gridView.getItemAtPosition(position);
					
					if(obj!=null && obj instanceof ProdctBean){
						
						Toast.makeText(MainActivity.this, ((ProdctBean) obj).getName(),0).show();
						//Toast.makeText(MainActivity.this, "λ��Ϊ"+position,0).show();
					}
					
				}
			});
        	//ÿһ��GridView��Ϊһ��View������ӵ�ViewPager������
        	viewPagerList.add(gridView);
        	
        }
      //����ViewPager������
        viewPager.setAdapter(new MyViewPagerAdapter(viewPagerList));
        
        //���СԲ��
        ivPoints=new ImageView[totalPage];
        
        for(int i=0;i<totalPage;i++){
        	//ѭ��������ͼƬ��
        	ivPoints[i]=new ImageView(this);
        	if(i==0){
        		ivPoints[i].setImageResource(R.drawable.page_focuese);
        	}else{
        		ivPoints[i].setImageResource(R.drawable.page_unfocused);
        	}
        	ivPoints[i].setPadding(8,8,8,8);
        	group.addView(ivPoints[i]);
        }
        
      //����ViewPager�Ļ�����������Ҫ�����õ��ı�����ɫ�ĸı�
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
