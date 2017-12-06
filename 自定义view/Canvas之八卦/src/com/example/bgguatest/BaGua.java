package com.example.bgguatest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class BaGua extends View{

	private Paint mPaint;
	
	public BaGua(Context context) {
		this(context,null);
	}
	
	public BaGua(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mPaint=new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.FILL);
	}

@Override
protected void onDraw(Canvas canvas) {
	super.onDraw(canvas);
	
	canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);
	//画八卦
	RectF rect=new RectF(-200,-200,200,200);
	canvas.drawArc(rect, -90,180,true, mPaint);
	mPaint.setColor(Color.WHITE);
	canvas.drawArc(rect, 90,180,true, mPaint);
	mPaint.setColor(Color.BLACK);
	canvas.drawCircle(0,-100,100, mPaint);
	mPaint.setColor(Color.WHITE);
	canvas.drawCircle(0,100,100, mPaint);
	canvas.drawCircle(0, -100,10, mPaint);
	mPaint.setColor(Color.BLACK);
	canvas.drawCircle(0, 100,10, mPaint);
	
	//画香蕉
//	mPaint.setColor(Color.YELLOW);
//	RectF rect=new RectF(-60,-120,160,120);
//	canvas.drawOval(rect, mPaint);
//	//canvas.drawArc(rect,135,90,true, mPaint);
//	mPaint.setColor(Color.WHITE);
//	canvas.drawCircle(0, 0,120, mPaint);
//	mPaint.setColor(Color.YELLOW);
//	mPaint.setStrokeWidth(2f);
//	canvas.drawRect(-5,-150,25,-90, mPaint);
	
	//画愛心
//	mPaint.setColor(Color.RED);
//	RectF rect=new RectF(-100,-50,0,50);
//	canvas.drawArc(rect, 180,180,true, mPaint);
//	RectF rect2=new RectF(0,-50,100,50);
//	canvas.drawArc(rect2, 180,180,true, mPaint);
//	 Path path = new Path();
//     path.moveTo(-100, 0);// 此点为多边形的起点
//     path.lineTo(0, 120);
//     path.lineTo(100, 0);
//     path.close(); // 使这些点构成封闭的多边形
//     canvas.drawPath(path, mPaint);

}
	
}
