package com.zsl.testmylibrary;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;

import com.zsl.mylibrary.StartLibrary;
import com.zsl.mylibrary.activityUtils.ActivityUtil;
import com.zsl.testmylibrary.receiver.ExitBroadcastReceiver;
import com.zsl.testmylibrary.activity.MainActivity;


/**
 * @Description:一句话描述这个类
 * @PackgeName: com.zsl.testmylibrary
 * @ClassName: MyApplication
 * @Author: Zsl
 * @Date: 2021/8/20 23:41
 * @Version: V 1.0
 */
public class MyApplication extends Application {
    private static Context context;
    private boolean isCarsh = true;
    private ExitBroadcastReceiver locallReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        StartLibrary.init(context);
        
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.admin.loginout");
        locallReceiver = new ExitBroadcastReceiver();
        registerReceiver(locallReceiver, intentFilter);
    }
    public static Context getContext(){
        return  context;
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        // 取消注册广播接收器
        unregisterReceiver(locallReceiver);
    }
}
