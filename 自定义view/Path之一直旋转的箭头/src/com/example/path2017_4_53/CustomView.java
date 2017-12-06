package com.example.path2017_4_53;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View{

	private float currentValue=0;// ���ڼ�¼��ǰ��λ��,ȡֵ��Χ[0,1]ӳ��Path����������
	private float[] pos;// ��ǰ���ʵ��λ��
	private float[] tan;// ��ǰ���tangentֵ,���ڼ���ͼƬ������ת�ĽǶ�
	private Bitmap mBitmap; // ��ͷͼƬ
	private Matrix mMatrix; // ����,���ڶ�ͼƬ����һЩ����
	private Path path;
	private Paint mDeafultPaint;
	
	public CustomView(Context context) {
		this(context,null);
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		path=new Path();
		mDeafultPaint=new Paint();
		mDeafultPaint.setStyle(Paint.Style.STROKE);
		mDeafultPaint.setAntiAlias(true);
		init(context);
	}

    private void init(Context context){
	
	  pos=new float[2];
	  tan=new float[2];
	  BitmapFactory.Options options=new BitmapFactory.Options();
	  options.inSampleSize=10;// ����ͼƬ
	  mBitmap=BitmapFactory.decodeResource(context.getResources(),R.drawable.arrow,options);
	  mMatrix=new Matrix();
	
    }
	
     @Override
     protected void onDraw(Canvas canvas) {
	    super.onDraw(canvas);
	
	  canvas.translate(getWidth()/2,getHeight()/2);// ƽ������ϵ
	  path.addCircle(0,0,200,Path.Direction.CW);// ���һ��Բ��
	  PathMeasure measure=new PathMeasure(path, false);// ���� PathMeasure
	
	  currentValue+=0.01;// ���㵱ǰ��λ�����ܳ����ϵı���[0,1]
	  if(currentValue>=1){
		currentValue=0;
	  }
	  measure.getPosTan(measure.getLength()*currentValue, pos, tan);// ��ȡ��ǰλ�õ������Լ�����
	
	  Log.i("2017/4/5","pos[0]="+pos[0]+"pos[1]="+pos[1]+"tan[0]="+tan[0]+"tan[1]="+tan[1]);
	  
	  mMatrix.reset();// ����Matrix
	  float degrees=(float) (Math.atan2(tan[1],tan[0])*180.0/Math.PI);// ����ͼƬ��ת�Ƕ�
	  mMatrix.postRotate(degrees, mBitmap.getWidth()/2,mBitmap.getHeight()/2); // ��תͼƬ
	  mMatrix.postTranslate(pos[0]-mBitmap.getWidth()/2,pos[1]-mBitmap.getHeight()/2);// ��ͼƬ�������ĵ������뵱ǰ���غ�
	
	  canvas.drawPath(path,mDeafultPaint);
	  canvas.drawBitmap(mBitmap, mMatrix, mDeafultPaint);// ���Ƽ�ͷ
	
	  invalidate();// �ػ�ҳ��
}

}
