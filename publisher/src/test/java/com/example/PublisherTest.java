package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author weizujie
 * @date 2022/3/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSimpleQueue() {
        // 只会往已存在的队列发送消息
        String queueName = "simple.queue";
        String message = "hello, world!";
        rabbitTemplate.convertAndSend(queueName, message);
    }
}