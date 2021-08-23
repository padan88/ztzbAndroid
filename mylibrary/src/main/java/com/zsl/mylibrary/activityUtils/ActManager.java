package com.zsl.mylibrary.activityUtils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 退出登录——类管理方法
 * @PackgeName: com.ztzb.paperlessmeetting.untils
 * @ClassName: ActivityCollector
 * @Author: Zsl
 * @Date: 2021/8/10 9:24
 * @Version: V 1.0
 */
public class ActManager {

    private ActManager() {}

    private static List<Activity> actList = new ArrayList<>();

    public static void addActivity(Activity act) {
        actList.add(act);
    }

    public static void removeActivity(Activity act) {
        actList.remove(act);
    }

    public static void finishAll() {
        for (Activity act : actList) {
            if (!act.isFinishing()) {
                act.finish();
            }
        }
    }

}
