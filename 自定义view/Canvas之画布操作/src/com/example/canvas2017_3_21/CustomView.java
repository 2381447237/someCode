package com.example.canvas2017_3_21;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View{
	//所有的画布操作都只影响后续的绘制，对之前已经绘制过的内容没有影响
	private Paint mPaint;
	
	public CustomView(Context context) {
		this(context,null);
		
	}

	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint=new Paint();
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setColor(Color.BLACK);
		mPaint.setAntiAlias(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		//translate是坐标系的移动，可以为图形绘制选择一个合适的坐标系。 请注意，位移是基于当前位置移动，而不是每次基于屏幕左上角的(0,0)点移动
		//canvas.translate(200,200);
		//canvas.drawCircle(0,0,100, mPaint);
		//mPaint.setColor(Color.RED);
		//canvas.translate(200,200);
		//canvas.drawCircle(0,0,100, mPaint);
		
		// 将坐标系原点移动到画布正中心
		//canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);		
		//RectF rect=new RectF(0,-400,400,0);
		//canvas.drawRect(rect, mPaint);
		//canvas.scale(0.5f,0.5f);// 画布缩放
		//缩放的中心默认为坐标原点,而缩放中心轴就是坐标轴
		//mPaint.setColor(Color.RED);
		//canvas.drawRect(rect, mPaint);
		
		//一些同心矩形
		//mPaint.setStyle(Paint.Style.STROKE);
		//canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);// 将坐标系原点移动到画布正中心
		//RectF rect=new RectF(-400,-400,400,400);
		//for(int i=0;i<=20;i++){
		//	canvas.scale(0.9f,0.9f);
		//	canvas.drawRect(rect, mPaint);
		//}
		
		//一些同心圆
		mPaint.setStyle(Paint.Style.FILL);
		int colors []={0xffff0000,0xff00ff00,0xff0000ff,0xffffff00,0xffff00ff,0xff00ffff};
		canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);// 将坐标系原点移动到画布正中心
		for(int i=0;i<20;i++){
			canvas.scale(0.9f,0.9f);
			mPaint.setColor(colors[i%colors.length]);
			canvas.drawCircle(0,0,400, mPaint);
		}
			
		
		//旋转
		//canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);// 将坐标系原点移动到画布正中心
		//RectF rect=new RectF(0,-300,300,0);
		//canvas.drawRect(rect, mPaint);
		//canvas.rotate(90);// 旋转90度
		//mPaint.setColor(Color.RED);
		//canvas.drawRect(rect, mPaint);
		//canvas.rotate(90);
		//mPaint.setColor(Color.BLUE);
		//canvas.drawRect(rect, mPaint);
		//canvas.rotate(90);
		//mPaint.setColor(Color.YELLOW);
		//canvas.drawRect(rect, mPaint);
		
		
		//旋转例子
		//mPaint.setStyle(Paint.Style.STROKE);
		//canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);// 将坐标系原点移动到画布正中心
		//canvas.drawCircle(0,0,300, mPaint);
		//canvas.drawCircle(0,0,280, mPaint);
		//for(int i=0;i<=360;i+=30){			
			//canvas.drawLine(0,300,0,280, mPaint);
			//canvas.rotate(30);
		//}
		
		
		//错切
		//canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);// 将坐标系原点移动到画布正中心
		//RectF rect=new RectF(0,0,150,150);
		//canvas.drawRect(rect, mPaint);
		//canvas.skew(1, 0);//错切
		//mPaint.setColor(Color.RED);
		//canvas.drawRect(rect, mPaint);
	}
	
}
