package com.zsl.mylibrary.apiUtils.base;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author: zsl
 * @Email: zsl@qq.com
 * <p>
 * @Desc: Rxjava2线程切换操作封装
 */
public class RxJavaHelper {

    public static <T> ObservableTransformer<T, T> observeOnMainThread(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}