package com.zsl.testmylibrary.config;

import android.os.Environment;

import com.zsl.testmylibrary.MyApplication;

import java.io.File;

public class AppSettings {
    public static final boolean Debug = false;
    public static final String project_NAME = "testProject";
    public static final String AppPath = MyApplication.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)+ File.separator;  // 下载保存路径
    public static final String CrashLogPath = MyApplication.getContext().getExternalCacheDir()+ File.separator; // 日志保存路径
    public static final String PicturesPath = MyApplication.getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ File.separator;; //图片保存路径
    //服务路径设置
    public static final String Base_Host = Debug ? "http://icax.cregcloud.com/icax" : "http://tic.cregcloud.com/tic_server"; //tic.cregcloud.com/tic_server
    public static final  String AppVersionData = Base_Host + "/g/mobile/sys/getApkMeta"; //获取版本信息
}
