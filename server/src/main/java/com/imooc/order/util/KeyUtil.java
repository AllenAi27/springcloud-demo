package com.imooc.order.util;

import java.util.Random;

public class KeyUtil {

    public static synchronized String generateKey(){
        Random random = new Random();
        Integer randomKey = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(randomKey);
    }
}
