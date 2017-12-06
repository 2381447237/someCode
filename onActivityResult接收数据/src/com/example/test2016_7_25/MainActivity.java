package com.example.test2016_7_25;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button btn;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		btn = (Button) findViewById(R.id.btn1);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Activity2.class);
				startActivityForResult(intent, 0);
			}
		});
		tv = (TextView) findViewById(R.id.tv1);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0 && resultCode == 0) {

			String text = data.getStringExtra("data");
			tv.setText(text);

		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}
