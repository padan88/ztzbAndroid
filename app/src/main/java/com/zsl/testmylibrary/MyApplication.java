package com.zsl.testmylibrary;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.CrashUtils;
import com.zsl.mylibrary.StartLibrary;


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
        StartLibrary.init(context);;
    }
    public static Context getContext(){
        return  context;
    }
}
