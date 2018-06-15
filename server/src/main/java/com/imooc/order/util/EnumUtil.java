package com.imooc.order.util;


import com.imooc.order.enums.CodeEnum;

public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        T[] enums = enumClass.getEnumConstants();
        for(T each : enums){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
