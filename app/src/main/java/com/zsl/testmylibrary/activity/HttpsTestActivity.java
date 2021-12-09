package com.zsl.testmylibrary.activity;

import android.view.View;
import android.widget.Button;

import com.zsl.mylibrary.apiUtils.ZHttp;
import com.zsl.mylibrary.apiUtils.base.BaseObserver;
import com.zsl.mylibrary.apiUtils.base.RxJavaHelper;
import com.zsl.mylibrary.appUpdate.AutoUpdate;
import com.zsl.mylibrary.toastUtils.ToastUtil;
import com.zsl.testmylibrary.R;
import com.zsl.testmylibrary.base.BaseActivity;
import com.zsl.testmylibrary.config.AppSettings;


public class HttpsTestActivity extends BaseActivity {

    Button login;

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        login = findViewById(R.id.login);
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void setListener() {
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                getAppData();
        }

    }

    /**
     * 验证http请求接口
     */
    private void getAppData() {

  /*      ZHttp.getApi()
                .testGet()
                .compose(RxJavaHelper.observeOnMainThread())
                .subscribe(new BaseObserver(this) {

                    @Override
                    public void onSuccess(Object response) {
                        ToastUtil.showShortToast(HttpsTestActivity.this, response.toString());
                    }
                });*/


        new AutoUpdate(this).checkUpdate(AppSettings.Base_Host,AppSettings.AppPath);
/*        new HttpRequest(this).getDataApi("", new ResponseCallback() {

            @Override
            public void onSuccess(Object object) {
                Log.d("==============", object.toString());
            }

            @Override
            public void onFailure(OkHttpException failuer) {
                // 认证失败时退出登录页面
                if (failuer.getEcode() == -4) {
                    Intent intent = new Intent("com.admin.login");
                    sendBroadcast(intent);
                }
                Log.d("==============", failuer.getEmsg());
            }
        });*/
    }
}