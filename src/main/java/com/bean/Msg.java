package com.bean;

import java.util.HashMap;
import java.util.Map;

/**
 *  统一传递给前端的数据的实体类
 * @author Hedon Wang
 * @create 2020-05-26 11:59
 */
public class Msg {

    private Integer code;    //状态码  100-成功，200-失败
    private String message;  //提示信息
    private Map<String,Object> extend = new HashMap<>(); //用户要返回给浏览器的信息

    public static Msg success(){
        Msg result = new Msg();
        result.setCode(100);
        result.setMessage("处理成功！");
        return result;
    }

    public static Msg fail(){
        Msg result = new Msg();
        result.setCode(200);
        result.setMessage("处理失败！");
        return result;
    }

    public Msg add(String key,Object keyValue){
        this.getExtend().put(key,keyValue);
        return this;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }


}
