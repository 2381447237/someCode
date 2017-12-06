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
			// ��ָ����
			Log.i("2017/4/10","+++ACTION_DOWN+++");
			
			break;

		case MotionEvent.ACTION_MOVE:
			// ��ָ�ƶ�
			Log.i("2017/4/10","+++ACTION_MOVE+++");
			break;
			
		case MotionEvent.ACTION_UP:
			// ��ָ̧��
			Log.i("2017/4/10","+++ACTION_UP+++");
			break;
			
		case MotionEvent.ACTION_CANCEL:
			// �¼������� 
			//ֻ���ϲ� View �����¼�����Ȩ��ʱ��ChildView �Ż��յ�һ�� ACTION_CANCEL �¼�
			Log.i("2017/4/10","+++ACTION_CANCEL+++");
			break
			;
		case MotionEvent.ACTION_OUTSIDE:
			// ��������
			Log.i("2017/4/10","+++ACTION_OUTSIDE+++");
			break;
		
		default:
			break;
		}
		
		return true;
	}
	
}
