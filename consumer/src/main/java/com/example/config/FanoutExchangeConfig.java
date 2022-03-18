package com.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Fanout 交换机配置类
 * @author weizujie
 * @date 2022/3/18
 */
@Configuration
public class FanoutExchangeConfig {

    /**
     * 声明 FanoutExchange 交换机
     * @return 交换机
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout.exchange");
    }

    /**
     * 声明队列 1
     * @return 队列
     */
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout.queue1");
    }

    /**
     * 声明队列 2
     * @return 队列
     */
    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout.queue2");
    }

    /**
     * 将 fanoutQueue1 队列绑定到 fanout.exchange 交换机
     * @param fanoutQueue1 fanoutQueue1 队列
     * @param fanoutExchange fanout.exchange 交换机
     * @return Binding
     */
    @Bean
    public Binding bindingQueue1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    /**
     * 将 fanoutQueue2 队列绑定到 fanout.exchange 交换机
     * @param fanoutQueue2 fanoutQueue2 队列
     * @param fanoutExchange fanout.exchange 交换机
     * @return Binding
     */
    @Bean
    public Binding bindingQueue2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}
