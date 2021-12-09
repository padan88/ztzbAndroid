package com.zsl.mylibrary.apiUtils.bean;

/**
 * @Author: zsl
 * @Date: 2020/9/3
 * @Email: zsl@qq.com
 * <p>
 * @Desc: 返回的整个的信息 sample: {"code":10000,"msg":"请求成功","data":{"username":"用户名","password":"密码"}}  只需要写data里面的就可以
 */
public class ExampleBean {

       private String  id; //25,
       private String  versionCode; //"2",
       private String  versionName; //"1.0.2",
       private String  versionDescription; //"更新已知问题",
       private String  downloadUrl; //"/g/mobile/sys/getApk/v1"

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return "ExampleBean{" +
                "id='" + id + '\'' +
                ", versionCode='" + versionCode + '\'' +
                ", versionName='" + versionName + '\'' +
                ", versionDescription='" + versionDescription + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }
}
