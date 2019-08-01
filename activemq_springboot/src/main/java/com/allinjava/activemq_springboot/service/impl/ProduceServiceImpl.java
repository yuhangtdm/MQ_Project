package com.allinjava.activemq_springboot.service.impl;

import com.allinjava.activemq_springboot.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @author za-yuhang   2019/8/1 16:18
 */
@Service
public class ProduceServiceImpl implements ProduceService {

    @Autowired
    private JmsMessagingTemplate  jmsMessagingTemplate;



    @Override
    public void sendMessage(Destination destination, String messgae) {
        jmsMessagingTemplate.convertAndSend(destination,messgae);
    }
}
