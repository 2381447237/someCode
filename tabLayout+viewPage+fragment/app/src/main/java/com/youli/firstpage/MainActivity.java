package com.youli.firstpage;

import android.app.Activity;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.youli.firstpage.fragment.BigFragmentFour;
import com.youli.firstpage.fragment.BigFragmentOne;
import com.youli.firstpage.fragment.BigFragmentThree;
import com.youli.firstpage.fragment.BigFragmentTwo;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FragmentManager fm=this.getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        BigFragmentOne f1=new BigFragmentOne();
        ft.add(R.id.fl,f1);
        ft.commit();

        mRadioGroup= (RadioGroup) findViewById(R.id.rg);
        mRadioGroup.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        switch (checkedId){

            case R.id.rb_main:
                BigFragmentOne f1=new BigFragmentOne();
                ft.replace(R.id.fl,f1);
                ft.commit();
                break;

            case R.id.rb_shop:
                BigFragmentTwo f2=new BigFragmentTwo();
                ft.replace(R.id.fl,f2);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case R.id.rb_location:
                BigFragmentThree f3=new BigFragmentThree();
                ft.replace(R.id.fl,f3);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case R.id.rb_setting:
                BigFragmentFour f4=new BigFragmentFour();
                ft.replace(R.id.fl,f4);
                ft.addToBackStack(null);
                ft.commit();
                break;
        }

    }


    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        //Process.killProcess(Process.myPid());
        finish();
    }
}
