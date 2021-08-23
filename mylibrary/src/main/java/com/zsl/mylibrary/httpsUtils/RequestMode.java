package com.zsl.mylibrary.httpsUtils;

import android.content.Context;

import java.io.File;
import java.util.List;

/**
 * 创建： zsl
 * 描述：请求模式
 */

public class RequestMode {
    private static Context context;

    public RequestMode(Context context) {
        this.context = context;
    }

    /**
     * GET请求
     *
     * @param url      URL请求地址
     * @param params   入参
     * @param callback 回调接口
     */
    public static void getRequest(String url, RequestParams params, ResponseCallback callback) {
       new CommonOkHttpClient(context).get(CommonRequest.createGetRequest(url, params),
                new ResposeDataHandle(callback));
    }

    /**
     * POST请求
     *
     * @param url      URL请求地址
     * @param params   入参
     * @param callback 回调接口
     */
    public static void postRequest(String url, RequestParams params, ResponseCallback callback) {
        new CommonOkHttpClient(context).post(CommonRequest.createPostRequest(url, params),
                new ResposeDataHandle(callback));
    }

    /**
     * POST请求
     *
     * @param url      URL请求地址
     * @param callback 回调接口
     */
    public static void postRequestBody(String url, ResponseCallback callback) {
        new CommonOkHttpClient(context).post(CommonRequest.createPostRequestForNoCan(url),
                new ResposeDataHandle(callback));
    }

    /**
     * POST请求
     *
     * @param string   参数
     * @param url      URL请求地址
     * @param callback 回调接口
     */
    public static void postRequestBody(String url, String string, ResponseCallback callback) {
        new CommonOkHttpClient(context).post(CommonRequest.createPostRequestJson(url, string),
                new ResposeDataHandle(callback));
    }

    /**
     * POST请求
     *
     * @param string   参数
     * @param url      URL请求地址
     * @param callback 回调接口
     */
    public static void getRequestBody(String url, RequestParams string, ResponseCallback callback) {
        new CommonOkHttpClient(context).get(CommonRequest.createGetRequest(url, string),
                new ResposeDataHandle(callback));
    }

    /**
     * GET请求
     *
     * @param url      URL请求地址
     * @param callback 回调接口
     */
    public static void getRequestBody(String url, ResponseCallback callback) {
        new CommonOkHttpClient(context).get(CommonRequest.createGetRequestforNoCan(url), new ResposeDataHandle(callback));
    }

    /**
     * 下载图片 Get方式
     *
     * @param params 参数
     */
    public static void getLoadImg(String url, RequestParams params,  String pathUrl, String fileName, ResponseByteCallback callback) {
        new CommonOkHttpClient(context).downLadImg(CommonRequest.createGetRequest(url,params),pathUrl, fileName, callback);
    }

    /**
     * 下载图片 Get方式
     */
    public static void getLoadImg(String url, String pathUrl, String fileName, ResponseByteCallback callback) {
        new CommonOkHttpClient(context).downLadImg(CommonRequest.createGetRequestforNoCan(url), pathUrl, fileName, callback);
    }

    /**
     * 下载 Post方式
     * @param params 参数
     */
    public static void postLoadImg(String url, RequestParams params,String pathUrl, String fileName, ResponseByteCallback callback) {
        new CommonOkHttpClient(context).downLadImg(CommonRequest.createPostRequest(url,params), pathUrl, fileName, callback);
    }

    /**
     * 下载 Post方式
     */
    public static void postLoadImg(String url, String json, String pathUrl, String fileName, ResponseByteCallback callback) {
        new CommonOkHttpClient(context).downLadImg(CommonRequest.createPostRequestJson(url,json), pathUrl, fileName, callback);
    }

    /**
     * 下载 Post方式
     */
    public static void postLoadImg(String url, String pathUrl, String fileName, ResponseByteCallback callback) {
        new CommonOkHttpClient(context).downLadImg(CommonRequest.createPostRequestForNoCan(url), pathUrl, fileName, callback);
    }

    /**
     * 表单和媒体 图文混合 上传
     */
    public static void postMultipart(String url, RequestParams params, List<File> files, ResponseCallback callback) {
        new CommonOkHttpClient(context).post(CommonRequest.createMultipartRequest(url, params, files),
                new ResposeDataHandle(callback));
    }
}
