package com.zsl.mylibrary;

import android.content.Context;

import com.liulishuo.filedownloader.FileDownloader;
import com.zsl.mylibrary.crashUtils.CrashHandler;
import com.zsl.mylibrary.httpsUtils.CommonOkHttpClient;

import java.io.File;

/**
 * @Description:一句话描述这个类
 * @PackgeName: com.ztzb.zsllibrary
 * @ClassName: init
 * @Author: Zsl
 * @Date: 2021/8/23 10:56
 * @Version: V 1.0
 */
public class StartLibrary {

    public static String BASE_URL = null ;
    public static String SD_ROOT_DIR = null;  // 文件保存路径

    public static void  init(Context context,String filePath,String baseUrl){
        SD_ROOT_DIR = filePath;
        BASE_URL  = baseUrl;
        FileDownloader.setup(context);
        new CommonOkHttpClient(context,context.getExternalCacheDir());
        CrashHandler crash = new CrashHandler();
        crash.init(context,context.getExternalCacheDir()+ File.separator);
    }
}
