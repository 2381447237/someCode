package com.example.canvas2017_3_222;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View{

	private Paint mPaint;
	
	public CustomView(Context context) {
		this(context,null);
		
	}
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint=new Paint();
		mPaint.setColor(Color.RED);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setAntiAlias(true);
	}

@Override
protected void onDraw(Canvas canvas) {
	super.onDraw(canvas);
	
	canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);// 移动坐标系到屏幕中心(宽高数据在onSizeChanged中获取)
	
	Path mPath=new Path();
	
	//关于lineTo
   mPath.lineTo(200,200);//添加上一个点到当前点之间的直线到Path（默认最开始的点是原点）
   mPath.lineTo(200,0);
   canvas.drawPath(mPath, mPaint);
	
	
	//关于moveTo
	//mPath.lineTo(200,200);
	//mPath.moveTo(200,100);//移动下一次操作的起点位置
	//mPath.lineTo(200, 0);
	//canvas.drawPath(mPath, mPaint);
	
	
	//关于setLastPoint
	//mPath.lineTo(200,200);
	//mPath.setLastPoint(200,100);//重置上一次操作的最后一个点
	//mPath.lineTo(200,0);
	//canvas.drawPath(mPath, mPaint);
	
	
	//关于close
	//mPath.lineTo(200,200);
	//mPath.lineTo(200, 0);
	//mPath.close();//用于连接当前最后一个点和最初的一个点(如果两个点不重合的话)，最终形成一个封闭的图形
	//canvas.drawPath(mPath, mPaint);
	
	//Direction.CW表示顺时针
	//Direction.CCW表示逆时针
	//画矩形
	//mPath.addRect(-200,-200,200,200,Direction.CCW);
	//mPath.setLastPoint(-300,300);
	//canvas.drawPath(mPath, mPaint);
	
	
	//addArc添加一个圆弧到path
	//canvas.scale(1,-1);// <-- 注意 翻转y坐标轴
	//mPath.lineTo(100,100);
	//RectF oval=new RectF(0, 0, 300, 300);
	//mPath.addArc(oval, 0,270);
	//canvas.drawPath(mPath,mPaint);
	
	
	//arcTo添加一个圆弧到path
	//canvas.scale(1,-1);
	//mPath.lineTo(100, 100);
	//RectF oval=new RectF(0,0,300,300);
	//mPath.arcTo(oval, 0,270);
	//canvas.drawPath(mPath, mPaint);
	
	//addArc与arcTo的区别:
	//addArc:直接添加一个圆弧到path中
    //arcTo:添加一个圆弧到path，如果圆弧的起点和上次最后一个坐标点不相同，就连接两个点



}
}
