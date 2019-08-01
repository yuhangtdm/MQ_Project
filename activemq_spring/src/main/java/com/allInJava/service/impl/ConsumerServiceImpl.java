package com.allInJava.service.impl;

import com.allInJava.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * @author za-yuhang   2019/8/1 14:56
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private JmsTemplate jmsTemplate;
    /**
     * 阻塞接收的方式
     * 消费者收到生产者的消息后
     * 向另一个队列发消息
     */
    public String receiveMessage(Destination destination, Destination replyDestination) {

        Message message = jmsTemplate.receive(destination);
        String receiveMessage = null;
        try {
            if (message instanceof TextMessage){
                receiveMessage = ((TextMessage)message).getText();
                System.out.println("收到消息:"+ receiveMessage);
                jmsTemplate.send(replyDestination, new MessageCreator() {
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage("我已收到消息");
                    }
                });
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }


        return receiveMessage;
    }
}
