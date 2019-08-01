package com.allInJava.service.listner;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 监听器的方式实现接收消息
 * @author za-yuhang   2019/8/1 15:41
 */
@Component
public class QueueMessageListener implements MessageListener {
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            // 取消息内容
            String text = textMessage.getText();
            System.out.println(text);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
