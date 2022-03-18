package com.example.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
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

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String message) {
        System.out.println(">>> 接收到队列 fanout.queue1 的消息：【" + message + "】");
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String message) {
        System.out.println(">>> 接收到队列 fanout.queue2 的消息：【" + message + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "direct.exchange"),
            key = {"red", "blue"}
    ))
    public void listenDirectQueue1(String message) {
        System.out.println(">>> 接收到队列 direct.queue1 的消息：【" + message + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "direct.exchange"),
            key = {"red", "yellow"}
    ))
    public void listenDirectQueue2(String message) {
        System.out.println(">>> 接收到队列 direct.queue2 的消息：【" + message + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "topic.exchange", type = ExchangeTypes.TOPIC),
            key = "China.#"
    ))
    public void listenTopicQueue1(String message) {
        System.out.println(">>> 接收到队列 topic.queue1 的消息：【" + message + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "topic.exchange", type = ExchangeTypes.TOPIC),
            key = "#.news"
    ))
    public void listenTopicQueue2(String message) {
        System.out.println(">>> 接收到队列 topic.queue2 的消息：【" + message + "】");
    }
}
