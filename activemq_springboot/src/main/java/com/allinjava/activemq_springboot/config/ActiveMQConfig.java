package com.allinjava.activemq_springboot.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Destination;

/**
 * @author za-yuhang   2019/8/1 16:12
 */
@Configuration
public class ActiveMQConfig {

    @Value("${sms.queue.name}")
    private String smsQueueName;

    @Value("${order.topic.name}")
    private String orderTopicName;

    @Bean
    public Destination smsQueue(){
        return new ActiveMQQueue(smsQueueName);
    }

    @Bean
    public Destination orderTopic(){
        return new ActiveMQTopic(orderTopicName);
    }


}
