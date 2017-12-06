package com.example.testcustomview2017_4_173;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View{

	private Paint mPaint;
	private float mRadius,xLine,yLine;
	private int mProgress;
	private int mWidth,mHeight;
	private RectF mRectF;
	private boolean isDrawDone = false;
	public StopCustomViewListener myStopCustomViewListener;
	public CustomView(Context context) {
		this(context,null);
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}
	
	public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mPaint=new Paint();
		mPaint.setAntiAlias(true);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		
		int widthSize=MeasureSpec.getSize(widthMeasureSpec);
		int heightSize=MeasureSpec.getSize(heightMeasureSpec);
		
		int widthMode=MeasureSpec.getMode(widthMeasureSpec);
		int heightMode=MeasureSpec.getMode(heightMeasureSpec);
		
		if(widthMode==MeasureSpec.EXACTLY){
			mWidth=widthSize;
		}else if(widthMode==MeasureSpec.AT_MOST){
			mWidth=(int) (widthSize*0.8);
		}
		
		if(heightMode==MeasureSpec.EXACTLY){
			mHeight=heightSize;
		}else if(heightMode==MeasureSpec.AT_MOST){
			mHeight=(int) (heightSize*0.8);
		}
		
		setMeasuredDimension(mWidth, mHeight);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		mPaint.setColor(Color.RED);
		mPaint.setStrokeWidth(10f);
		mPaint.setStyle(Paint.Style.STROKE);
		mRadius=Math.min(mWidth/3, mHeight/3);

		mRectF=new RectF(mWidth/2-mRadius, mHeight/2-mRadius,mWidth/2+mRadius, mHeight/2+mRadius);
		
		
		
		
		canvas.drawArc(mRectF, 180,360*mProgress/100,false, mPaint);
		mProgress+=5;
		if(mProgress>100){
		canvas.drawLine(mWidth/2-xLine, mHeight/2-xLine,mWidth/2+xLine, mHeight/2+xLine, mPaint);
		xLine+=2;
		if(xLine>=mRadius/2){
		canvas.drawLine(mWidth/2-yLine, mHeight/2+yLine,mWidth/2+yLine, mHeight/2-yLine, mPaint);
		yLine+=2;
		}
		}
		if(xLine>mRadius/2){
			xLine=mRadius/2;
		}
		if(yLine>mRadius/2){
			yLine=mRadius/2;	
		}
		
		if(yLine==mRadius/2){
			if(!isDrawDone){
       if(myStopCustomViewListener!=null){
			
				myStopCustomViewListener.StopCustomView(this);
			}
       isDrawDone = true;

		
		}
		
		}
			
		postInvalidateDelayed(10);
		//super.onDraw(canvas);
	}
	
	
	public void  ClearData(){
		mProgress=0;
		xLine=0;
		yLine=0;
		isDrawDone = false;
		invalidate();
	}
   

public interface StopCustomViewListener {
	   
	   void StopCustomView(View v);
	   
   }


public void setStopCustomViewListener(
		StopCustomViewListener mStopCustomViewListener) {
	myStopCustomViewListener = mStopCustomViewListener;
}
	
   
   
}
