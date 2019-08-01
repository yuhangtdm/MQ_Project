package com.allInJava.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

/**
 * @author yuhang   2019/8/1 11:16
 */
public class MessageProducerTest {

    // 定义mq的连接地址
    private static final String ACTIVEMQ_URL = "tcp://106.15.188.249:61616";

    //定义队列名称
    private static final String QUEUE_NAME = "MyQueue";

    public static void main(String[] args) throws JMSException {
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        // 创建连接
        Connection connection = activeMQConnectionFactory.createConnection();

        // 打开连接
        connection.start();

        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 创建队列
        Destination destination = session.createQueue(QUEUE_NAME);

        // 创建生产者
        MessageProducer producer = session.createProducer(destination);

        // 创建消息并发送
        for (int i = 0; i < 100; i++) {
            TextMessage textMessage = session.createTextMessage("我发送message" + i);
            producer.send(textMessage);
            System.out.println("我现在发的消息:"+ textMessage.getText());
        }

        // 关闭连接
        connection.close();

    }
}
