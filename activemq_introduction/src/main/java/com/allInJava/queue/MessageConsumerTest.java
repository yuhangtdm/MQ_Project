package com.allInJava.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author za-yuhang   2019/8/1 11:34
 */
public class MessageConsumerTest {

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

        // 创建消费者
        MessageConsumer consumer = session.createConsumer(destination);

        // 创建消费者的监听
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                if (message!=null && message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("我收到消息:" + textMessage.getText());
                        System.out.println(textMessage.getJMSMessageID()+"---"
                                                +textMessage.getJMSDeliveryMode()+"---"
                                                +textMessage.getJMSTimestamp()+"---"
                                                +textMessage.getJMSExpiration()+"---"
                                                +textMessage.getJMSPriority()+"---"
                                                +textMessage.getJMSCorrelationID());
                        System.out.println(textMessage.getStringProperty("tag"));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
