package com.zsl.mylibrary.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zsl.mylibrary.activityUtils.ActivityUtil;

/**
 * @Description:activity 基础类
 * @PackgeName: com.zsl.testmylibrary.Activity
 * @ClassName: BaseActivity
 * @Author: Zsl
 * @Date: 2021/8/25 15:12
 * @Version: V 1.0
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            //如果系统回收掉了当前的Activity,但是保留了Fragment
            // 当Activity被重新初始化时,此时,系统保存的Fragment的getActivity为空
            //所以要移除旧的Fragment,重新初始化新的Fragment
            savedInstanceState.remove("android:support:fragments");
        }
        setContentView(getLayout());
        ActivityUtil.getInstance().addActivity(this);
        initView();
        initEvent();
        getData();
        setListener();

    }

    /**
     * 获取调用layout
     * @return
     */
    public abstract int getLayout();

    /**
     * 获取改变状态栏
     */
    public void initStatusBar(){};

    /**
     * 绑定view
     */
    public abstract void initView();

    /**
     * 获取跳转传参或者缓存去指
     */
    public abstract void getData();

    /**
     * 处理业务逻辑
     */
    public abstract void initEvent();

    /**
     * 事件监听
     */
    public abstract void setListener();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtil.getInstance().removeActivity(this);
    }
}
