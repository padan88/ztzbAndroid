package com.zsl.testmylibrary.main.fragment;

import android.view.View;
import android.widget.TextView;

import com.zsl.testmylibrary.R;
import com.zsl.testmylibrary.base.BaseFragment;

/**
 * @Description:一句话描述这个类
 * @PackgeName: com.zsl.testmylibrary.main.fragment
 * @ClassName: FiveFragment
 * @Author: Zsl
 * @Date: 2021/8/27 9:52
 * @Version: V 1.0
 */
public class FiveFragment extends BaseFragment {

    private TextView tvDesc;

    @Override
    public int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView(View view) {
        tvDesc = view.findViewById(R.id.tv_desc);
    }

    @Override
    public void initEvent() {
        tvDesc.setText("我是语音");
    }

    @Override
    public void onClick(View view) {

    }
}
