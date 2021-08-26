package com.zsl.testmylibrary.glide;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.zsl.mylibrary.glideUtils.GlideUtil;
import com.zsl.testmylibrary.R;
import com.zsl.testmylibrary.base.BaseActivity;


/**
 * Glide 使用
 */
public class GlideUseActivity extends BaseActivity {

    private static final String imgUrl = "https://library-collection.oss-cn-beijing.aliyuncs.com/img/glideuse.png";

    private ImageView ivDefault;
    private ImageView ivCircle;
    private ImageView ivCorner;


    @Override
    public int getLayout() {
        return R.layout.activity_glide;
    }

    @Override
    public void initView() {
        ivDefault = findViewById(R.id.iv_default);
        ivCircle = findViewById(R.id.iv_circle);
        ivCorner = findViewById(R.id.iv_corner);

    }

    @Override
    public void initEvent() {
        GlideUtil.loadImage(imgUrl, ivDefault, getResources().getDrawable(R.drawable.ic_launcher_foreground));
        GlideUtil.loadCircleImage(imgUrl, ivCircle, getResources().getDrawable(R.drawable.ic_launcher_foreground));
        GlideUtil.loadCornerImage(imgUrl, ivCorner, 20, getResources().getDrawable(R.drawable.ic_launcher_foreground));
    }

    @Override
    public void onClick(View view) {

    }
}
