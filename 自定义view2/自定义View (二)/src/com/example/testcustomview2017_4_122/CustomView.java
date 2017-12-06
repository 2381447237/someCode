package com.example.testcustomview2017_4_122;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class CustomView extends View{

	private int mWidth;//�ؼ��Ŀ�
	private int mHeight;//�ؼ��ĸ�
	private Bitmap mImage;//�ؼ��е�ͼƬ
	private int mImageScale;//ͼƬ������ģʽ
	private static final int IMAGE_SCALE_FITXY = 0;
	private static final int IMAGE_SCALE_CENTER = 1;
	
	private String mTitle;//ͼƬ�Ľ���
	private int mTextColor;//�������ɫ
	private int mTextSize;//����Ĵ�С
	private Paint mPaint;
	private Rect mTextBound;//���ı���Լ��
	private Rect rect;//�������岼��
	
	public CustomView(Context context) {
		this(context,null);
	}

	public CustomView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		TypedArray a=context.getTheme()
				.obtainStyledAttributes(attrs, R.styleable.CustomImageView, defStyleAttr,0);
		
		int n=a.getIndexCount();
		
		for(int i=0;i<n;i++){
			
			int attr=a.getIndex(i);
			
			switch (attr) {
			case R.styleable.CustomImageView_image:
				mImage=BitmapFactory.decodeResource(getResources(), a.getResourceId(attr, 0));
				break;
			case R.styleable.CustomImageView_imageScaleType:
				mImageScale=a.getInt(attr, 0);
				break;
			case R.styleable.CustomImageView_titleText:
				mTitle=a.getString(attr);
				break;
			case R.styleable.CustomImageView_titleTextColor:
				mTextColor=a.getColor(attr, Color.BLACK);
				break;
			case R.styleable.CustomImageView_titleTextSize:
				mTextSize=a.getDimensionPixelSize(attr,
						(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
								16, getResources().getDisplayMetrics()));
				break;
			default:
				break;
			}
			
		}
		a.recycle();
		rect=new Rect();
		mPaint=new Paint();
		mTextBound=new Rect();
		mPaint.setTextSize(mTextSize);
		// ���������������Ҫ�ķ�Χ
		mPaint.getTextBounds(mTitle, 0,mTitle.length(), mTextBound);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		
		int specMode=MeasureSpec.getMode(widthMeasureSpec);
		int specSize=MeasureSpec.getSize(widthMeasureSpec);
		
		if(specMode==MeasureSpec.EXACTLY){
			mWidth=specSize;
		}else{
			int desireByImg=getPaddingLeft()+mImage.getWidth()+getPaddingRight();
			int desireByTitle=getPaddingLeft()+mTextBound.width()+getPaddingRight();
			
			if(specMode==MeasureSpec.AT_MOST){
				
				int desire=Math.max(desireByImg, desireByTitle);
				mWidth=Math.min(desire, specSize);
				
			}
			
		}
		
		specMode=MeasureSpec.getMode(heightMeasureSpec);
		specSize=MeasureSpec.getSize(heightMeasureSpec);
		
		if(specMode==MeasureSpec.EXACTLY){
			mHeight=specSize;
			
		}else{
			
			int desire=getPaddingTop()+getPaddingBottom()+mImage.getHeight()+mTextBound.height();
			if(specMode==MeasureSpec.AT_MOST){
				mHeight=Math.min(desire, specSize);
			}
		}
		setMeasuredDimension(mWidth, mHeight);
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		
		//�߿�
		mPaint.setStrokeWidth(4);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.CYAN);
		canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(), mPaint);
		
		rect.left = getPaddingLeft();
		rect.right = mWidth - getPaddingRight();
		rect.top = getPaddingTop();
		rect.bottom = mHeight - getPaddingBottom();

		mPaint.setColor(mTextColor);
		mPaint.setStyle(Style.FILL);
		/**
		 * ��ǰ���õĿ��С��������Ҫ�Ŀ�ȣ��������Ϊxxx...
		 */
		if (mTextBound.width() > mWidth)
		{
			TextPaint paint = new TextPaint(mPaint);
			String msg = TextUtils.ellipsize(mTitle, paint, (float) mWidth - getPaddingLeft() - getPaddingRight(),
					TextUtils.TruncateAt.END).toString();
			canvas.drawText(msg, getPaddingLeft(), mHeight - getPaddingBottom(), mPaint);

		} else
		{
			//������������������
			canvas.drawText(mTitle, mWidth / 2 - mTextBound.width() * 1.0f / 2, mHeight - getPaddingBottom(), mPaint);
		}

		//ȡ��ʹ�õ��Ŀ�
		rect.bottom -= mTextBound.height();

		if (mImageScale == IMAGE_SCALE_FITXY)
		{
			canvas.drawBitmap(mImage, null, rect, mPaint);
		} else
		{
			//������еľ��η�Χ
			rect.left = mWidth / 2 - mImage.getWidth() / 2;
			rect.right = mWidth / 2 + mImage.getWidth() / 2;
			rect.top = (mHeight - mTextBound.height()) / 2 - mImage.getHeight() / 2;
			rect.bottom = (mHeight - mTextBound.height()) / 2 + mImage.getHeight() / 2;

			canvas.drawBitmap(mImage, null, rect, mPaint);
		}
	}
	
}
