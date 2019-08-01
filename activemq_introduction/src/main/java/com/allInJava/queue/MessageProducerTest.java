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

        // 创建会话 true 则表示开启事务
        /**
         * 当开启了事务 必须要求commit() 才能真正的发送到mq
         */
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

        // 创建队列
        Destination destination = session.createQueue(QUEUE_NAME);

        // 创建生产者
        MessageProducer producer = session.createProducer(destination);

        // 创建消息并发送
        for (int i = 1; i <= 10; i++) {
            TextMessage textMessage = session.createTextMessage("我发送message" + i);

            /**
             * 消息头
             */
            // 消息的目的地 默认创建生产者时已指明
//            textMessage.setJMSDestination(destination);
            // 持久化模式 如果不持久化 消息发送后 消费者未消费 如果mq服务器挂了 则消息丢失 选择持久化模式则不丢失
            textMessage.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // 消息的发送时间 默认是当前时间
//            textMessage.setJMSTimestamp(System.currentTimeMillis());
            // 消息的过期时间 0表示永不过期 单位是毫秒
//            textMessage.setJMSExpiration(0);
            // 消息的优先级 0-4是默认级别 5-9是优先级别
//            textMessage.setJMSPriority(4);
            // 一个字符串用来唯一标示一个消息
//            textMessage.setJMSMessageID("");
            // 生产者发送消息 消费者收到后 生产者希望收到一个回复，这个是回复的消息地址 消费者可以回复 也可以不回复
//            textMessage.setJMSReplyTo(null);
            // 用于将消息关联起来的 例如回复时 将收到的消息id设置成这个
//            textMessage.setJMSCorrelationID(null);
            // 表示消息被重新发送了
//            textMessage.setJMSRedelivered(true);

            /**
             * 消息属性
             */
            textMessage.setStringProperty("tag","001");
            producer.send(textMessage);
            System.out.println("我现在发的消息:"+ textMessage.getText());
        }

        session.commit();

        // 关闭连接
        connection.close();

    }
}
