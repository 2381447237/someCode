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
	
	String str="ABCDEFG";// �ı�(Ҫ���Ƶ�����)
	
	canvas.drawText(str, 50,100, mPaint);// �����ֱ�Ϊ (�ı� ����x ����y ����)
	
	canvas.drawText(str, 1,3,50,200, mPaint);// �����ֱ�Ϊ (�ַ��� ��ʼ��ȡλ�� ������ȡλ�� ����x ����y ����)

    char[] chars="ABCDEFG".toCharArray();// �ַ�����(Ҫ���Ƶ�����)
    
    canvas.drawText(chars, 1,3,50,300, mPaint);// ����Ϊ (�ַ����� ��ʼ���� ��ȡ���� ����x ����y ����)
    
    String sloopStr="SLOOP";
    //���Ƽ�ʹ�� 
    canvas.drawPosText(sloopStr, new float[]{50,400,80,450,110,500,140,550,170,600}, mPaint);
}
}
