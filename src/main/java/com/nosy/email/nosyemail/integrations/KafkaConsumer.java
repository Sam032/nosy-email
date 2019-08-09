package com.nosy.email.nosyemail.integrations;

import com.nosy.email.nosyemail.model.ReadyEmail;
import com.nosy.email.nosyemail.service.EmailServiceListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private EmailServiceListener emailServiceListener;

    @Autowired
    public KafkaConsumer(EmailServiceListener emailServiceListener) {
        this.emailServiceListener = emailServiceListener;
    }

    @KafkaListener(topics = "${NOSY_ADMIN_EMAIL_TOPIC}")
    public void kafkaListener(@Payload ReadyEmail readyEmail) {
        emailServiceListener.handleReadyEmail(readyEmail);
    }


}
