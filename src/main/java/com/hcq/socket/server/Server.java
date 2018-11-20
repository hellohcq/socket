package com.hcq.socket.server;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: solor
 * @Date: 2018/11/17 00:19
 * @Version 1.0
 * @Description:
 */
@Slf4j
public class Server {
    private static int SERVER_PORT=7777;
    private static ServerSocket serverSocket;

    public static void start(){
        start(SERVER_PORT);
    }

    public synchronized static void start(int port){
        log.info("服务端开始启动");
        if (serverSocket!=null) return;


        BufferedReader bf = null;
        PrintWriter out = null;
        try{
            serverSocket = new ServerSocket(port);
            while (true){//循环接收客户端的链接
                Socket socket = serverSocket.accept();
                new Thread(new ServerHandler(socket)).start();//客户端每一个请求对应一个线程
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                    serverSocket=null;
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }



}
