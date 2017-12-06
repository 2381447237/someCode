package com.example.canvas2017_3_21;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View{
	//���еĻ���������ֻӰ������Ļ��ƣ���֮ǰ�Ѿ����ƹ�������û��Ӱ��
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
		
		//translate������ϵ���ƶ�������Ϊͼ�λ���ѡ��һ�����ʵ�����ϵ�� ��ע�⣬λ���ǻ��ڵ�ǰλ���ƶ���������ÿ�λ�����Ļ���Ͻǵ�(0,0)���ƶ�
		//canvas.translate(200,200);
		//canvas.drawCircle(0,0,100, mPaint);
		//mPaint.setColor(Color.RED);
		//canvas.translate(200,200);
		//canvas.drawCircle(0,0,100, mPaint);
		
		// ������ϵԭ���ƶ�������������
		//canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);		
		//RectF rect=new RectF(0,-400,400,0);
		//canvas.drawRect(rect, mPaint);
		//canvas.scale(0.5f,0.5f);// ��������
		//���ŵ�����Ĭ��Ϊ����ԭ��,���������������������
		//mPaint.setColor(Color.RED);
		//canvas.drawRect(rect, mPaint);
		
		//һЩͬ�ľ���
		//mPaint.setStyle(Paint.Style.STROKE);
		//canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);// ������ϵԭ���ƶ�������������
		//RectF rect=new RectF(-400,-400,400,400);
		//for(int i=0;i<=20;i++){
		//	canvas.scale(0.9f,0.9f);
		//	canvas.drawRect(rect, mPaint);
		//}
		
		//һЩͬ��Բ
		mPaint.setStyle(Paint.Style.FILL);
		int colors []={0xffff0000,0xff00ff00,0xff0000ff,0xffffff00,0xffff00ff,0xff00ffff};
		canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);// ������ϵԭ���ƶ�������������
		for(int i=0;i<20;i++){
			canvas.scale(0.9f,0.9f);
			mPaint.setColor(colors[i%colors.length]);
			canvas.drawCircle(0,0,400, mPaint);
		}
			
		
		//��ת
		//canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);// ������ϵԭ���ƶ�������������
		//RectF rect=new RectF(0,-300,300,0);
		//canvas.drawRect(rect, mPaint);
		//canvas.rotate(90);// ��ת90��
		//mPaint.setColor(Color.RED);
		//canvas.drawRect(rect, mPaint);
		//canvas.rotate(90);
		//mPaint.setColor(Color.BLUE);
		//canvas.drawRect(rect, mPaint);
		//canvas.rotate(90);
		//mPaint.setColor(Color.YELLOW);
		//canvas.drawRect(rect, mPaint);
		
		
		//��ת����
		//mPaint.setStyle(Paint.Style.STROKE);
		//canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);// ������ϵԭ���ƶ�������������
		//canvas.drawCircle(0,0,300, mPaint);
		//canvas.drawCircle(0,0,280, mPaint);
		//for(int i=0;i<=360;i+=30){			
			//canvas.drawLine(0,300,0,280, mPaint);
			//canvas.rotate(30);
		//}
		
		
		//����
		//canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);// ������ϵԭ���ƶ�������������
		//RectF rect=new RectF(0,0,150,150);
		//canvas.drawRect(rect, mPaint);
		//canvas.skew(1, 0);//����
		//mPaint.setColor(Color.RED);
		//canvas.drawRect(rect, mPaint);
	}
	
}
