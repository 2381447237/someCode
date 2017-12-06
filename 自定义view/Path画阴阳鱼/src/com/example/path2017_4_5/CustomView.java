package com.example.path2017_4_5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View{
	
	private Paint mDeafultPaint;
	private Path path1,path2,path3,path4;
	
	public CustomView(Context context) {
		this(context,null);
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mDeafultPaint=new Paint();
		mDeafultPaint.setAntiAlias(true);
		path1=new Path();
		path2=new Path();
		path3=new Path();
		path4=new Path();
		
	}

@SuppressLint("NewApi") 
@Override
protected void onDraw(Canvas canvas) {
	super.onDraw(canvas);
	
	canvas.translate(getWidth()/2,getHeight()/2);
	
	path1.addCircle(0,0,200,Path.Direction.CW);
	path2.addRect(0,-200,200,200,Path.Direction.CW);
	path3.addCircle(0,-100,100,Path.Direction.CW);
	path4.addCircle(0,100,100,Path.Direction.CCW);
	
	//op()布尔运算
	path1.op(path2, Path.Op.DIFFERENCE);//差集
	path1.op(path3, Path.Op.UNION);//并集
	path1.op(path4, Path.Op.DIFFERENCE);
	//交集INTERSECT
	//差集REVERSE_DIFFERENCE
	//异或XOR
	canvas.drawPath(path1,mDeafultPaint);
}


}
