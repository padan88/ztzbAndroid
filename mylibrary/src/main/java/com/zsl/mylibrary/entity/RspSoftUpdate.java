package com.zsl.mylibrary.entity;

import java.io.Serializable;

/**
 * @Description: 软件更新实体对象
 * @PackgeName: com.ztzb.paperlessmeetting.untils
 * @ClassName: ActivityCollector
 * @Author: Zsl
 * @Date: 2021/8/10 9:24
 * @Version: V 1.0
 */
public class RspSoftUpdate implements Serializable {
    private String versionCode;  //"1",
    private String versionName;  //"无纸化系统V1.0",
    private String versionDescription;  //"初始化",
    private String downloadUrl;  //"/g/mobile/sys/getApkMeta"

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionDescription() {
        return versionDescription;
    }

    public void setVersionDescription(String versionDescription) {
        this.versionDescription = versionDescription;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return "RspSoftUpdate{" +
                "versionCode='" + versionCode + '\'' +
                ", versionName='" + versionName + '\'' +
                ", versionDescription='" + versionDescription + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }
}
