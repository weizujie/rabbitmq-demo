package com.example.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author weizujie
 * @date 2022/3/18
 */
@Component
public class RabbitMQListener {

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String message) {
        System.out.println(">>> 接收到队列 simple.queue 的消息：【" + message + "】");
    }

}
