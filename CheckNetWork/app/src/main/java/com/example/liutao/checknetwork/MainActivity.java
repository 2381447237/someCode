package com.example.liutao.checknetwork;

import android.app.Activity;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private ConnectionChangeReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver();
    }

    // 注册Receiver
    private void registerReceiver() {

        IntentFilter filter = new IntentFilter(
                ConnectivityManager.CONNECTIVITY_ACTION);

        myReceiver = new ConnectionChangeReceiver();

        this.registerReceiver(myReceiver, filter);

    }

    // 注销Receiver
    private void unregisterReceiver() {

        this.unregisterReceiver(myReceiver);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
