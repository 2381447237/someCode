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
//	PathMeasure measure1=new PathMeasure(path, false);//PathMeasure��һ����������Path����
//	PathMeasure measure2=new PathMeasure(path, true);
//	//forceClosed Ϊ false �������ǵ�ǰ Path ״̬�ĳ��ȣ�
//	//forceClosed Ϊ true������Path�Ƿ�պϲ����Ķ��� Path �ıպϳ���
//	Log.e("TAG", "forceClosed=false---->"+measure1.getLength());
//	Log.e("TAG", "forceClosed=true----->"+measure2.getLength());
//	canvas.drawPath(path, mDeafultPaint);
	
	
//	canvas.translate(getWidth()/2,getHeight()/2);// ƽ������ϵ
//	path.addRect(-200,-200,200,200,Path.Direction.CW);// ����Path�������һ������
//	Path dst = new Path();
//	dst.lineTo(-300, -300);
//	PathMeasure measure=new PathMeasure(path, false);// �� Path �� PathMeasure ����
//	measure.getSegment(200,600, dst, true);// ��ȡһ���ִ���dst�У���ʹ�� moveTo ���ֽ�ȡ�õ��� Path ��һ�����λ�ò���
//	//��� startWithMoveTo Ϊ true, �򱻽�ȡ������PathƬ�α���ԭ״��
//	//��� startWithMoveTo Ϊ false����Ὣ��ȡ������ Path Ƭ�ε���ʼ���ƶ��� dst �����һ���㣬�Ա�֤ dst ��������
//	canvas.drawPath(dst, mDeafultPaint);// ���� dst
	
	
	
	canvas.translate(getWidth()/2,getHeight()/2);// ƽ������ϵ
	path.addRect(-100,-100,100,100,Path.Direction.CW);
	canvas.drawPath(path, mDeafultPaint);
	path.addRect(-200,-200,200,200,Path.Direction.CW);
	canvas.drawPath(path, mDeafultPaint);
	PathMeasure measure=new PathMeasure(path, false);
	float len1=measure.getLength();// ��õ�һ��·���ĳ���
	measure.nextContour();// ��ת����һ��·��
	float len2=measure.getLength();// ��õڶ���·���ĳ���
	Log.i("LEN","len1="+len1);    // �������·���ĳ���
	Log.i("LEN","len2="+len2);
   }
}
