package com.hcq.socket.server;

import com.sun.javafx.css.CalculatedValue;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Auther: solor
 * @Date: 2018/11/17 00:51
 * @Version 1.0
 * @Description:
 */
@Slf4j
public class ServerHandler implements Runnable{
    private Socket socket;

    public ServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        String expression = null;
        String result = null;
        BufferedReader in = null;
        PrintWriter p = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            p = new PrintWriter(socket.getOutputStream(),true);
            while (true){
                if ((expression=in.readLine())==null) break;//没有接收到数据直接break

                log.info("服务器收到信息"+expression);
                result = Calculator.cal(expression);
                p.println(result);
            }
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
            try {
                if(p!=null){
                    p.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            p=null;
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
