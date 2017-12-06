package com.example.liutao.screen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1= (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2= (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3= (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn1:

                Intent intent1=new Intent(this,PercentFrameLayout.class);
                startActivity(intent1);

                break;

            case R.id.btn2:

                Intent intent2=new Intent(this,PercentRelativeLayout.class);
                startActivity(intent2);

                break;

            case R.id.btn3:

                Intent intent3=new Intent(this,PercentLinearLayout.class);
                startActivity(intent3);

                break;

            default:
                break;
        }

    }
}
