package com.hzbl360.tools;

public class ReturnResult {

    //响应业务状态
    private Integer code;

    //响应业务消息
    private String msg;

    //响应业务数据
    private Object data;

    public ReturnResult(){

    }
    public ReturnResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ReturnResult result(Integer code,String msg,Object data){
        return new ReturnResult(code,msg,data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "ReturnResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
