package com.zsl.mylibrary.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorRes;

import com.blankj.utilcode.util.ConvertUtils;
import com.zsl.mylibrary.R;

/**
 * @Author: 张
 * @Email: zsl@qq.com
 * @Date: 2020/11/216 14:28 PM
 * <p>
 * 自定义ToolBar
 */
public class CommonToolbar extends RelativeLayout {

    /**
     * 没有属性
     */
    public static final int NONE_PROPERTY = -999;

    /**
     * 左边布局类型
     */
    public static final int LEFT_TYPE_NONE = -1;//无
    public static final int LEFT_TYPE_TEXT = 1;//文字
    public static final int LEFT_TYPE_IMAGE = 2;//图片
    public static final int LEFT_TYPE_VIEW = 3;//布局

    /**
     * 左边布局类型
     */
    public static final int TITLE_TYPE_NONE = -1;//无
    public static final int TITLE_TYPE_TEXT = 1;//文字
    public static final int TITLE_TYPE_IMAGE = 2;//图片
    public static final int TITLE_TYPE_VIEW = 3;//布局

    /**
     * 右边布局类型
     */
    public static final int RIGHT_TYPE_NONE = -1;//无
    public static final int RIGHT_TYPE_TEXT = 1;//文字
    public static final int RIGHT_TYPE_IMAGE = 2;//图片
    public static final int RIGHT_TYPE_VIEW = 3;//布局

    /**
     * 分割线是否显示
     */
    public static final int VIEW_GONE = 0;//隐藏
    public static final int VIEW_VISIBLE = 1;//显示


    private TextView tvToolbarTitle;
    private TextView tvToolbarRight;
    private TextView tvToolbarLeft;
    private RelativeLayout rlToolbarRoot;
    private ImageView ivToolbarRight;
    private FrameLayout flToolbarRight;
    private FrameLayout flToolbarLeft;
    private View viewDivider;
    private OnTitleClickListener onTitleClickListener = null;
    private OnLeftClickListener onLeftClickListener = null;
    private OnRightClickListener onRightClickListener = null;
    private ImageView ivToolbarLeft;
    private RelativeLayout rlRightView;
    private RelativeLayout rlLeftView;
    private RelativeLayout rlCenterView;
    private ImageView ivToolbarTitle;
    private FrameLayout flToolbarTitle;

