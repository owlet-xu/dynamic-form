package com.dynamicform.springboot.seed.bz1.contract.model;

/**
 * @author xgy
 * @description
 * @date 2018/9/27
 */
public class ResponseInfo {

    private Boolean success;
    private String msg;
    private Object data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
