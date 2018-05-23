package edu.wwq.car.bean;

import java.io.Serializable;
import java.util.HashMap;

public class ResultJsonMsg implements Serializable {

    private Integer code;

    private String msg;

    private Object data = new HashMap<>();

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

    public ResultJsonMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultJsonMsg(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
