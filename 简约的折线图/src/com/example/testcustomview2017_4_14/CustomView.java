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

	private int mWidth,mHeight;//View 的宽和高
	
	private float mYAxisFontSize=24;//Y轴字体的大小
	
	private int mLineColor=Color.parseColor("#00BCD4");//线的颜色
	
	private float mStrokeWidth=8.0f;//线条的宽度
	
	private HashMap<Integer,Integer> mPointMap;//点的集合
	
	private float mPointRadius=10;//点的半径
	
	private String mNoDataMsg="没有数据";//没有数据的时候的内容
	
	private String[] mXAxis={}; //X轴的文字
	
	private String[] mYAxis={};//Y轴的文字
	
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
		
		//画坐标线的轴
       Paint axisPaint=new Paint();
       axisPaint.setTextSize(mYAxisFontSize);
       axisPaint.setColor(Color.parseColor("#3F51B5"));
       
       if(mPointMap==null||mPointMap.size()==0){
    	   int textLength=(int) axisPaint.measureText(mNoDataMsg);
    	   canvas.drawText(mNoDataMsg, mWidth/2-textLength/2, mHeight/2, axisPaint);
       }
       
       //画 Y 轴
       //存放每个Y轴的坐标
       int[] yPoints=new int[mYAxis.length];
       //计算Y轴 每个刻度的间距
       int yInterval=(int) ((mHeight-mYAxisFontSize-2)/(mYAxis.length));
     //测量Y轴文字的高度 用来画第一个数
       Paint.FontMetrics fm=axisPaint.getFontMetrics();
       int yItemHeight=(int) Math.ceil(fm.descent-fm.ascent);//向上取整计算
       
       for(int i=0;i<mYAxis.length;i++){
    	   canvas.drawText(mYAxis[i],0,mYAxisFontSize+i*yInterval,axisPaint);
    	   yPoints[i]=(int) (mYAxisFontSize+i*yInterval);
       }
       
     //画 X 轴

     //x轴的刻度集合
       int[] xPoints=new int[mXAxis.length];
     //计算Y轴开始的原点坐标
       int xItemX = (int) axisPaint.measureText(mYAxis[1]);

       //X轴偏移量
       int xOffset = 50;
       //计算x轴 刻度间距
       int xInterval = (int) ((mWidth - xOffset) / (mXAxis.length));
       //获取X轴刻度Y坐标
       int xItemY = (int) (mYAxisFontSize + mYAxis.length * yInterval);

       for (int i = 0; i < mXAxis.length; i++) {
           canvas.drawText(mXAxis[i], i * xInterval + xItemX + xOffset, xItemY, axisPaint);
           xPoints[i] = (int) (i * xInterval + xItemX + axisPaint.measureText(mXAxis[i]) / 2 + xOffset + 10);
       }

     //画点
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
     * 设置map数据
     * @param data
     */

	public void setData(HashMap<Integer,Integer> data){
		mPointMap=data;
		invalidate();
		
		Log.i("2017/4/14", "mPointMap"+mPointMap);
	}
	
	/**
     * 设置Y轴文字
     * @param yItem
     */
    public void setYItem(String [] yItem){
    	
    	mYAxis=yItem;
    	
    }
    
    /**
     * 设置X轴文字
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
