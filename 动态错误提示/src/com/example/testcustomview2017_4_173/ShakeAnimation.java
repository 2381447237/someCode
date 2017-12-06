package com.example.testcustomview2017_4_173;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ShakeAnimation extends Animation{

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		t.getMatrix().setTranslate((float)Math.sin(interpolatedTime*50)*20,0);
		super.applyTransformation(interpolatedTime, t);
	}
	
}
