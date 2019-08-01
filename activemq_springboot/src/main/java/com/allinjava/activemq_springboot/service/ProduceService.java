package com.allinjava.activemq_springboot.service;

import javax.jms.Destination;

/**
 * @author za-yuhang   2019/8/1 16:17
 */
public interface ProduceService {

    void sendMessage(Destination destination, String messgae);

}
