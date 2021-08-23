package com.zsl.mylibrary.httpsUtils;


import android.content.Context;

import java.io.File;
import java.util.List;

/**
 * 作者：zsl.
 * <p>
 * 时间：On 2020年8月4日
 * <p>
 * 描述：所有的请求接口
 */
public class HttpRequest {
    private static Context context;

    public HttpRequest(Context context) {
        this.context = context;
    }

    /**
     * 描述：获取数据接口
     *
     * @param params   入参
     * @param callback 回调接口
     */
    public static void postDataApi(String url, String params, ResponseCallback callback) {
        new RequestMode(context).postRequestBody(url, params, callback);
    }

    /**
     * 描述：获取数据接口
     * 无参
     *
     * @param callback 回调接口
     */
    public static void postDataApi(String url, ResponseCallback callback) {
        new RequestMode(context).postRequestBody(url, callback);
    }

    /**
     * 描述：获取数据接口
     * 无参
     *
     * @param callback 回调接口
     */
    public static void getDataApi(String url, ResponseCallback callback) {
        new RequestMode(context).getRequestBody(url, callback);
    }

    /**
     * 下载图片 Post方式
     *
     * @param json     入参
     * @param imgPath  存储地址
     * @param callback 回调接口
     */
    public static void postFileApi(String url, String json, String imgPath, ResponseByteCallback callback) {
        new RequestMode(context).postLoadImg(url, json, imgPath, callback);
    }

    /**
     * 描述：获取数据接口
     *
     * @param params   入参
     * @param callback 回调接口
     */
    public static void getDataApi(String url, RequestParams params, ResponseCallback callback) {
        new RequestMode(context).getRequestBody(url, params, callback);
    }

    /**
     * 下载 Get方式
     *
     * @param params   入参
     * @param urlPath  存储地址
     * @param fileName 文件名称
     * @param callback 回调接口
     */
    public static void getImgApi(String url, RequestParams params, String urlPath, String fileName, ResponseByteCallback callback) {
        new RequestMode(context).getLoadImg(url, params, urlPath, fileName, callback);
    }

    /**
     * 下载 Get方式
     *
     * @param urlPath  存储地址
     * @param fileName 文件名称
     * @param callback 回调接口
     */
    public static void getImgApi(String url, String urlPath, String fileName, ResponseByteCallback callback) {
        new RequestMode(context).getLoadImg(url, urlPath, fileName, callback);
    }

    /**
     * 下载 Post方式
     *
     * @param params   入参
     * @param urlPath  存储地址
     * @param fileName 文件名称
     * @param callback 回调接口
     */
    public static void postImgApi(String url, RequestParams params, String urlPath, String fileName, ResponseByteCallback callback) {
        new RequestMode(context).postLoadImg(url, params, urlPath, fileName, callback);
    }

    /**
     * 下载图片/文件 Post方式
     *
     * @param urlPath  存储地址
     * @param fileName 文件名称
     * @param callback 回调接口
     */
    public static void postImgApi(String url, String urlPath, String fileName, ResponseByteCallback callback) {
        new RequestMode(context).postLoadImg(url, urlPath, fileName, callback);
    }

    /**
     * 图文混合上传服务器
     *
     * @param params
     * @param files
     * @param callback
     */
    public static void postMultipartApi(String url, RequestParams params, List<File> files, ResponseCallback callback) {
        new RequestMode(context).postMultipart(url, params, files, callback);
    }

}
