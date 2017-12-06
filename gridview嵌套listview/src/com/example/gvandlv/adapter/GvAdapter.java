package com.example.gvandlv.adapter;

import java.util.List;

import com.example.gvandlv.MyListView;
import com.example.gvandlv.R;
import com.example.gvandlv.entity.GvContent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GvAdapter extends BaseAdapter{

	private List<GvContent> data;
	private Context context;
	private LayoutInflater inflater;
	private LvAdapter adapter;
	
	
	public GvAdapter(List<GvContent> data, Context context) {
		super();
		this.data = data;
		this.context = context;
		inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup arg2) {
		
		ViewHolder vh;
		
		if(convertView==null){
			
			vh=new ViewHolder();
			
			convertView=inflater.inflate(R.layout.item_gv,arg2, false);
			
			vh.lv=(MyListView)convertView.findViewById(R.id.item_lv);
			
			vh.tv=(TextView) convertView.findViewById(R.id.item_tv);
			
			
			
			convertView.setTag(vh);
		}else{
			
			vh=(ViewHolder) convertView.getTag();
			
		}
		adapter=new LvAdapter(data.get(position).getLv(), context);
		final GvContent gc=data.get(position);
		
		vh.lv.setAdapter(adapter);
		
		vh.lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(context,"内容点击"+gc.getLv().get(arg2).getLv_tv(),0).show();
			}
		});
		
		vh.tv.setText(gc.getTv());
		vh.tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(context,"标题点击"+gc.getTv(),0).show();
				
			}
		});
		return convertView;
	}

	class ViewHolder{
		
		MyListView lv;
		TextView tv;
	}
	
}
