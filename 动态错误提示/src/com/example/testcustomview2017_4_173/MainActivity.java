package com.example.testcustomview2017_4_173;


import com.example.testcustomview2017_4_173.CustomView.StopCustomViewListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends Activity {

	private CustomView cv;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        cv=(CustomView) findViewById(R.id.cv);
        
        cv.setStopCustomViewListener(new StopCustomViewListener() {
			
			@Override
			public void StopCustomView(View v) {
			 
				ShakeAnimation sa=new ShakeAnimation();
				sa.setDuration(1000);
				v.startAnimation(sa);
			}
		});
        
        cv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				cv.ClearData();
			}
		});

    }
    
    
}
