package com.example.testrecyclerview2017_4_6;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;

public class AllActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_all);
	}
	
	
}
