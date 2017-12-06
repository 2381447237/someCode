package com.example.canvas2017_3_22;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
		mPaint.setAntiAlias(true);
		mPaint.setTextSize(50);
	}

@Override
protected void onDraw(Canvas canvas) {
	super.onDraw(canvas);
	
	String str="ABCDEFG";// 文本(要绘制的内容)
	
	canvas.drawText(str, 50,100, mPaint);// 参数分别为 (文本 基线x 基线y 画笔)
	
	canvas.drawText(str, 1,3,50,200, mPaint);// 参数分别为 (字符串 开始截取位置 结束截取位置 基线x 基线y 画笔)

    char[] chars="ABCDEFG".toCharArray();// 字符数组(要绘制的内容)
    
    canvas.drawText(chars, 1,3,50,300, mPaint);// 参数为 (字符数组 起始坐标 截取长度 基线x 基线y 画笔)
    
    String sloopStr="SLOOP";
    //不推荐使用 
    canvas.drawPosText(sloopStr, new float[]{50,400,80,450,110,500,140,550,170,600}, mPaint);
}
}
