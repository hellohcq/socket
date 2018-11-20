package com.hcq.socket.client;

import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Auther: solor
 * @Date: 2018/11/16 23:48
 * @Version 1.0
 * @Description:
 */
@Slf4j
public class Client {

    private static int SERVER_PORT = 7777;
    private static String IP = "127.0.0.1";


    public static void send(String expression){
        send(SERVER_PORT,expression);
    }
    public static void send(int port,String expression){
        log.info("客户端表达式为 ：" +expression);

        BufferedReader in = null;
        Socket socket = null;
        PrintWriter out = null;
        try {
            socket = new Socket(IP,port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println(expression);
            log.info("客户端收到服务器运算后的结果"+in.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(in!=null){
                    in.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            in=null;
                if(out!=null){
                    out.close();
                }

            out=null;
            try {
                if(socket!=null){
                    socket.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            socket=null;

        }

    }


}
