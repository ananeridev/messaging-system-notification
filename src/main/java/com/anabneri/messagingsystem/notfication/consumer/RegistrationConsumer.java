package com.anabneri.messagingsystem.notfication.consumer;

import com.anabneri.messagingsystem.notfication.config.MessagingConfig;
import com.anabneri.messagingsystem.notfication.dto.RegistrationDTO;
import com.anabneri.messagingsystem.notfication.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class RegistrationConsumer {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private RegistrationService  service;

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationConsumer.class);


    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumer(RegistrationDTO registration) {
        LOGGER.info(String.format("Consuming the subscription %s", registration.getId()));
        service.saveRegistration(registration);
    }

}
