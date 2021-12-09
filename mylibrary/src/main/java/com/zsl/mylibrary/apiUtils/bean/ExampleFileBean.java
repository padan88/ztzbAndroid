package com.zsl.mylibrary.apiUtils.bean;

/**
 * @Author: zsl
 * @Date: 2020/11/12
 * @Email: zsl@qq.com
 * <p>
 * @Desc: 返回的整个的信息 sample: {"code":10000,"msg":"请求成功","data":{"fileUrl":"文件地址"}}  只需要写data里面的就可以
 */
public class ExampleFileBean {

    private String fileUrl;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return "ExampleFileBean{" +
                "fileUrl='" + fileUrl + '\'' +
                '}';
    }
}
