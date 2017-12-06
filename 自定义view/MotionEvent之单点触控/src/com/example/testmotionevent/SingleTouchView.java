package com.example.testmotionevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class SingleTouchView extends ViewGroup{

	public SingleTouchView(Context context) {
		this(context, null);
		
	}
	
	public SingleTouchView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}

	@Override
	protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		switch (event.getAction()) {
		
		case MotionEvent.ACTION_DOWN:
			// 手指按下
			Log.i("2017/4/10","+++ACTION_DOWN+++");
			
			break;

		case MotionEvent.ACTION_MOVE:
			// 手指移动
			Log.i("2017/4/10","+++ACTION_MOVE+++");
			break;
			
		case MotionEvent.ACTION_UP:
			// 手指抬起
			Log.i("2017/4/10","+++ACTION_UP+++");
			break;
			
		case MotionEvent.ACTION_CANCEL:
			// 事件被拦截 
			//只有上层 View 回收事件处理权的时候，ChildView 才会收到一个 ACTION_CANCEL 事件
			Log.i("2017/4/10","+++ACTION_CANCEL+++");
			break
			;
		case MotionEvent.ACTION_OUTSIDE:
			// 超出区域
			Log.i("2017/4/10","+++ACTION_OUTSIDE+++");
			break;
		
		default:
			break;
		}
		
		return true;
	}
	
}
