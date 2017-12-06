package com.example.honglvdeng;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class HongLvDengView extends View{
	
	private Paint mPaint;
	
	public HongLvDengView(Context context) {
		this(context,null);
	}

	public HongLvDengView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	    mPaint=new Paint();
	    mPaint.setColor(Color.RED);
	    mPaint.setStyle(Paint.Style.FILL);
	    mPaint.setAntiAlias(true);
	}


	@SuppressLint("DrawAllocation") @Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		canvas.drawCircle(200,200,20, mPaint);
		
		mPaint.setColor(Color.YELLOW);
		canvas.drawCircle(250,200,20, mPaint);
		
		mPaint.setColor(Color.GREEN);
		canvas.drawCircle(300,200,20, mPaint);
		
		mPaint.setColor(Color.BLACK);
		canvas.drawLines(new float[]{190,170,310,170,190,230,310,230}, mPaint);
		
		RectF rectF=new RectF(160,170,220,230);
		mPaint.setStyle(Paint.Style.STROKE);
		canvas.drawArc(rectF, 90,180,false, mPaint);
		
		RectF rectF2=new RectF(280,170,340,230);
	
		canvas.drawArc(rectF2, -90,180,false, mPaint);
	}
	
}
