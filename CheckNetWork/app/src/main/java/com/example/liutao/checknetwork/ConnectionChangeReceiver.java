package com.example.liutao.checknetwork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

/**
 * Created by liutao on 2017/5/18.
 */

public class ConnectionChangeReceiver extends BroadcastReceiver{

    MainActivity myContext;

    @Override
    public void onReceive(Context context, Intent intent) {

        myContext=(MainActivity) context;

        if(isNetworkAvailable(myContext)){

            Toast.makeText(myContext,"有网",Toast.LENGTH_SHORT).show();

        }else{

            Toast.makeText(myContext,"没网",Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isNetworkAvailable(MainActivity activity){
        Context context = activity.getApplicationContext();

        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {

            return false;

        } else {

            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0) {

                for (int i = 0; i < networkInfo.length; i++) {
					/*
					 * System.out.println(i + "===状态===" +
					 * networkInfo[i].getState()); System.out.println(i +
					 * "===类型===" + networkInfo[i].getTypeName());
					 */
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {

                        // 判断当前的wifi的ip和服务器的ip是否相同
                        // //=======================================================================

                        // 获取wifi服务
                        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                        // 判断wifi是否开启
                        if (!wifiManager.isWifiEnabled()) {
                            wifiManager.setWifiEnabled(true);
                        }

                        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                        int ipAddress = wifiInfo.getIpAddress();
                        String ip = intToIp(ipAddress);

                        return true;
                    }
                }

            }

        }

        return false;
    }


    // 得到当前的wifiIP地址
    private String intToIp(int i) {

        return (i & 0Xff) + "." + ((i >> 8) & 0Xff) + "." + ((i >> 16) & 0xff)
                + "." + (i >> 24 & 0xff);

    }


}
