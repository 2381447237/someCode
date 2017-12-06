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
	//��ʼ������
	private void initPaint(){
		mPaint=new Paint();
		mPaint.setColor(Color.BLACK);//���û�����ɫ
		mPaint.setStyle(Paint.Style.FILL);//���û���ģʽΪ���
		//mPaint.setStyle(Paint.Style.STROKE);//���û���ģʽΪ���
		mPaint.setStrokeWidth(10f);//���û��ʿ��Ϊ10px
		mPaint.setAntiAlias(true);//�����
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//canvas.drawColor(0xffff0000);//���ƺ�ɫ
		//canvas.drawCircle(100,100,50, mPaint);//��Բ
		//canvas.drawPoint(200,200,mPaint);//������(200,200)λ�û���һ����
		//canvas.drawPoints(new float[]{300,0,300,100,300,200,300,300,300,400,300,500,300,600,300,700,300,800,300,900,300,1000},mPaint);//����һ��㣬����λ����float����ָ��
	    //canvas.drawLine(300,300,500,600, mPaint);// ������(300,300)(500,600)֮�����һ��ֱ��
	   // canvas.drawLines(new float[]{100,200,200,200,100,300,200,300},mPaint);// ����һ���� ÿ������(�����������)ȷ��һ����
	   //canvas.drawRect(300,100,500,300, mPaint);//���ƾ���
		
		//RectF rectF=new RectF(100,100,300,300);
	    //canvas.drawRoundRect(rectF,30,30, mPaint);//����Բ�Ǿ���
		
       //RectF rectF=new RectF(100,100,500,300);
       //canvas.drawOval(rectF, mPaint);//������Բ
		
		RectF rectF=new RectF(100,100,500,500);
		mPaint.setColor(Color.GRAY);
		canvas.drawRect(rectF, mPaint);
		
		mPaint.setColor(Color.BLUE);
		canvas.drawArc(rectF, 0,90,true, mPaint);// ����Բ��1
		
		mPaint.setColor(Color.RED);
		canvas.drawArc(rectF, 0,90,false, mPaint);// ����Բ��2
	}
	
}
