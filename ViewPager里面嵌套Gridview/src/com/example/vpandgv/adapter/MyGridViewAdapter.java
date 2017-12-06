package com.example.vpandgv.adapter;

import java.util.List;

import com.example.vpandgv.R;
import com.example.vpandgv.entity.ProdctBean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyGridViewAdapter extends BaseAdapter{

	private Context context;
	private List<ProdctBean> lists;//����Դ
	private int mIndex;// ҳ���±꣬��ʾ�ڼ�ҳ����0��ʼ
	private int mPargerSize;//ÿҳ��ʾ����������
	
	public MyGridViewAdapter(Context context, List<ProdctBean> lists,
			int mIndex, int mPargerSize) {
		super();
		this.context = context;
		this.lists = lists;
		this.mIndex = mIndex;
		this.mPargerSize = mPargerSize;
	}

	
	/**
	 * ���ж����ݼ��Ĵ�С�Ƿ���ʾ����ҳlists.size() > (mIndex + 1)*mPagerSize
	 * ������㣬���ҳ����ʾ�������lists�ĸ���
	 * ���������ʾÿҳ�������������ôʣ�¼�������ʾ����
	 */
	@Override
	public int getCount() {
		return lists.size()>(mIndex+1)*mPargerSize?mPargerSize:(lists.size()-mIndex*mPargerSize);
	}

	@Override
	public Object getItem(int arg0) {
		return lists.get(arg0+mIndex*mPargerSize);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0+mIndex*mPargerSize;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;
		
		if(convertView==null){
			
			holder=new ViewHolder();
			convertView=View.inflate(context, R.layout.item_view,null);
			holder.tv_name=(TextView) convertView.findViewById(R.id.item_name);
			holder.iv_nul=(ImageView) convertView.findViewById(R.id.item_image);
			convertView.setTag(holder);
			
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		
		//����ȷ��position��Ϊ�õ�����������Դ������Դ�Ƿ�ҳ���ص�ÿҳ��GridView�ϵ�
		int pos=position+mIndex*mPargerSize;
		//����mPagerSize=8�����������ǵڶ�ҳ����mIndex=1���ϵĵڶ���λ��item(position=1),��ô���item��ʵ��λ�þ���pos=9
		holder.tv_name.setText(lists.get(pos).getName());
		holder.iv_nul.setImageResource(lists.get(pos).getUrl());
		
		return convertView;
	}

	class ViewHolder{
		
		TextView tv_name;
		ImageView iv_nul;
		
	}
	
}
