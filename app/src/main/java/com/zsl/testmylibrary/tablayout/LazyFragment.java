package com.zsl.testmylibrary.tablayout;

import android.view.View;
import android.widget.TextView;

import com.zsl.testmylibrary.R;
import com.zsl.testmylibrary.base.BaseFragment;

/**
 * @Author: zsl
 * @Email: zsl@qq.com
 * @Date: 2021/8/13
 * <p>
 * @Desc:
 */
public class LazyFragment extends BaseFragment {

    private TextView tvTabName;
    private String bundleTabName = "";

    @Override
    public int getLayout() {
        return R.layout.fragment_lazy;
    }

    @Override
    public void initView(View view) {
        tvTabName = view.findViewById(R.id.tv_tab_name);
    }

    @Override
    public void getData() {
        if (getArguments() != null) {
            bundleTabName = getArguments().getString("bundle_tab");
        }
    }

    @Override
    public void initEvent() {
        tvTabName.setText(bundleTabName);
    }

    @Override
    public void onClick(View view) {

    }
}
