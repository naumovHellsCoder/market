package com.naumov.productservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class MqConfig {
    public static final String messageQueueName = "message_queue_product";
    public static final String ROUTENAME = "message_routingKey";
    public static final String EXCHANGE = "message_queue_exchange";
    @Bean
    public Queue queue(){
        return new Queue(messageQueueName);
    }
    @Bean
    public TopicExchange topicExchange(){
        return  new TopicExchange(EXCHANGE);
    }
    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange){
        return BindingBuilder
                .bind(queue)
                .to(topicExchange)
                .with(ROUTENAME);
    }
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
