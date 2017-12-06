package com.example.testcustomview2017_4_14;

import java.util.HashMap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View{

	private int mWidth,mHeight;//View �Ŀ�͸�
	
	private float mYAxisFontSize=24;//Y������Ĵ�С
	
	private int mLineColor=Color.parseColor("#00BCD4");//�ߵ���ɫ
	
	private float mStrokeWidth=8.0f;//�����Ŀ��
	
	private HashMap<Integer,Integer> mPointMap;//��ļ���
	
	private float mPointRadius=10;//��İ뾶
	
	private String mNoDataMsg="û������";//û�����ݵ�ʱ�������
	
	private String[] mXAxis={}; //X�������
	
	private String[] mYAxis={};//Y�������
	
	public CustomView(Context context) {
		this(context,null);
		// TODO Auto-generated constructor stub
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
		// TODO Auto-generated constructor stub
	}
	
	public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}


     @Override
      protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	
    	 int widthMode=MeasureSpec.getMode(widthMeasureSpec);
    	 int heightMode=MeasureSpec.getMode(heightMeasureSpec);
    	 
    	 int widthSize=MeasureSpec.getSize(widthMeasureSpec);
    	 int heightSize=MeasureSpec.getSize(heightMeasureSpec);
    	 
    	 if(widthMode==MeasureSpec.EXACTLY){
    		 mWidth=widthSize;
    		 
    		 Log.i("2017-4-14", "widthMode==MeasureSpec.EXACTLY");
    		 
    	 }else if(widthMode==MeasureSpec.AT_MOST){
    		 Log.i("2017-4-14", "widthMode==MeasureSpec.AT_MOST");
    		 throw new IllegalArgumentException("width must be EXACTLY,you should set like android:width=\"200dp\"");
    	 }
    	 
    	 if(heightMode==MeasureSpec.EXACTLY){
    		 mHeight=heightSize;
    		 Log.i("2017-4-14", "heightMode==MeasureSpec.EXACTLY");
    	 }else if(heightMode==MeasureSpec.AT_MOST){
    		 Log.i("2017-4-14", "heightMode==MeasureSpec.AT_MOST");
    		 throw new IllegalArgumentException("height must be EXACTLY,you should set like android:height=\"200dp\"");
    	 }
    	 
    	 setMeasuredDimension(widthSize, heightSize);
   }
	
	@Override
	protected void onDraw(Canvas canvas) {
		
		if(mXAxis.length==0||mYAxis.length==0){
			throw new IllegalArgumentException("X or Y items is null");
		}
		
		//�������ߵ���
       Paint axisPaint=new Paint();
       axisPaint.setTextSize(mYAxisFontSize);
       axisPaint.setColor(Color.parseColor("#3F51B5"));
       
       if(mPointMap==null||mPointMap.size()==0){
    	   int textLength=(int) axisPaint.measureText(mNoDataMsg);
    	   canvas.drawText(mNoDataMsg, mWidth/2-textLength/2, mHeight/2, axisPaint);
       }
       
       //�� Y ��
       //���ÿ��Y�������
       int[] yPoints=new int[mYAxis.length];
       //����Y�� ÿ���̶ȵļ��
       int yInterval=(int) ((mHeight-mYAxisFontSize-2)/(mYAxis.length));
     //����Y�����ֵĸ߶� ��������һ����
       Paint.FontMetrics fm=axisPaint.getFontMetrics();
       int yItemHeight=(int) Math.ceil(fm.descent-fm.ascent);//����ȡ������
       
       for(int i=0;i<mYAxis.length;i++){
    	   canvas.drawText(mYAxis[i],0,mYAxisFontSize+i*yInterval,axisPaint);
    	   yPoints[i]=(int) (mYAxisFontSize+i*yInterval);
       }
       
     //�� X ��

     //x��Ŀ̶ȼ���
       int[] xPoints=new int[mXAxis.length];
     //����Y�Ὺʼ��ԭ������
       int xItemX = (int) axisPaint.measureText(mYAxis[1]);

       //X��ƫ����
       int xOffset = 50;
       //����x�� �̶ȼ��
       int xInterval = (int) ((mWidth - xOffset) / (mXAxis.length));
       //��ȡX��̶�Y����
       int xItemY = (int) (mYAxisFontSize + mYAxis.length * yInterval);

       for (int i = 0; i < mXAxis.length; i++) {
           canvas.drawText(mXAxis[i], i * xInterval + xItemX + xOffset, xItemY, axisPaint);
           xPoints[i] = (int) (i * xInterval + xItemX + axisPaint.measureText(mXAxis[i]) / 2 + xOffset + 10);
       }

     //����
       Paint pointPaint=new Paint();
       
       pointPaint.setColor(mLineColor);
       
       Paint linePaint=new Paint();
       
       linePaint.setColor(mLineColor);
       linePaint.setAntiAlias(true);
       
       linePaint.setStrokeWidth(mStrokeWidth);
       pointPaint.setStyle(Paint.Style.FILL);
       
       for(int i=0;i<mXAxis.length;i++){
    	   if(mPointMap.get(i)==null){
    		   throw new IllegalArgumentException("PointMap has incomplete data!");
    	   }
    	   
    	   canvas.drawCircle(xPoints[i],yPoints[mPointMap.get(i)],mPointRadius, pointPaint);
    	   
    	   if(i>0){
    		   canvas.drawLine(xPoints[i-1],yPoints[mPointMap.get(i-1)],xPoints[i],yPoints[mPointMap.get(i)], linePaint);
    	   }
       }
       
	}
	
	/**
     * ����map����
     * @param data
     */

	public void setData(HashMap<Integer,Integer> data){
		mPointMap=data;
		invalidate();
		
		Log.i("2017/4/14", "mPointMap"+mPointMap);
	}
	
	/**
     * ����Y������
     * @param yItem
     */
    public void setYItem(String [] yItem){
    	
    	mYAxis=yItem;
    	
    }
    
    /**
     * ����X������
     * @param xItem
     */
     public void setXItem(String [] xItem){
    	 
    	 mXAxis=xItem;
    	 
     }
     
     public void setLineColor(int color){
    	 
    	 mLineColor=color;
    	 invalidate();
    	 
     }
}
