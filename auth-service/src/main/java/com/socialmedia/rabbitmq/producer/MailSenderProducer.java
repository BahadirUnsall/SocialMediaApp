package com.socialmedia.rabbitmq.producer;

import com.socialmedia.rabbitmq.model.MailSenderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.auth-exchange}")
    private String directExchange;

    @Value("${rabbitmq.mail-bindingKey}")
    private String mailBindingKey;

    public void convertAndSendToRabbit(MailSenderModel model){
        rabbitTemplate.convertAndSend(directExchange,mailBindingKey,model);
    }
}
