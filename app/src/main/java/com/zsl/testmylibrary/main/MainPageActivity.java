package com.zsl.testmylibrary.main;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.zsl.testmylibrary.R;
import com.zsl.testmylibrary.base.BaseActivity;
import com.zsl.testmylibrary.main.fragment.FirstFragment;
import com.zsl.testmylibrary.main.fragment.FiveFragment;
import com.zsl.testmylibrary.main.fragment.FourthFragment;
import com.zsl.testmylibrary.main.fragment.ThirdFragment;
import com.zsl.testmylibrary.main.fragment.SecondFragment;

/**
 * 首页页面
 */
public class MainPageActivity extends BaseActivity {

    private FragmentTransaction beginTransaction;
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private FourthFragment fourthFragment;
    private FiveFragment fiveFragment;
    private LinearLayout id_tab_one, id_tab_two, id_tab_three, id_tab_four, id_tab_five;
    private ImageButton id_tab_one_img, id_tab_two_img, id_tab_three_img, id_tab_four_img, id_tab_five_img;
    private TextView tv_tab_one, tv_tab_two, tv_tab_three, tv_tab_four, tv_tab_five;

    @Override
    public int getLayout() {
        return R.layout.activity_main_page;
    }

    @Override
    public void initView() {
        id_tab_one_img = findViewById(R.id.id_tab_one_img);
        id_tab_two_img = findViewById(R.id.id_tab_two_img);
        id_tab_three_img = findViewById(R.id.id_tab_three_img);
        id_tab_four_img = findViewById(R.id.id_tab_four_img);
        id_tab_five_img = findViewById(R.id.id_tab_five_img);

        tv_tab_one = findViewById(R.id.tv_tab_one);
        tv_tab_two = findViewById(R.id.tv_tab_two);
        tv_tab_three = findViewById(R.id.tv_tab_three);
        tv_tab_four = findViewById(R.id.tv_tab_four);
        tv_tab_five = findViewById(R.id.tv_tab_five);

        id_tab_one = findViewById(R.id.id_tab_one);
        id_tab_two = findViewById(R.id.id_tab_two);
        id_tab_three = findViewById(R.id.id_tab_three);
        id_tab_four = findViewById(R.id.id_tab_four);
        id_tab_five = findViewById(R.id.id_tab_five);
    }

    @Override
    public void initEvent() {
        setFragment(0);
    }

    @Override
    public void setListener() {
        super.setListener();
        id_tab_one.setOnClickListener(this);
        id_tab_two.setOnClickListener(this);
        id_tab_three.setOnClickListener(this);
        id_tab_four.setOnClickListener(this);
        id_tab_five.setOnClickListener(this);
    }

    /**
     * 设置Fragment
     * 其他地方可发送通知来执行该方法改变tab选中
     *
     * @param index: 下标
     */
    private void setFragment(int index) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        beginTransaction = fragmentManager.beginTransaction();
        hideFragment();
        resetImgs();
        switch (index) {
            case 0:
                //首页
                if (firstFragment == null) {
                    firstFragment = new FirstFragment();
                    beginTransaction.add(R.id.fl_layout, firstFragment);
                } else {
                    beginTransaction.show(firstFragment);
                }
                break;
            case 1:
                //发现
                if (secondFragment == null) {
                    secondFragment = new SecondFragment();
                    beginTransaction.add(R.id.fl_layout, secondFragment);
                } else {
                    beginTransaction.show(secondFragment);
                }
                break;
            case 2:
                //我的
                if (thirdFragment == null) {
                    thirdFragment = new ThirdFragment();
                    beginTransaction.add(R.id.fl_layout, thirdFragment);
                } else {
                    beginTransaction.show(thirdFragment);
                }
                break;
            case 3:
                //我的
                if (fourthFragment == null) {
                    fourthFragment = new FourthFragment();
                    beginTransaction.add(R.id.fl_layout, fourthFragment);
                } else {
                    beginTransaction.show(fourthFragment);
                }
                break;
            case 4:
                //我的
                if (fiveFragment == null) {
                    fiveFragment = new FiveFragment();
                    beginTransaction.add(R.id.fl_layout, fiveFragment);
                } else {
                    beginTransaction.show(fiveFragment);
                }
                break;
        }
        beginTransaction.commit();
        selectTab(index);
    }

    /**
     * 改变底部图片和文字的状态
     *
     * @param i: 下标
     */

    private void selectTab(int i) {
        //根据点击的Tab设置对应的ImageButton为绿色
        switch (i) {
            case 0:
                selected(id_tab_one,id_tab_one_img,tv_tab_one);
                break;
            case 1:
                selected(id_tab_two,id_tab_two_img,tv_tab_two);
                break;
            case 2:
                selected(id_tab_three,id_tab_three_img,tv_tab_three);
                break;
            case 3:
                selected(id_tab_four,id_tab_four_img,tv_tab_four);
                break;
            case 4:
                selected(id_tab_five,id_tab_five_img,tv_tab_five);
                break;
            default:
                break;
        }

    }

    /**
     * 隐藏所有Fragment
     */
    private void hideFragment() {
        if (firstFragment != null) {
            beginTransaction.hide(firstFragment);
        }
        if (secondFragment != null) {
            beginTransaction.hide(secondFragment);
        }
        if (thirdFragment != null) {
            beginTransaction.hide(thirdFragment);
        }
        if (fourthFragment != null) {
            beginTransaction.hide(fourthFragment);
        }
        if (fiveFragment != null) {
            beginTransaction.hide(fiveFragment);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_tab_one:
                setFragment(0);
                break;
            case R.id.id_tab_two:
                setFragment(1);
                break;
            case R.id.id_tab_three:
                setFragment(2);
                break;
            case R.id.id_tab_four:
                setFragment(3);
                break;
            case R.id.id_tab_five:
                setFragment(4);
                break;
            default:
                break;
        }
    }

    private void selected(View v1, View v2, View v3) {
        v1.setSelected(true);
        v2.setSelected(true);
        v3.setSelected(true);
    }

    //将四个ImageButton设置为灰色
    private void resetImgs() {
        id_tab_one_img.setSelected(false);
        id_tab_two_img.setSelected(false);
        id_tab_three_img.setSelected(false);
        id_tab_four_img.setSelected(false);
        id_tab_five_img.setSelected(false);
        tv_tab_one.setSelected(false);
        tv_tab_two.setSelected(false);
        tv_tab_three.setSelected(false);
        tv_tab_four.setSelected(false);
        tv_tab_five.setSelected(false);
        id_tab_one.setSelected(false);
        id_tab_two.setSelected(false);
        id_tab_three.setSelected(false);
        id_tab_four.setSelected(false);
        id_tab_five.setSelected(false);
    }
}
