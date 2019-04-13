package com.lidegui.littledrawer.dto;

import com.lidegui.littledrawer.util.Constant;

import java.io.Serializable;

/**
 * @Author: lidegui
 * @Date:Created in 23:49 2019/4/12
 */
public class BaseResponse<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    public static BaseResponse DEFAULT_SUCCESS =
            new BaseResponse(Constant.CODE_SUCCESS, Constant.MSG_SUCCESS, null);
    public static BaseResponse DEFAULT_FAIL =
            new BaseResponse(Constant.CODE_FAIL, Constant.MSG_FAIL, null);


    public static BaseResponse generateFail(String msg) {
        return new BaseResponse(Constant.CODE_FAIL, msg, null);
    }

    public static BaseResponse generateSuccess(String msg,Object data) {
        return new BaseResponse(Constant.CODE_SUCCESS, msg, data);
    }

    public static BaseResponse generateSuccess(Object data) {
        return new BaseResponse(Constant.CODE_SUCCESS, Constant.MSG_SUCCESS, data);
    }

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
