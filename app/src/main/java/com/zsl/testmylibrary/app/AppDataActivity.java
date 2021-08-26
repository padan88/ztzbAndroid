package com.zsl.testmylibrary.app;

import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;
import com.zsl.testmylibrary.R;
import com.zsl.testmylibrary.base.BaseActivity;

/**
 * @Description:一句话描述这个类
 * @PackgeName: com.zsl.testmylibrary.app
 * @ClassName: AppDataActivity
 * @Author: Zsl
 * @Date: 2021/8/26 17:49
 * @Version: V 1.0
 */
public class AppDataActivity extends BaseActivity {
    private TextView text;
    private String s;

    @Override
    public int getLayout() {
        return R.layout.activity_app;
    }

    @Override
    public void initView() {
       text = findViewById(R.id.text);
    }

    @Override
    public void initEvent() {
        s = AppUtils.getAppPackageName();
        s += "\n=======name\n"+AppUtils.getAppName();
        s += "\n=======path\n"+AppUtils.getAppPath();
        s += "\n=======iNFO\n"+AppUtils.getAppInfo();
        s += "\n=======V\n"+AppUtils.getAppVersionName();
        s += "\n=======MD5\n"+AppUtils.getAppSignaturesMD5();
        text.setText(s);
    }

    @Override
    public void setListener() {
        super.setListener();
        text.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        text.setText("");
    }
}
