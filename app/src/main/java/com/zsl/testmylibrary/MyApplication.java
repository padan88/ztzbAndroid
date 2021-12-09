package com.zsl.testmylibrary;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.zsl.mylibrary.StartLibrary;
import com.zsl.testmylibrary.config.AppSettings;


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

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        StartLibrary.init(context, AppSettings.AppPath,AppSettings.Base_Host);
        MultiDex.install(this);
    }
    public static Context getContext(){
        return  context;
    }
}
