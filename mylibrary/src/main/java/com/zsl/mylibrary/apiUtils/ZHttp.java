package com.zsl.mylibrary.apiUtils;



import android.text.TextUtils;

import com.blankj.utilcode.util.Utils;
import com.zsl.mylibrary.StartLibrary;
import com.zsl.mylibrary.apiUtils.api.ApiService;
import com.zsl.mylibrary.apiUtils.intercept.HttpIntercept;
import com.zsl.mylibrary.constants.HttpConstants;
import com.zsl.mylibrary.utils.ParamUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: zsl
 * @Email: zsl@qq.com
 * <p>
 * @Desc: 网络请求入口
 */
public class ZHttp {
    private static ApiService apiService;

    /**
     * 请求的入口
     *
     * @return
     */
    public static ApiService getApi() {
        if (apiService == null) {
            synchronized (ApiService.class) {
                if (apiService == null)
                    apiService = initRetrofit().create(ApiService.class);
            }
        }
        return apiService;
    }

    /**
     * 初始化Retrofit
     *
     * @return
     */
    private static Retrofit initRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(StartLibrary.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initOkHttpClient())
                .build();
    }

    /**
     * 初始化OkHttp
     *
     * @return
     */
    private static OkHttpClient initOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpIntercept())
                .addInterceptor(new HttpIntercept().httpBodyIntercept())
                .connectTimeout(HttpConstants.TIME_OUT_CONNECT, TimeUnit.SECONDS)
                .readTimeout(HttpConstants.TIME_OUT_READ, TimeUnit.SECONDS)
                .build();
    }
}
