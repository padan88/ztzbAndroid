package com.zsl.mylibrary.appUpdate;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import com.blankj.utilcode.util.AppUtils;
import com.google.gson.Gson;
import com.zsl.mylibrary.R;
import com.zsl.mylibrary.entity.RspSoftUpdate;
import com.zsl.mylibrary.httpsUtils.HttpRequest;
import com.zsl.mylibrary.httpsUtils.NetUtils;
import com.zsl.mylibrary.httpsUtils.OkHttpException;
import com.zsl.mylibrary.httpsUtils.ResponseByteCallback;
import com.zsl.mylibrary.httpsUtils.ResponseCallback;
import com.zsl.mylibrary.toastUtils.ToastUtil;

import java.io.File;


/**
 * @ProjectName: PaperLessMeetting
 * @Package: com.ztzb.paperlessmeetting.untils
 * @ClassName: AutoUpdate
 * @Description: 系统版本升级
 * @Author: zsl
 * @CreateDate: 2021/5/31 15:58
 * @Version: 1.0
 */
public class AutoUpdate {

    private static Context context;

    public AutoUpdate(Context context) {
        super();
        this.context = context;
    }

    /**
     * 描述：检查更新
     */
    public static void checkUpdate(String baseUrl,String apiPath,String filePath) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo data = packageManager.getPackageInfo(context.getPackageName(), 0);
            final int code = data.versionCode;
            new HttpRequest(context).getDataApi(baseUrl + apiPath, new ResponseCallback() {
                        @Override
                        public void onSuccess(Object object) {
                            Gson gson = new Gson();
                            RspSoftUpdate data = gson.fromJson(String.valueOf(object), RspSoftUpdate.class);
                            if (Integer.valueOf(data.getVersionCode()) > code) {
                                showUpdateDialog(baseUrl + data.getDownloadUrl(), data.getVersionDescription(),filePath);
                            }else {
                                ToastUtil.showShortToast(context, R.string.new_version);
                            }
                        }

                        @Override
                        public void onFailure(OkHttpException failuer) {
                            ToastUtil.showShortToast(context,failuer.getEmsg());
                        }

                    }
            );
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected static void showUpdateDialog(final String apkUrl, String descriptionContext,String filePath) {
        View view = LayoutInflater.from(context).inflate(R.layout.update_dialog, null);
        ((TextView) view.findViewById(R.id.dialog_title)).setText(R.string.update);
        TextView description = view.findViewById(R.id.dialog_description);
        description.setVisibility(View.VISIBLE);
        description.setText(descriptionContext);
        view.findViewById(R.id.dialog_input_layout).setVisibility(View.GONE);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        view.findViewById(R.id.dialog_btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alertDialog != null && alertDialog.isShowing()) {
                    alertDialog.dismiss();
                }
            }
        });
        view.findViewById(R.id.dialog_btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alertDialog != null && alertDialog.isShowing()) {
                    alertDialog.dismiss();
                }
                downApk(apkUrl,filePath);
            }
        });
    }

    private static void downApk(String apkUrl,String filePath) {
        if (NetUtils.isConnected(context)) {
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                File file = new File("ic.apk");
                String fileName = file.getName();
                new HttpRequest(context).getImgApi(apkUrl, filePath,fileName, new ResponseByteCallback() {
                    @Override
                    public void onSuccess(File file) {
                        AppUtils.installApp(file.getPath());
                    }

                    @Override
                    public void onFailure(String failureMsg) {
                        ToastUtil.showShortToast(context, failureMsg);
                    }
                });
            }
        } else {
            Toast.makeText(context, "请检查网络连接", Toast.LENGTH_SHORT).show();
        }
    }
}
