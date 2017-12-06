package com.example.testcustomview2017_4_11;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class CustomTitleView extends View{

	private String mTitleText;
	private int mTitleTextColor;
	private int mTitleTextSize;
	
	private Rect mBound;
	private Paint mPaint;
	
	public CustomTitleView(Context context) {
		this(context, null);
		
	}
	public CustomTitleView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
		
	}
	//默认的布局文件调用的是两个参数的构造方法，所以记得让所有的构造调用我们的三个参数的构造，我们在三个参数的构造中获得自定义属性
	public CustomTitleView(final Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		TypedArray a=context.getTheme().
				obtainStyledAttributes(attrs,R.styleable.CustomTitleView, defStyleAttr,0);
		int n=a.getIndexCount();
		for(int i=0;i<n;i++){
			
			int attr=a.getIndex(i);
			switch (attr) {
			case R.styleable.CustomTitleView_titleText:
				mTitleText=a.getString(attr);
				break;
			case R.styleable.CustomTitleView_titleTextColor:
				mTitleTextColor=a.getColor(attr, Color.BLACK);
				break;
			case R.styleable.CustomTitleView_titleTextSize:
				mTitleTextSize=a.getDimensionPixelSize(attr, 16);
				break;
			default:
				break;
			}
			
		}
		a.recycle();
		mPaint=new Paint();
		mPaint.setTextSize(mTitleTextSize);
		mBound=new Rect();
		mPaint.getTextBounds(mTitleText,0,mTitleText.length(), mBound);
		
		this.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mTitleText=randomText(context);
				postInvalidate();
			}
		});
		
	}
	
//	当我们设置明确的宽度和高度时，系统帮我们测量的结果就是我们设置的结果，当我们设置为WRAP_CONTENT,或者MATCH_PARENT系统帮我们测量的结果就是MATCH_PARENT的长度。
//	所以，当设置了WRAP_CONTENT时，我们需要自己进行测量，即重写onMesure方法”：
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		MeasureSpec的specMode,一共三种类型：
//		EXACTLY：一般是设置了明确的值或者是MATCH_PARENT
//		AT_MOST：表示子布局限制在一个最大值内，一般为WARP_CONTENT
//		UNSPECIFIED：表示子布局想要多大就多大，很少使用
		
		int widthMode=MeasureSpec.getMode(widthMeasureSpec);
		int widthSize=MeasureSpec.getSize(widthMeasureSpec);
		int heightMode=MeasureSpec.getMode(heightMeasureSpec);
		int heightSize=MeasureSpec.getSize(heightMeasureSpec);
		
		int width,height;
		if(widthMode==MeasureSpec.EXACTLY){
			width=widthSize;
		}else{
			mPaint.setTextSize(mTitleTextSize);
			mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);
			float textWidth=mBound.width();
			int desired=(int) (getPaddingLeft()+textWidth+getPaddingRight());
			width=desired;
		}
		
		if(heightMode==MeasureSpec.EXACTLY){
			height=heightSize;
		}else{
			mPaint.setTextSize(mTitleTextSize);
			mPaint.getTextBounds(mTitleText, 0,mTitleText.length(),mBound);
			float textHeight = mBound.height();  
	        int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());  
	        height = desired; 
		}
		
		setMeasuredDimension(width, height);
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		
		super.onDraw(canvas);
		mPaint.setColor(Color.YELLOW);
		canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(), mPaint);
		
		mPaint.setColor(Color.RED);
		canvas.drawText(mTitleText, getWidth()/2-mBound.width()/2,getHeight()/2+mBound.height()/2, mPaint);
	}
	
	private String randomText(Context context){
		
		Random random=new Random();
		Set<Integer> set=new HashSet<Integer>();
		while(set.size()<4){
			int randomInt=random.nextInt(10);
			set.add(randomInt);
		}
		StringBuffer sb=new StringBuffer();
		for(Integer i:set){
			
			sb.append(""+i);
			
		}
		
		Toast.makeText(context, "数字是:"+sb, 0).show();
		
		return sb.toString();
		
	}
	
}
