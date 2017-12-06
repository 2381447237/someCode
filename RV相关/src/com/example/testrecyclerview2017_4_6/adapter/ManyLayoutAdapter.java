package com.example.testrecyclerview2017_4_6.adapter;

import java.util.List;

import com.example.testrecyclerview2017_4_6.R;
import com.example.testrecyclerview2017_4_6.entity.ManyLayoutContent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ManyLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

	private int ONE_ITEM = 1;
    private int TWO_ITEM = 2;
    private int THREE_ITEM=3;
   
	class OneViewHolder extends ViewHolder{

		TextView tv;
		
		public OneViewHolder(View arg0) {
			super(arg0);
			tv=(TextView) arg0.findViewById(R.id.tv_manylayout_one);
		}
		
	}

	class TwoViewHolder extends ViewHolder{
		TextView tv1,tv2;
		
		public TwoViewHolder(View arg0) {
			super(arg0);
			tv1=(TextView) arg0.findViewById(R.id.tv_manylayout_two);
			tv2=(TextView) arg0.findViewById(R.id.tv_manylayout_two2);
		}

		
	}
	
	class ThreeViewHolder extends ViewHolder{

		TextView tv1,tv2,tv3;
		
		public ThreeViewHolder(View arg0) {
			super(arg0);
			tv1=(TextView) arg0.findViewById(R.id.tv_manylayout_three1);
			tv2=(TextView) arg0.findViewById(R.id.tv_manylayout_three2);
			tv3=(TextView) arg0.findViewById(R.id.tv_manylayout_three3);
		}
			
	}
	
	private List<ManyLayoutContent> data;
	private Context context;
	
	public ManyLayoutAdapter(List<ManyLayoutContent> data, Context context) {
		super();
		this.data = data;
		this.context = context;
	}

	@Override
	public int getItemCount() {
		
		return data.size();
	}

	@Override
	public int getItemViewType(int position) {
	
//		if(position%3==0){
//			return ONE_ITEM;
//		}else if(position%3==1){
//			return TWO_ITEM;
//		}else {
//			return THREE_ITEM;
//		}
		
		switch (position%3) {
		case 0:
			return ONE_ITEM;

        case 1:
	        return TWO_ITEM;
			
        case 2:
	       return THREE_ITEM;
	
		default:
			break;
		}
		return 0;
	}
	
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		
		LayoutInflater mInflater=LayoutInflater.from(context);
		
		RecyclerView.ViewHolder holder=null;
		
		if(ONE_ITEM==viewType){
			
			holder=new OneViewHolder(mInflater.inflate(R.layout.item_manylayout_one,parent,false));
			
		}else if(TWO_ITEM==viewType){
			
			holder=new TwoViewHolder(mInflater.inflate(R.layout.item_manylayout_two,parent,false));
			
		}else if(THREE_ITEM==viewType){
			
			holder=new ThreeViewHolder(mInflater.inflate(R.layout.item_manylayout_three,parent,false));
			
		}
		
		return holder;
	}
	
	@Override
	public void onBindViewHolder(ViewHolder arg0, final int position) {
	
		if(arg0 instanceof OneViewHolder){
			
			
			((OneViewHolder) arg0).tv.setText(data.get(position).getTv());
			
		}else if(arg0 instanceof TwoViewHolder){
			
			((TwoViewHolder) arg0).tv1.setText(data.get(position).getTv());
			
			((TwoViewHolder) arg0).tv2.setText(data.get(position).getTv());
			

		
		}else if(arg0 instanceof ThreeViewHolder){
			((ThreeViewHolder) arg0).tv1.setText(data.get(position).getTv());
			((ThreeViewHolder) arg0).tv2.setText(data.get(position).getTv());
			((ThreeViewHolder) arg0).tv3.setText(data.get(position).getTv());
		}
			
			}
		
}
