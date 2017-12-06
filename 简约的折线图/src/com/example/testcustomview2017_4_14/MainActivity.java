package com.example.testcustomview2017_4_14;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends Activity {

	private CustomView cv;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        cv=(CustomView) findViewById(R.id.cv);
        String[] xItem={"1","2","3","4","5","6","7"};
        String[] yItem={"50K","40K","30K","20K","10K"};
        
        cv.setXItem(xItem);
        cv.setYItem(yItem);
        HashMap<Integer,Integer> pointMap=new HashMap();
        for(int i=0;i<xItem.length;i++){
        	pointMap.put(i, (int) (Math.random()*5));
        }
        cv.setData(pointMap);
    }
}
