package com.zsl.mylibrary.apiUtils.base;

import com.zsl.mylibrary.constants.HttpConstants;

/**
 * @Author: zsl
 * @Email: zsl@qq.com
 * <p>
 * @Desc: 数据统一返回格式
 */
public class BaseResponse<T> {

    private int code;
    private String msg;
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess(){
        return code == HttpConstants.CODE_SUCCESS;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
