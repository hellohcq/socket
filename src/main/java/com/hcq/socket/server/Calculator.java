package com.hcq.socket.server;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: solor
 * @Date: 2018/11/17 01:12
 * @Version 1.0
 * @Description:
 */
@Slf4j
public class Calculator {

    public static String cal(String expression){
        log.info("================"+expression);
        String str[]=expression.split("'+-*/'");
        String ss = str[1];
        char [] ch = expression.toCharArray();
        char first = ch[0];
        char last = ch[2];
        String s = String.valueOf(ch[1]);
        int s1=0;
        String result=null;
        switch(s){
            case "+":
                log.info("服务器运算加法"+String.valueOf(first+last));
                result=String.valueOf(first+last);break;
            case "-":
                log.info("服务器运算减法"+String.valueOf(first-last));
                result=String.valueOf(first-last);break;
            case "*":
                log.info("服务器运算乘法"+String.valueOf(first*last));
                result=String.valueOf(first*last);break;
            case "/":
                log.info("服务器运算除"+String.valueOf(first/last));
                result=String.valueOf(first/last);break;
            default:
                log.info("未找到运算符");break;
        }
//        log.info("服务器运算"+result);
        return result;
    }

}
