package com.allinjava.activemq_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
// 开启jms
@EnableJms
public class ActivemqSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqSpringbootApplication.class, args);
    }

}
