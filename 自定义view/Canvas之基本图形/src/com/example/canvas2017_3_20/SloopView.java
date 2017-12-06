package com.example.canvas2017_3_20;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class SloopView extends View{

	private Paint mPaint;
	
	public SloopView(Context context) {
		this(context,null);
	
	}
	
	public SloopView(Context context, AttributeSet attrs) {
		super(context, attrs);
	    initPaint();
	}
	//初始化画笔
	private void initPaint(){
		mPaint=new Paint();
		mPaint.setColor(Color.BLACK);//设置画笔颜色
		mPaint.setStyle(Paint.Style.FILL);//设置画笔模式为填充
		//mPaint.setStyle(Paint.Style.STROKE);//设置画笔模式为描边
		mPaint.setStrokeWidth(10f);//设置画笔宽度为10px
		mPaint.setAntiAlias(true);//抗锯齿
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//canvas.drawColor(0xffff0000);//绘制红色
		//canvas.drawCircle(100,100,50, mPaint);//画圆
		//canvas.drawPoint(200,200,mPaint);//在坐标(200,200)位置绘制一个点
		//canvas.drawPoints(new float[]{300,0,300,100,300,200,300,300,300,400,300,500,300,600,300,700,300,800,300,900,300,1000},mPaint);//绘制一组点，坐标位置由float数组指定
	    //canvas.drawLine(300,300,500,600, mPaint);// 在坐标(300,300)(500,600)之间绘制一条直线
	   // canvas.drawLines(new float[]{100,200,200,200,100,300,200,300},mPaint);// 绘制一组线 每四数字(两个点的坐标)确定一条线
	   //canvas.drawRect(300,100,500,300, mPaint);//绘制矩形
		
		//RectF rectF=new RectF(100,100,300,300);
	    //canvas.drawRoundRect(rectF,30,30, mPaint);//绘制圆角矩形
		
       //RectF rectF=new RectF(100,100,500,300);
       //canvas.drawOval(rectF, mPaint);//绘制椭圆
		
		RectF rectF=new RectF(100,100,500,500);
		mPaint.setColor(Color.GRAY);
		canvas.drawRect(rectF, mPaint);
		
		mPaint.setColor(Color.BLUE);
		canvas.drawArc(rectF, 0,90,true, mPaint);// 绘制圆弧1
		
		mPaint.setColor(Color.RED);
		canvas.drawArc(rectF, 0,90,false, mPaint);// 绘制圆弧2
	}
	
}
