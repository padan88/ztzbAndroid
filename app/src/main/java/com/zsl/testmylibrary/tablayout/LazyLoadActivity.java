package com.zsl.testmylibrary.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.zsl.testmylibrary.R;
import com.zsl.testmylibrary.base.BaseActivity;

/**
 * 懒加载的Activity
 */
public class LazyLoadActivity extends BaseActivity {


    private String[] tabArray = new String[]{"推荐", "关注", "娱乐", "国内", "军事", "财经"};
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public int getLayout() {
        return R.layout.activity_lazy_load;
    }

    @Override
    public void initView() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
    }

    @Override
    public void initEvent() {
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(tabArray.length);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public void onClick(View view) {

    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabArray[position];
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            //传递数据
            LazyFragment lazyFragment = new LazyFragment();
            Bundle bundle = new Bundle();
            bundle.putString("bundle_tab", tabArray[position]);
            lazyFragment.setArguments(bundle);
            return lazyFragment;
        }

        @Override
        public int getCount() {
            return tabArray.length;
        }
    }

}
