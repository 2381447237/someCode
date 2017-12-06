package com.example.testcustomview2017_4_242;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View{

	private Paint mPaint;
	private Bitmap mBitmap;
	private Options mOpts;
	private RectF mRectF;
	private int a;
	
	private Handler mHandler=new Handler(){
		
		public void handleMessage(android.os.Message msg) {
			
			a+=10;
			invalidate();
			
		};
		
	};
	
	public CustomView(Context context) {
		this(context,null);
	}
	
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mPaint=new Paint();
		mOpts=new BitmapFactory.Options();
		mOpts.inSampleSize=4;
		mBitmap=BitmapFactory.decodeResource(getResources(),R.drawable.tangyan,mOpts);
		mRectF=new RectF();
	}


	@Override
	protected void onDraw(Canvas canvas) {
		
		
		
		mPaint.setColor(Color.WHITE);
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.STROKE);
		canvas.drawCircle(getWidth()/2,getHeight()/2,50, mPaint);
		canvas.drawCircle(getWidth()/2,getHeight()/2,150, mPaint);
		canvas.drawCircle(getWidth()/2,getHeight()/2,250, mPaint);
		canvas.drawCircle(getWidth()/2,getHeight()/2,350, mPaint);
		
		mPaint.setColor(Color.GREEN);
		mRectF.set(getWidth()/2-350,getHeight()/2-350, getWidth()/2+350,getHeight()/2+350);
		mPaint.setStyle(Paint.Style.FILL);
		
		canvas.rotate(a,getWidth()/2,getHeight()/2);
		for(int i=1;i<361;i++){
		
			
			mPaint.setAlpha((int)(255*i/360));
			canvas.drawArc(mRectF,361-i,1,true, mPaint);
		
		}
		
		canvas.rotate(-a,getWidth()/2,getHeight()/2);
		mPaint.setAlpha(255);
		canvas.drawBitmap(mBitmap, getWidth()/2-mBitmap.getWidth()/2,getHeight()/2-mBitmap.getHeight()/2, mPaint);
		
		mHandler.sendEmptyMessageDelayed(100, 5);
	}
	
}
