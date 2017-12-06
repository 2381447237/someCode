package com.example.path2017_4_52;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View{

	private Path path;
	
	private Paint mDeafultPaint;
	
	public CustomView(Context context) {
		this(context,null);
	}
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		path=new Path();
		
		mDeafultPaint=new Paint();
		mDeafultPaint.setStyle(Style.STROKE);
	}

    @SuppressLint("DrawAllocation") 
    @Override
    protected void onDraw(Canvas canvas) {
	super.onDraw(canvas);
	
//	canvas.translate(getWidth()/2,getHeight()/2);
//	path.lineTo(0,200);
//	path.lineTo(200,200);
//	path.lineTo(200,0);	
//	PathMeasure measure1=new PathMeasure(path, false);//PathMeasure是一个用来测量Path的类
//	PathMeasure measure2=new PathMeasure(path, true);
//	//forceClosed 为 false 测量的是当前 Path 状态的长度，
//	//forceClosed 为 true，则不论Path是否闭合测量的都是 Path 的闭合长度
//	Log.e("TAG", "forceClosed=false---->"+measure1.getLength());
//	Log.e("TAG", "forceClosed=true----->"+measure2.getLength());
//	canvas.drawPath(path, mDeafultPaint);
	
	
//	canvas.translate(getWidth()/2,getHeight()/2);// 平移坐标系
//	path.addRect(-200,-200,200,200,Path.Direction.CW);// 创建Path并添加了一个矩形
//	Path dst = new Path();
//	dst.lineTo(-300, -300);
//	PathMeasure measure=new PathMeasure(path, false);// 将 Path 与 PathMeasure 关联
//	measure.getSegment(200,600, dst, true);// 截取一部分存入dst中，并使用 moveTo 保持截取得到的 Path 第一个点的位置不变
//	//如果 startWithMoveTo 为 true, 则被截取出来到Path片段保持原状，
//	//如果 startWithMoveTo 为 false，则会将截取出来的 Path 片段的起始点移动到 dst 的最后一个点，以保证 dst 的连续性
//	canvas.drawPath(dst, mDeafultPaint);// 绘制 dst
	
	
	
	canvas.translate(getWidth()/2,getHeight()/2);// 平移坐标系
	path.addRect(-100,-100,100,100,Path.Direction.CW);
	canvas.drawPath(path, mDeafultPaint);
	path.addRect(-200,-200,200,200,Path.Direction.CW);
	canvas.drawPath(path, mDeafultPaint);
	PathMeasure measure=new PathMeasure(path, false);
	float len1=measure.getLength();// 获得第一条路径的长度
	measure.nextContour();// 跳转到下一条路径
	float len2=measure.getLength();// 获得第二条路径的长度
	Log.i("LEN","len1="+len1);    // 输出两条路径的长度
	Log.i("LEN","len2="+len2);
   }
}
