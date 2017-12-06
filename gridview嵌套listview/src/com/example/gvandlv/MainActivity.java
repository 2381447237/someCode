package com.example.gvandlv;

import java.util.ArrayList;
import java.util.List;

import com.example.gvandlv.adapter.GvAdapter;
import com.example.gvandlv.adapter.LvAdapter;
import com.example.gvandlv.entity.GvContent;
import com.example.gvandlv.entity.GvContent.LvContent;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.GridView;

public class MainActivity extends Activity {

	private GridView gv;
	private GvAdapter adapter;
	private List<GvContent> data=new ArrayList<GvContent>();
	
	private List<LvContent> lvData1=new ArrayList<LvContent>();
	private List<LvContent> lvData2=new ArrayList<LvContent>();
	private List<LvContent> lvData3=new ArrayList<LvContent>();
	private List<LvContent> lvData4=new ArrayList<LvContent>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        gv=(GridView) findViewById(R.id.gv);
        setLvData();
        someData();
        adapter=new GvAdapter(data,this);
        gv.setAdapter(adapter);
    }
    
    private void setLvData(){
             for(int i=1;i<15;i++){
            	 
    		lvData1.add(new LvContent("标题1内容"+i));
    		lvData2.add(new LvContent("标题2内容"+i));
    		lvData3.add(new LvContent("标题3内容"+i));
    		lvData4.add(new LvContent("标题4内容"+i));
    	}
    }
    
    private void someData(){
    	
    	for(int i=1;i<5;i++){
    		if(i==1){
    		data.add(new GvContent("标题"+i,lvData1));
    		}else if(i==2){
    			data.add(new GvContent("标题"+i,lvData2));
    		}else if(i==3){
    			data.add(new GvContent("标题"+i,lvData3));
    		}else{
    			data.add(new GvContent("标题"+i,lvData4));
    		}
    	}
    	
    }
    
}
