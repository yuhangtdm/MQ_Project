/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */

import com.allInJava.service.ConsumerService;
import com.allInJava.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

/**
 * @author za-yuhang   2019/8/1 15:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MQ_Test {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    @Qualifier("queue")
    private Destination destination;

    @Autowired
    @Qualifier("responseQueue")
    private Destination responseDestination;

    @Autowired
    private Destination topicDestination;

    @Test
    public void producerTest(){
        producerService.sendMessage(topicDestination, "my name is hello!");
    }

    @Test
    public void consumerTest(){
        consumerService.receiveMessage(destination,responseDestination);
    }

}
