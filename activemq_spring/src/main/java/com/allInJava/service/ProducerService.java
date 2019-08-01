package com.allInJava.service;

import javax.jms.Destination;

/**
 * @author za-yuhang   2019/8/1 14:52
 */
public interface ProducerService {

    void sendMessage(Destination destination, String message);
}
