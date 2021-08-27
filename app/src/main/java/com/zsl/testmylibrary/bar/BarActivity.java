package com.zsl.testmylibrary.bar;

import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.BarUtils;
import com.zsl.testmylibrary.R;
import com.zsl.testmylibrary.base.BaseActivity;

/**
 * @Description:一句话描述这个类
 * @PackgeName: com.zsl.testmylibrary.bar
 * @ClassName: BarActivity
 * @Author: Zsl
 * @Date: 2021/8/27 10:24
 * @Version: V 1.0
 */
public class BarActivity extends BaseActivity {

    private TextView bar;
    private boolean isShow  = false;
    private int height;

    @Override
    public int getLayout() {
        return R.layout.activity_bar;
    }

    @Override
    public void initStatusBar() {
        super.initStatusBar();
        height = BarUtils.getActionBarHeight();
//        BarUtils.setStatusBarLightMode(this,isShow);
    }

    @Override
    public void initView() {
      bar = findViewById(R.id.bar);
    }

    @Override
    public void initEvent() {
     bar.setText(height+"px");
    }

    @Override
    public void setListener() {
        super.setListener();
        bar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.bar:
               BarUtils.setStatusBarVisibility(this,isShow);
               isShow = !isShow;
               break;
       }
    }
}
