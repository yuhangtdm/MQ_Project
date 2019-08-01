package com.allinjava.activemq_springboot.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author za-yuhang   2019/8/1 16:41
 */
@Component
public class SmsConsumerListener  {

    @JmsListener(destination = "${sms.queue.name}")
//    @SendTo("${目标队列}")
    public String receive(String message){
        System.out.println("成功接收到消息:"+ message);

        return message;
    }
}
