package com.nosy.email.nosyemail.integrations;

import com.nosy.email.nosyemail.model.ReadyEmail;
import com.nosy.email.nosyemail.service.EmailServiceListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ArtemisConsumer {

    private EmailServiceListener emailServiceListener;

    @Autowired
    public ArtemisConsumer(EmailServiceListener emailServiceListener) {
        this.emailServiceListener = emailServiceListener;
    }

    @JmsListener(destination = "${ARTEMIS_BROKER_QUEUE}", containerFactory = "jmsListenerContainerFactory")
    public void artemisListener(@Payload ReadyEmail readyEmail){
        emailServiceListener.handleReadyEmail(readyEmail);
    }

}
