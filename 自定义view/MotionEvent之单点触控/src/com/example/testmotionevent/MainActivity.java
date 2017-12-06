package com.example.testmotionevent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button btn1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        btn1=(Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.btn1:
			
			Intent intent=new Intent(MainActivity.this,SingleTouchActivity.class);
			startActivity(intent);
			
			break;

		default:
			break;
		}
	}
}
