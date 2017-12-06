package com.example.testcustomview2017_4_242;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class MyRadarView extends View{

	private Paint mPaintNormal;//绘制普通圆圈
	private Paint mPaintCircle;//绘制动的圆圈
	private int screenWidth,screenHeight;
	private Matrix mMatrix;
	private Handler mHandler=new Handler();
	private int start;
	
	private Runnable run=new Runnable() {
		
		@Override
		public void run() {
			
			start+=4;
			mMatrix=new Matrix();
			mMatrix.postRotate(start,getWidth()/2,getHeight()/2);
			invalidate();
			mHandler.postDelayed(run, 50);
			
		}
	};
	
	public MyRadarView(Context context) {
		this(context,null);
	}
	
	public MyRadarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		 mPaintNormal = new Paint();  
	        mPaintNormal.setAntiAlias(true);  
	        mPaintNormal.setStrokeWidth(3);  
	        mPaintNormal.setColor(Color.parseColor("#a1a1a1"));  
	        mPaintNormal.setStyle(Paint.Style.STROKE);  
	  
	        mPaintCircle = new Paint();  
	        mPaintCircle.setAntiAlias(true);  
	        mPaintCircle.setColor(Color.parseColor("#AAAAAAAA"));  
	        
	        screenWidth=context.getResources().getDisplayMetrics().widthPixels;
	        screenHeight=context.getResources().getDisplayMetrics().heightPixels;
	        
	        mHandler.post(run);
	}

    
	@Override
	protected void onDraw(Canvas canvas) {
		
		canvas.drawCircle(getWidth()/2,getHeight()/2,50,mPaintNormal);
		canvas.drawCircle(getWidth()/2,getHeight()/2,150,mPaintNormal);
		canvas.drawCircle(getWidth()/2,getHeight()/2,250,mPaintNormal);
		canvas.drawCircle(getWidth()/2,getHeight()/2,350,mPaintNormal);
		
		Shader shader=new SweepGradient(getWidth()/2,getHeight()/2, Color.TRANSPARENT,Color.parseColor("#AA00ff00"));
		mPaintCircle.setShader(shader);
		canvas.concat(mMatrix);
		canvas.drawCircle(getWidth()/2,getHeight()/2,350, mPaintCircle); 
		
		
		
	}
	
}
