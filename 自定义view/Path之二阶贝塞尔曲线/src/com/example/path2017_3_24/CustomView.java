package com.example.path2017_3_24;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View{

	private Paint mPaint;
	private Path mPath;
	private int centerX,centerY;
	private PointF start,end,control;
	
	public CustomView(Context context) {
		this(context,null);
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mPaint=new Paint();
		mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(60);
		mPath=new Path();
		start=new PointF(0,0);
		end=new PointF(0,0);
		control=new PointF(0, 0);
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		centerX=w/2;
		centerY=h/2;
		// ��ʼ�����ݵ�Ϳ��Ƶ��λ��
		start.x=centerX-200;
		start.y=centerY;
		end.x=centerX+200;
		end.y=centerY-100;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		 // ���ݴ���λ�ø��¿��Ƶ㣬����ʾ�ػ�
		control.x=event.getX();
		control.y=event.getY();
		invalidate();
		
		return true;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// �������ݵ�Ϳ��Ƶ�
		mPaint.setAntiAlias(true);
		mPaint.setColor(Color.GRAY);
		mPaint.setStrokeWidth(20);
		canvas.drawPoint(start.x,start.y,mPaint);
		canvas.drawPoint(end.x,end.y,mPaint);
		canvas.drawPoint(control.x,control.y,mPaint);
		
		// ���Ƹ�����
		mPaint.setStrokeWidth(4);
		canvas.drawLine(start.x, start.y,control.x,control.y, mPaint);
		canvas.drawLine(end.x,end.y,control.x,control.y, mPaint);
		
		 // ���ƶ��ױ���������
		mPaint.setColor(Color.RED);
		mPaint.setStrokeWidth(8);
		
		mPath.moveTo(start.x, start.y);
		mPath.quadTo(control.x,control.y,end.x, end.y);
		
		canvas.drawPath(mPath, mPaint);
	}
	
	
}
