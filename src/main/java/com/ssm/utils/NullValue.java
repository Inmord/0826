package com.ssm.utils;

public class NullValue {
    //值为空时赋""
    public static String transferValue(String param){
        if("".equals(param) || null ==param){
            param = "";
        }else {
            return param;
        }
        return param;
    }

    //值为空时赋""
    public static Object transferNullValue(Object o){
        if("".equals(o) || null ==o){
            o = "";
        }else {
            return o;
        }
        return o;
    }
}
