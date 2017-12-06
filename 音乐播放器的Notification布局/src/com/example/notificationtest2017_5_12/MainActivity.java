package com.example.notificationtest2017_5_12;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends Activity {
	/** 是否在播放*/
	public boolean isPlay = false;
	private Button btn;
	/** 通知栏按钮点击事件对应的ACTION */
	public final static String ACTION_BUTTON = "com.notifications.intent.action.ButtonClick";
	
	public final static String INTENT_BUTTONID_TAG = "ButtonId";
	/** 上一首 按钮点击 ID */
	public final static int BUTTON_PREV_ID = 1;
	/** 播放/暂停 按钮点击 ID */
	public final static int BUTTON_PALY_ID = 2;
	/** 下一首 按钮点击 ID */
	public final static int BUTTON_NEXT_ID = 3;
	
	/** 通知栏按钮广播 */
	public ButtonBroadcastReceiver bReceiver;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initButtonReceiver();
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Toast.makeText(MainActivity.this,"233",0).show();
				
				showButtonNotify();
			}
		});
    }
    
    /**
	 * 带按钮的通知栏
	 */
    public void showButtonNotify(){
    	
    	NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    	
		NotificationCompat.Builder mBuilder = new Builder(this);
		RemoteViews mRemoteViews = new RemoteViews(getPackageName(), R.layout.view_custom_button);
		mRemoteViews.setImageViewResource(R.id.custom_song_icon, R.drawable.sing_icon);
		//API3.0 以上的时候显示按钮，否则消失
		mRemoteViews.setTextViewText(R.id.tv_custom_song_singer, "周杰伦");
		mRemoteViews.setTextViewText(R.id.tv_custom_song_name, "七里香");
		//如果版本号低于（3。0），那么不显示按钮
		if(BaseTools.getSystemVersion() <= 9){
			mRemoteViews.setViewVisibility(R.id.ll_custom_button, View.GONE);
		}else{
			mRemoteViews.setViewVisibility(R.id.ll_custom_button, View.VISIBLE);
			//
			if(isPlay){
				mRemoteViews.setImageViewResource(R.id.btn_custom_play, R.drawable.btn_pause);
			}else{
				mRemoteViews.setImageViewResource(R.id.btn_custom_play, R.drawable.btn_play);
			}
		}

		//点击的事件处理
		Intent buttonIntent = new Intent(ACTION_BUTTON);
		/* 上一首按钮 */
		buttonIntent.putExtra(INTENT_BUTTONID_TAG, BUTTON_PREV_ID);
		//这里加了广播，所及INTENT的必须用getBroadcast方法
		PendingIntent intent_prev = PendingIntent.getBroadcast(this, 1, buttonIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		mRemoteViews.setOnClickPendingIntent(R.id.btn_custom_prev, intent_prev);
		/* 播放/暂停  按钮 */
		buttonIntent.putExtra(INTENT_BUTTONID_TAG, BUTTON_PALY_ID);
		PendingIntent intent_paly = PendingIntent.getBroadcast(this, 2, buttonIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		mRemoteViews.setOnClickPendingIntent(R.id.btn_custom_play, intent_paly);
		/* 下一首 按钮  */
		buttonIntent.putExtra(INTENT_BUTTONID_TAG, BUTTON_NEXT_ID);
		PendingIntent intent_next = PendingIntent.getBroadcast(this, 3, buttonIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		mRemoteViews.setOnClickPendingIntent(R.id.btn_custom_next, intent_next);
		
		mBuilder.setContent(mRemoteViews)
				.setContentIntent(getDefalutIntent(Notification.FLAG_ONGOING_EVENT))
				.setWhen(System.currentTimeMillis())// 通知产生的时间，会在通知信息里显示
				.setTicker("正在播放")
				.setPriority(Notification.PRIORITY_DEFAULT)// 设置该通知优先级
				.setOngoing(true)
				.setSmallIcon(R.drawable.sing_icon);
		Notification notify = mBuilder.build();
		notify.flags = Notification.FLAG_ONGOING_EVENT;
		//会报错，还在找解决思路
//		notify.contentView = mRemoteViews;
//		notify.contentIntent = PendingIntent.getActivity(this, 0, new Intent(), 0);
		mNotificationManager.notify(1, notify);
	}
      
    /**
	 * @获取默认的pendingIntent,为了防止2.3及以下版本报错
	 * @flags属性:  
	 * 在顶部常驻:Notification.FLAG_ONGOING_EVENT  
	 * 点击去除： Notification.FLAG_AUTO_CANCEL 
	 */
	public PendingIntent getDefalutIntent(int flags){
		PendingIntent pendingIntent= PendingIntent.getActivity(this, 1, new Intent(), flags);
		return pendingIntent;
	}
    
	/** 带按钮的通知栏点击广播接收 */
	public void initButtonReceiver(){
		bReceiver = new ButtonBroadcastReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(ACTION_BUTTON);
		registerReceiver(bReceiver, intentFilter);
	}
	
	
	/**
	 *	 广播监听按钮点击时间 
	 */
	public class ButtonBroadcastReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String action = intent.getAction();
			if(action.equals(ACTION_BUTTON)){
				//通过传递过来的ID判断按钮点击属性或者通过getResultCode()获得相应点击事件
				int buttonId = intent.getIntExtra(INTENT_BUTTONID_TAG, 0);
				switch (buttonId) {
				case BUTTON_PREV_ID:
					//Log.d(TAG , "上一首");
					Toast.makeText(getApplicationContext(), "上一首", Toast.LENGTH_SHORT).show();
					break;
				case BUTTON_PALY_ID:
					String play_status = "";
					isPlay = !isPlay;
					if(isPlay){
						play_status = "开始播放";
					}else{
						play_status = "已暂停";
					}
					showButtonNotify();
					//Log.d(TAG , play_status);
					Toast.makeText(getApplicationContext(), play_status, Toast.LENGTH_SHORT).show();
					break;
				case BUTTON_NEXT_ID:
				//	Log.d(TAG , "下一首");
					Toast.makeText(getApplicationContext(), "下一首", Toast.LENGTH_SHORT).show();
					break;
				default:
					break;
				}
			}
		}
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		if(bReceiver != null){
			unregisterReceiver(bReceiver);
		}
		super.onDestroy();
	}
	
}
