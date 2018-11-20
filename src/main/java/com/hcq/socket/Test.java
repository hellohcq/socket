package com.hcq.socket;

import com.hcq.socket.client.Client;
import com.hcq.socket.server.Server;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @Auther: solor
 * @Date: 2018/11/16 23:46
 * @Version 1.0
 * @Description:
 */
@Slf4j
public class Test {

    public static void main(String[] args) throws Exception{
       new Thread(()-> Server.start()).start();
       Thread.sleep(100);
       char ch [] = {'+','-','*','/'};
       final Random random = new Random(System.currentTimeMillis());
       new  Thread(
               new Runnable() {
                   @Override
                   public void run() {
                       while (true){
                            String expression = random.nextInt(10)+""
                                    +ch[random.nextInt(4)]
                                    +(random.nextInt(10)+1);
                           Client.send(expression);
                       }
                   }
               }

       ).start();
    }
}
