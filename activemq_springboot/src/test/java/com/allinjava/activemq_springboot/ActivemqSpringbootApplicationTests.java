package com.allinjava.activemq_springboot;

import com.allinjava.activemq_springboot.service.ProduceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqSpringbootApplicationTests {

    @Autowired
    private ProduceService produceService;

    @Autowired
    private Destination smsQueue;

    @Test
    public void contextLoads() {

        produceService.sendMessage(smsQueue,"我是一条springboot消息");
    }

}
