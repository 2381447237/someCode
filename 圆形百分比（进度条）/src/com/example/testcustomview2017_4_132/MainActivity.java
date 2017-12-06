package com.example.testcustomview2017_4_132;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button mButton;
    private CirclePerecentView mCirclePercentView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        mCirclePercentView=(CirclePerecentView) findViewById(R.id.circleView);
        mButton=(Button) findViewById(R.id.button);
        mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int n=(int) (Math.random()*100);
				mCirclePercentView.setPercent(n);
				
			}
		});
    }
}
