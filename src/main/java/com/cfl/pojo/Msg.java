package com.cfl.pojo;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    private int code;

    private String msg;

    private Map<String,Object> extend = new HashMap<String,Object>();

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

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    public  Msg success(){
        Msg result = new Msg();
        result.code = 100;
        result.setMsg("处理成功！");
        return  result;
    }

    public Msg fail(){
        Msg result = new Msg();
        result.code = 200;
        result.setMsg("处理失败！");
        return  result;
    }

    public Msg add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }
}
