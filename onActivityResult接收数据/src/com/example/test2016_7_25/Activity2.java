package com.example.test2016_7_25;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends Activity {

	private Button btn;
	private EditText et;
	private String content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity2);

		et = (EditText) findViewById(R.id.et);
		
		btn = (Button) findViewById(R.id.btn2);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				content = et.getText().toString().trim();
				Intent intent2=new Intent();
				intent2.putExtra("data", content);
				setResult(0,intent2);
				finish();
			}
		});

		
	}

}
