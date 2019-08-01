package com.allInJava.service;

import javax.jms.Destination;

/**
 * @author za-yuhang   2019/8/1 14:55
 */
public interface ConsumerService {

    String receiveMessage(Destination destination, Destination replyDestination);

}
