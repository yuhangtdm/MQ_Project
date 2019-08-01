package com.allInJava.topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

/**
 * @author za-yuhang   2019/8/1 11:45
 */
public class MessageTopicConsumerTest {
    // 定义mq的连接地址
    private static final String ACTIVEMQ_URL = "tcp://106.15.188.249:61616";

    //定义队列名称
    private static final String TOPIC_NAME = "MyTopic";

    public static void main(String[] args) throws JMSException {
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        // 创建连接
        Connection connection = activeMQConnectionFactory.createConnection();

        // 打开连接
        connection.start();

        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 创建队列目标
        Destination destination = session.createTopic(TOPIC_NAME);

        // 创建消费者
        MessageConsumer consumer = session.createConsumer(destination);

        // 创建消费的监听
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("获取消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
