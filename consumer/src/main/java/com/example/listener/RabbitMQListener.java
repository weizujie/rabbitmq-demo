package com.example.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author weizujie
 * @date 2022/3/18
 */
@Component
public class RabbitMQListener {

//    @RabbitListener(queues = "simple.queue")
//    public void listenSimpleQueue(String message) {
//        System.out.println(">>> 接收到队列 simple.queue 的消息：【" + message + "】");
//    }

    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueue1(String message) throws InterruptedException {
        System.out.println(">>> 消费者 1 接收到队列 simple.queue 的消息：【" + message + "】" + LocalDateTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueue2(String message) throws InterruptedException {
        System.err.println(">>> 消费者 2 接收到队列 simple.queue 的消息：【" + message + "】" + LocalDateTime.now());
        Thread.sleep(200);
    }

}
