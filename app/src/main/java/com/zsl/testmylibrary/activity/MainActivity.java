package com.zsl.testmylibrary.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.zsl.testmylibrary.base.BaseActivity;
import com.zsl.mylibrary.toastUtils.ToastUtil;
import com.zsl.testmylibrary.R;
import com.zsl.testmylibrary.glide.GlideUseActivity;

/**
 * @Description:一句话描述这个类
 * @PackgeName: com.zsl.testmylibrary.activity
 * @ClassName: mainActivity
 * @Author: Zsl
 * @Date: 2021/8/25 15:28
 * @Version: V 1.0
 */
public class MainActivity extends BaseActivity {
    private Button https, act, crp, dialog, glide, gson, bar;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        https = findViewById(R.id.https);
        act = findViewById(R.id.act);
        crp = findViewById(R.id.cryption);
        dialog = findViewById(R.id.dialog);
        glide = findViewById(R.id.glide);
        gson = findViewById(R.id.gson);
        bar = findViewById(R.id.statusBar);
    }

    @Override
    public void getData() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void setListener() {
        https.setOnClickListener(this);
        act.setOnClickListener(this);
        crp.setOnClickListener(this);
        dialog.setOnClickListener(this);
        glide.setOnClickListener(this);
        gson.setOnClickListener(this);
        bar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.https:
               startActivity(new Intent(this,HttpsTestActivity.class));
                break;
            case R.id.act:
                ToastUtil.showLongToastCenter(this,"activity");
                break;
            case R.id.cryption:
                ToastUtil.showShortToastTop(this,"cryption");
                break;
            case R.id.dialog:
                ToastUtil.showShortToastTop(this,"dialog");
                break;
            case R.id.glide:
                startActivity(new Intent(this, GlideUseActivity.class));
                break;
            case R.id.gson:
                ToastUtil.showShortToastTop(this,"gson");
                break;
            case R.id.statusBar:
                ToastUtil.showImgToast(this,"statusBar",R.drawable.ic_launcher_background);
                break;
        }
    }
}
