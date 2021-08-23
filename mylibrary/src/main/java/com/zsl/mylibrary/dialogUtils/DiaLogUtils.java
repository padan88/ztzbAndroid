package com.zsl.mylibrary.dialogUtils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zsl.mylibrary.R;


/**
 * @Description:一句话描述这个类
 * @PackgeName: com.example.androidlibrary.DialogUtils
 * @ClassName: DiaLogUtils
 * @Author: Zsl
 * @Date: 2021/8/20 14:44
 * @Version: V 1.0
 */
public class DiaLogUtils {

    private Context context;

    public DiaLogUtils(Context context) {
        this.context = context;
    }

    /**
     * 加载缓冲
     *
     * @param context
     * @return
     */
    public static Dialog getLoadingDialog(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.loading_dialog, null);
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);
        ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(context, R.anim.loading_animation);
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
        tipTextView.setText(R.string.downLoading);
        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);
        loadingDialog.setCancelable(false);
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        return loadingDialog;
    }
}
