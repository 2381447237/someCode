package com.example.testcustomview2017_4_17;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View{

	//Բ��ģʽ
    public final int MODE_CIRCLE = -1;

    //����ģʽ
    public final int MODE_TRIANGLE = -2;
	private Paint mPaint;
	private Path mPath;
	private Context mContext;
	private int mWaveCount;//���˵��ܸ���
	private float mWaveWidth;//�����εĿ��
	private float mWaveHeight;//�����εĸ߶�
	private int mMode;
	private int mColor;
	
	private int mWidth;
	private int mHeight;
	
	private float mRectWidth,mRectHeight;//���ο��
	
	private float mRadius;
	
	public CustomView(Context context) {
		this(context,null);
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	
	
	public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		mContext=context;
		TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.WaveView, defStyleAttr, 0);
		mWaveCount=a.getInt(R.styleable.WaveView_waveCount,10);
		mWaveWidth=a.getInt(R.styleable.WaveView_waveWidth, 20);
		mMode=a.getInteger(R.styleable.WaveView_mode,-2);
		mColor=a.getColor(R.styleable.WaveView_android_color,Color.parseColor("#2C97DE"));
		
		mPaint=new Paint();	
		
		mPath=new Path();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		
		int widthSize=MeasureSpec.getSize(widthMeasureSpec);
		int heightSize=MeasureSpec.getSize(heightMeasureSpec);
		
		int widthMode=MeasureSpec.getMode(widthMeasureSpec);
		int heightMode=MeasureSpec.getMode(heightMeasureSpec);
		
		if(widthMode==MeasureSpec.EXACTLY){
			mWidth=widthSize;
			mRectWidth=(float) (mWidth*0.8);
			
			//�����wrap_content ֱ�Ӹ�һ����ֵ 
		}else if(widthMode==MeasureSpec.AT_MOST){
			mWidth=PxUtils.dpToPx(300, mContext);
			mRectWidth=(float) (mWidth*0.8);
		}
		
		if(heightMode==MeasureSpec.EXACTLY){
			mHeight=heightSize;
			mRectHeight=(float) (mHeight*0.8);
			
			//�����wrap_content ֱ�Ӹ�һ����ֵ
		}else if(heightMode==MeasureSpec.AT_MOST){
			mHeight=PxUtils.dpToPx(200, mContext);
			mRectHeight=(float) (mHeight*0.8);
		}
		
		setMeasuredDimension(mWidth, mHeight);
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		mPaint.setColor(mColor);
		mPaint.setAntiAlias(true);
		 //����ÿ�������εĸ�
		mWaveHeight=mRectHeight/mWaveCount;
		
		float padding=((mWidth-mRectWidth)/2);
		//���ƾ���
		canvas.drawRect(padding, padding, mRectWidth+padding,mRectHeight+padding, mPaint);

		mWaveHeight=mRectHeight/mWaveCount;
		
		//���������ģʽ
		if(mMode == MODE_TRIANGLE) {  
            //�����ұߵ�����
            float startX = padding + mRectWidth;  
            float startY = padding;  
             mPath.reset();
            mPath.moveTo(startX, startY);  
            for (int i = 0; i < mWaveCount; i++) {  
            	mPath.lineTo(startX + mWaveWidth, startY + i * mWaveHeight + (mWaveHeight / 2));  
            	mPath.lineTo(startX, startY + mWaveHeight * (i + 1));  
  
            }  
            mPath.close();  
            canvas.drawPath(mPath,mPaint); 
            
          //������ߵ�����
            startX=padding;
            startY=padding;
            mPath.moveTo(startX, startY);
            for(int i=0;i<mWaveCount;i++){
            	mPath.lineTo(startX-mWaveWidth,startY+i*mWaveHeight+(mWaveHeight/2));
            	mPath.lineTo(startX, startY+mWaveHeight*(i+1));
            }
            
            mPath.close();
            canvas.drawPath(mPath, mPaint);
            
		}else{
			
			mRadius=mRectHeight/mWaveCount;
			//�����ұ߲���
			float startX=padding+mRectWidth;
			float startY=padding;
			for(int i=0;i<mWaveCount/2;i++){
				canvas.drawCircle(startX, startY+i*mRadius*2+mRadius,mRadius, mPaint);
			}
			
			//������߲���
			startX=padding;
			startY=padding;
			for(int i=0;i<mWaveCount/2;i++){
				canvas.drawCircle(startX, startY+i*mRadius*2+mRadius, mRadius, mPaint);
			}
			
		}
		}
	

}