    public CommonToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    /**
     * 初始化视图数据
     *
     * @param context:
     * @param attrs:
     */
    private void initView(Context context, AttributeSet attrs) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_toolbar, this);
        rlToolbarRoot = inflate.findViewById(R.id.rl_toolbar_root);

        rlCenterView = inflate.findViewById(R.id.rl_center_view);
        tvToolbarTitle = inflate.findViewById(R.id.tv_toolbar_title);
        ivToolbarTitle = inflate.findViewById(R.id.iv_toolbar_title);
        flToolbarTitle = inflate.findViewById(R.id.fl_toolbar_title);

        rlLeftView = inflate.findViewById(R.id.rl_left_view);
        tvToolbarLeft = inflate.findViewById(R.id.tv_toolbar_left);
        ivToolbarLeft = inflate.findViewById(R.id.iv_toolbar_left);
        flToolbarLeft = inflate.findViewById(R.id.fl_toolbar_left);


        rlRightView = inflate.findViewById(R.id.rl_right_view);
        tvToolbarRight = inflate.findViewById(R.id.tv_toolbar_right);
        ivToolbarRight = inflate.findViewById(R.id.iv_toolbar_right);
        flToolbarRight = inflate.findViewById(R.id.fl_toolbar_right);
        viewDivider = inflate.findViewById(R.id.view_divider);
        //获取属性值
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommonToolbar);
        //背景颜色类型
        int rootBackground = typedArray.getResourceId(R.styleable.CommonToolbar_toolbarBackground, R.color.white);

        //标题布局类型
        int titleType = typedArray.getInteger(R.styleable.CommonToolbar_toolbarTitleType, TITLE_TYPE_TEXT);
        //标题文字
        String strTitle = typedArray.getString(R.styleable.CommonToolbar_toolbarTitle);
        //标题文字大小
        float titleSize = typedArray.getDimension(R.styleable.CommonToolbar_toolbarTitleSize, ConvertUtils.dp2px(18));
        //标题文字颜色
        int titleColor = typedArray.getColor(R.styleable.CommonToolbar_toolbarTitleColor, getResources().getColor(R.color.black));
        //标题图片
        int titleImg = typedArray.getResourceId(R.styleable.CommonToolbar_toolbarTitleImg, R.drawable.ic_title);
        //标题图片宽度
        float titleImgWidth = typedArray.getDimension(R.styleable.CommonToolbar_toolbarTitleImgWidth, NONE_PROPERTY);
        //标题图片高度
        float titleImgHeight = typedArray.getDimension(R.styleable.CommonToolbar_toolbarTitleImgHeight, NONE_PROPERTY);

        //左边布局类型
        int leftType = typedArray.getInteger(R.styleable.CommonToolbar_toolbarLeftType, LEFT_TYPE_IMAGE);
        //左边图片
        int leftImg = typedArray.getResourceId(R.styleable.CommonToolbar_toolbarLeftImg, R.drawable.ic_back);
        //左边图片宽度
        float leftImgWidth = typedArray.getDimension(R.styleable.CommonToolbar_toolbarLeftImgWidth, NONE_PROPERTY);
        //左边图片高度
        float leftImgHeight = typedArray.getDimension(R.styleable.CommonToolbar_toolbarLeftImgHeight, NONE_PROPERTY);
        //左边文字
        String leftText = typedArray.getString(R.styleable.CommonToolbar_toolbarLeftText);
        //左边文字大小
        float leftTextSize = typedArray.getDimension(R.styleable.CommonToolbar_toolbarLeftTextSize, ConvertUtils.sp2px(15f));
        //左边文字颜色
        int leftTextColor = typedArray.getColor(R.styleable.CommonToolbar_toolbarLeftTextColor, getResources().getColor(R.color.black));

        //右边布局类型
        int rightType = typedArray.getInteger(R.styleable.CommonToolbar_toolbarRightType, RIGHT_TYPE_NONE);
        //右边图片
        int rightImg = typedArray.getResourceId(R.styleable.CommonToolbar_toolbarRightImg, R.drawable.ic_release);
        //右边图片宽度
        float rightImgWidth = typedArray.getDimension(R.styleable.CommonToolbar_toolbarRightImgWidth, NONE_PROPERTY);
        //右边图片高度
        float rightImgHeight = typedArray.getDimension(R.styleable.CommonToolbar_toolbarRightImgHeight, NONE_PROPERTY);
        //右边文字
        String rightText = typedArray.getString(R.styleable.CommonToolbar_toolbarRightText);
        //右边文字大小
        float rightTextSize = typedArray.getDimension(R.styleable.CommonToolbar_toolbarRightTextSize, ConvertUtils.sp2px(15f));
        //右边文字颜色
        int rightTextColor = typedArray.getColor(R.styleable.CommonToolbar_toolbarRightTextColor, getResources().getColor(R.color.black));
        int dividerColor = typedArray.getColor(R.styleable.CommonToolbar_toolbarDividerColor, getResources().getColor(R.color.black));
        //是否显示分割线
        int dividerVisibility = typedArray.getInteger(R.styleable.CommonToolbar_toolbarDividerVisibility, GONE);
        typedArray.recycle();

        setBackgroundRes(rootBackground);
        setTitle(strTitle);
        setTitleImg(titleImg);
        setTitleImgWidth(titleImgWidth);
        setTitleImgHeight(titleImgHeight);
        setTitleSize(ConvertUtils.px2sp(titleSize));
        tvToolbarTitle.setTextColor(titleColor);

        //设置左边布局类型
        setLeftViewType(leftType);
        //设置标题布局类型
        setTitleViewType(titleType);
        //设置右边布局类型
        setRightViewType(rightType);

        setLeftText(leftText);
        setLeftTextSize(ConvertUtils.px2sp(leftTextSize));
        setLeftImg(leftImg);
        setLeftImgWidth(leftImgWidth);
        setLeftImgHeight(leftImgHeight);
        tvToolbarLeft.setTextColor(leftTextColor);

        setRightText(rightText);
        setRightTextSize(ConvertUtils.px2sp(rightTextSize));
        tvToolbarRight.setTextColor(rightTextColor);
        setRightImg(rightImg);
        setRightImgWidth(rightImgWidth);
        setRightImgHeight(rightImgHeight);
        //分割线是否显示
        setDividerIsVisiblity(dividerVisibility);
        //分隔线颜色
        viewDivider.setBackgroundColor(dividerColor);
        //左边View点击监听
        rlLeftView.setOnClickListener(v -> {
            if (onLeftClickListener != null)
                onLeftClickListener.onLeftClick(v);
        });
        //标题View点击监听
        rlCenterView.setOnClickListener(v -> {
            if (onTitleClickListener != null)
                onTitleClickListener.onTitleClick(v);
        });
        //右边View点击监听
        rlRightView.setOnClickListener(v -> {
            if (onRightClickListener != null)
                onRightClickListener.onRightClick(v);
        });
    }

    /**
     * 设置左边图片
     *
     * @param titleImg:
     */
    public CommonToolbar setTitleImg(int titleImg) {
        ivToolbarTitle.setImageDrawable(getResources().getDrawable(titleImg));
        return this;
    }

    /**
     * 设置背景资源
     *
     * @param bgRes
     * @return
     */
    public CommonToolbar setBackgroundRes(int bgRes) {
        rlToolbarRoot.setBackgroundResource(bgRes);
        return this;
    }

    /**
     * 左边布局类型
     *
     * @param leftType :左边布局类型
     */
    public void setLeftViewType(int leftType) {
        tvToolbarLeft.setVisibility(leftType == LEFT_TYPE_TEXT ? VISIBLE : GONE);
        ivToolbarLeft.setVisibility(leftType == LEFT_TYPE_IMAGE ? VISIBLE : GONE);
        flToolbarLeft.setVisibility(leftType == LEFT_TYPE_VIEW ? VISIBLE : GONE);
    }

    /**
     * 标题布局类型
     *
     * @param titleType :左边布局类型
     */
    public void setTitleViewType(int titleType) {
        tvToolbarTitle.setVisibility(titleType == TITLE_TYPE_TEXT ? VISIBLE : GONE);
        ivToolbarTitle.setVisibility(titleType == TITLE_TYPE_IMAGE ? VISIBLE : GONE);
        flToolbarTitle.setVisibility(titleType == TITLE_TYPE_VIEW ? VISIBLE : GONE);
    }

    /**
     * 右边布局类型
     *
     * @param rightType :右边布局类型
     */
    public void setRightViewType(int rightType) {
        tvToolbarRight.setVisibility(rightType == RIGHT_TYPE_TEXT ? VISIBLE : GONE);
        ivToolbarRight.setVisibility(rightType == RIGHT_TYPE_IMAGE ? VISIBLE : GONE);
        flToolbarRight.setVisibility(rightType == RIGHT_TYPE_VIEW ? VISIBLE : GONE);
    }

    /**
     * 分割线是否显示
     *
     * @param isVisiblity:类型
     */
    public void setDividerIsVisiblity(int isVisiblity) {
        viewDivider.setVisibility(isVisiblity == VIEW_GONE ? View.GONE : View.VISIBLE);
    }

    /**
     * 改变分隔线颜色
     */
    public void setDividerColor(@ColorRes int dividerColor) {
        viewDivider.setBackgroundColor(getResources().getColor(dividerColor));
    }

    /**
     * 设置标题
     *
     * @param title:标题
     */
    public CommonToolbar setTitle(String title) {
        tvToolbarTitle.setText(title);
        return this;
    }

    /**
     * 设置标题大小
     *
     * @param titleSize:标题sp大小
     */
    public CommonToolbar setTitleSize(float titleSize) {
        tvToolbarTitle.setTextSize(titleSize);
        return this;
    }

    /**
     * 设置标题颜色
     *
     * @param titleColor:标题颜色
     */
    public CommonToolbar setTitleColor(int titleColor) {
        tvToolbarTitle.setTextColor(getResources().getColor(titleColor));
        return this;
    }


    /**
     * 设置左边图片宽度
     *
     * @param titleImgWidth:
     */
    public CommonToolbar setTitleImgWidth(float titleImgWidth) {
        if (titleImgWidth == NONE_PROPERTY)
            return this;
        LayoutParams layoutParams = (LayoutParams) ivToolbarTitle.getLayoutParams();
        //因为左右有给点击区域的padding所以加上两边的padding
        layoutParams.width = (int) titleImgWidth + ConvertUtils.dp2px(20);
        ivToolbarTitle.setLayoutParams(layoutParams);
        return this;
    }

    /**
     * 设置标题图片高度
     *
     * @param rightImgHeight:
     */
    public CommonToolbar setTitleImgHeight(float rightImgHeight) {
        if (rightImgHeight == NONE_PROPERTY)
            return this;
        LayoutParams layoutParams = (LayoutParams) ivToolbarTitle.getLayoutParams();
        layoutParams.height = (int) rightImgHeight;
        ivToolbarTitle.setLayoutParams(layoutParams);
        return this;
    }


    /**
     * 设置右边view
     *
     * @param view:右边布局
     */
    public CommonToolbar setTitleView(View view) {
        flToolbarTitle.removeAllViews();
        flToolbarTitle.addView(view);
        return this;
    }

    /**
     * 获取右边布局的View
     * @return
     */
    public View getTitleView() {
        return flToolbarTitle;
    }

    /**
     * 设置左边图片
     *
     * @param leftImg:
     */
    public CommonToolbar setLeftImg(int leftImg) {
        ivToolbarLeft.setImageDrawable(getResources().getDrawable(leftImg));
        return this;
    }

    /**
     * 设置左边图片宽度
     *
     * @param leftImgWidth:
     */
    public CommonToolbar setLeftImgWidth(float leftImgWidth) {
        if (leftImgWidth == NONE_PROPERTY)
            return this;
        LayoutParams layoutParams = (LayoutParams) ivToolbarLeft.getLayoutParams();
        //因为左右有给点击区域的padding所以加上两边的padding
        layoutParams.width = (int) leftImgWidth + ConvertUtils.dp2px(20);
        ivToolbarLeft.setLayoutParams(layoutParams);
        return this;
    }

    /**
     * 设置左边图片高度
     *
     * @param leftImgHeight:
     */
    public CommonToolbar setLeftImgHeight(float leftImgHeight) {
        if (leftImgHeight == NONE_PROPERTY)
            return this;
        LayoutParams layoutParams = (LayoutParams) ivToolbarLeft.getLayoutParams();
        layoutParams.height = (int) leftImgHeight;
        ivToolbarLeft.setLayoutParams(layoutParams);
        return this;
    }

    /**
     * 设置左边文字
     *
     * @param leftText:左边文字
     */
    public CommonToolbar setLeftText(String leftText) {
        tvToolbarLeft.setText(leftText);
        return this;
    }

    /**
     * 设置左边文字大小
     *
     * @param textSize:左边文字sp大小
     */
    public CommonToolbar setLeftTextSize(float textSize) {
        tvToolbarLeft.setTextSize(textSize);
        return this;
    }

    /**
     * 设置左边文字颜色
     *
     * @param leftTextColor:左边文字
     */
    public CommonToolbar setLeftTextColor(int leftTextColor) {
        tvToolbarLeft.setTextColor(getResources().getColor(leftTextColor));
        return this;
    }

    /**
     * 设置左边view
     *
     * @param view:左边布局
     */
    public CommonToolbar setLeftView(View view) {
        flToolbarLeft.removeAllViews();
        flToolbarLeft.addView(view);
        return this;
    }

    /**
     * 获取左边布局的View
     * @return
     */
    public View getLeftView() {
        return flToolbarRight;
    }

    /**
     * 设置右边文字
     *
     * @param rightText:右边文字
     */
    public CommonToolbar setRightText(String rightText) {
        tvToolbarRight.setText(rightText);
        return this;
    }

    /**
     * 设置右边文字大小
     *
     * @param textSize:右边文字sp大小
     */
    public CommonToolbar setRightTextSize(float textSize) {
        tvToolbarRight.setTextSize(textSize);
        return this;
    }

    /**
     * 设置右边文字颜色
     *
     * @param rightTextColor:右边文字颜色
     */
    public CommonToolbar setRightTextColor(int rightTextColor) {
        tvToolbarRight.setTextColor(getResources().getColor(rightTextColor));
        return this;
    }

    /**
     * 设置右边图片
     *
     * @param rightImg:
     */
    public CommonToolbar setRightImg(int rightImg) {
        ivToolbarRight.setImageDrawable(getResources().getDrawable(rightImg));
        return this;
    }

    /**
     * 设置左边图片宽度
     *
     * @param rightImgWidth:
     */
    public CommonToolbar setRightImgWidth(float rightImgWidth) {
        if (rightImgWidth == NONE_PROPERTY)
            return this;
        LayoutParams layoutParams = (LayoutParams) ivToolbarRight.getLayoutParams();
        //因为左右有给点击区域的padding所以加上两边的padding
        layoutParams.width = (int) rightImgWidth + ConvertUtils.dp2px(20);
        ivToolbarRight.setLayoutParams(layoutParams);
        return this;
    }

    /**
     * 设置左边图片高度
     *
     * @param rightImgHeight:
     */
    public CommonToolbar setRightImgHeight(float rightImgHeight) {
        if (rightImgHeight == NONE_PROPERTY)
            return this;
        LayoutParams layoutParams = (LayoutParams) ivToolbarRight.getLayoutParams();
        layoutParams.height = (int) rightImgHeight;
        ivToolbarRight.setLayoutParams(layoutParams);
        return this;
    }

    /**
     * 设置右边view
     *
     * @param view:右边布局
     */
    public CommonToolbar setRightView(View view) {
        flToolbarRight.removeAllViews();
        flToolbarRight.addView(view);
        return this;
    }

    /**
     * 获取右边布局的View
     * @return
     */
    public View getRightView() {
        return flToolbarRight;
    }

    /**
     * 左边按钮监听
     */
    public interface OnLeftClickListener {
        void onLeftClick(View v);
    }

    /**
     * 标题按钮监听
     */
    public interface OnTitleClickListener {
        void onTitleClick(View v);
    }

    /**
     * 右边按钮监听
     */
    public interface OnRightClickListener {
        void onRightClick(View v);
    }

    public CommonToolbar setOnLeftClickListener(OnLeftClickListener onLeftClickListener) {
        this.onLeftClickListener = onLeftClickListener;
        return this;
    }

    public CommonToolbar setOnTitleClickListener(OnTitleClickListener onTitleClickListener) {
        this.onTitleClickListener = onTitleClickListener;
        return this;
    }

    public CommonToolbar setOnRightClickListener(OnRightClickListener onRightClickListener) {
        this.onRightClickListener = onRightClickListener;
        return this;
    }
}
