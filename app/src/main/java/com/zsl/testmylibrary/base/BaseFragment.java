package com.zsl.testmylibrary.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @Description:一句话描述这个类
 * @PackgeName: com.zsl.testmylibrary.base
 * @ClassName: BaseFragment
 * @Author: Zsl
 * @Date: 2021/8/27 8:38
 * @Version: V 1.0
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener{
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayout(), container, false);
        initView(view);
        getData();
        initEvent();
        setListener();
        return view;
    }

    /**
     * 获取布局样式
     * @return
     */
    public abstract int getLayout();

    /**
     * view初始化
     * @param view
     */
    protected abstract void initView(View view);

    /**
     * 处理业务逻辑
     */
    public abstract void initEvent();

    /**
     * 初始化启动数据
     */
    public void getData(){};

    /**
     * 设置监听
     */
    public void setListener(){};
}
