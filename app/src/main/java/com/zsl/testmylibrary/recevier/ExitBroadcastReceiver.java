package com.zsl.testmylibrary.recevier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.zsl.mylibrary.activityUtils.ActivityUtil;
import com.zsl.testmylibrary.activity.MainActivity;

/**
 * @Description: 退出系统——广播类
 * @PackgeName: com.ztzb.paperlessmeetting.untils
 * @ClassName: LoginOutBroadcastReceiver
 * @Author: Zsl
 * @Date: 2021/8/10 9:28
 * @Version: V 1.0
 */
public class ExitBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ActivityUtil.getInstance().finishAllActivity();  // 销毁所有活动
        Intent intent1 = new Intent(context, MainActivity.class);
        context.startActivity(intent1);
    }
}
