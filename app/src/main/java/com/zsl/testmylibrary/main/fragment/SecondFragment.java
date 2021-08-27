package com.zsl.testmylibrary.main.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zsl.testmylibrary.R;
import com.zsl.testmylibrary.base.BaseFragment;

/**
 * @Author: zsl
 * @Email: zsl@qq.com
 * @Date: 2020/11/13
 * <p>
 * @Desc:
 */
public class SecondFragment extends BaseFragment {

    private TextView tvDesc;

    @Override
    public int getLayout() {
        return R.layout.fragment_main ;
    }

    @Override
    public void initView(View view) {
        tvDesc = view.findViewById(R.id.tv_desc);
    }

    @Override
    public void initEvent() {
        tvDesc.setText("我是资料");
    }

    @Override
    public void onClick(View view) {

    }
}