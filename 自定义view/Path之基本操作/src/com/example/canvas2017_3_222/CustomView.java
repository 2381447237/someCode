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
	
	canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);// �ƶ�����ϵ����Ļ����(���������onSizeChanged�л�ȡ)
	
	Path mPath=new Path();
	
	//����lineTo
   mPath.lineTo(200,200);//�����һ���㵽��ǰ��֮���ֱ�ߵ�Path��Ĭ���ʼ�ĵ���ԭ�㣩
   mPath.lineTo(200,0);
   canvas.drawPath(mPath, mPaint);
	
	
	//����moveTo
	//mPath.lineTo(200,200);
	//mPath.moveTo(200,100);//�ƶ���һ�β��������λ��
	//mPath.lineTo(200, 0);
	//canvas.drawPath(mPath, mPaint);
	
	
	//����setLastPoint
	//mPath.lineTo(200,200);
	//mPath.setLastPoint(200,100);//������һ�β��������һ����
	//mPath.lineTo(200,0);
	//canvas.drawPath(mPath, mPaint);
	
	
	//����close
	//mPath.lineTo(200,200);
	//mPath.lineTo(200, 0);
	//mPath.close();//�������ӵ�ǰ���һ����������һ����(��������㲻�غϵĻ�)�������γ�һ����յ�ͼ��
	//canvas.drawPath(mPath, mPaint);
	
	//Direction.CW��ʾ˳ʱ��
	//Direction.CCW��ʾ��ʱ��
	//������
	//mPath.addRect(-200,-200,200,200,Direction.CCW);
	//mPath.setLastPoint(-300,300);
	//canvas.drawPath(mPath, mPaint);
	
	
	//addArc���һ��Բ����path
	//canvas.scale(1,-1);// <-- ע�� ��תy������
	//mPath.lineTo(100,100);
	//RectF oval=new RectF(0, 0, 300, 300);
	//mPath.addArc(oval, 0,270);
	//canvas.drawPath(mPath,mPaint);
	
	
	//arcTo���һ��Բ����path
	//canvas.scale(1,-1);
	//mPath.lineTo(100, 100);
	//RectF oval=new RectF(0,0,300,300);
	//mPath.arcTo(oval, 0,270);
	//canvas.drawPath(mPath, mPaint);
	
	//addArc��arcTo������:
	//addArc:ֱ�����һ��Բ����path��
    //arcTo:���һ��Բ����path�����Բ���������ϴ����һ������㲻��ͬ��������������



}
}
