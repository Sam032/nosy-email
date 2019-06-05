package com.nosy.email.nosyemail.service;

import com.nosy.email.nosyemail.model.ReadyEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class EmailServiceListener {
  private EmailService emailService;


  private JavaMailSenderImpl javaMailDefaultSender;


  private JavaMailSenderImpl javaMailGmailSender;


  private JavaMailSenderImpl javaMailYandexSender;



  @Autowired
  public EmailServiceListener(EmailService emailService,
                              @Qualifier("Yandex") JavaMailSenderImpl javaMailYandexSender,
                              @Qualifier("Default") JavaMailSenderImpl javaMailDefaultSender,
                              @Qualifier("Gmail") JavaMailSenderImpl javaMailGmailSender) {
    this.emailService = emailService;

    this.javaMailYandexSender = javaMailYandexSender;
    this.javaMailDefaultSender = javaMailDefaultSender;
    this.javaMailGmailSender = javaMailGmailSender;
  }

  @KafkaListener(topics = "nosy-admin")
  public void handleGreetings(@Payload ReadyEmail readyEmail) {
    if (readyEmail.getEmailTemplate().getEmailTemplateFromProvider().equals("Yandex")) {
      emailService.send(readyEmail, javaMailYandexSender);
    } else if (readyEmail.getEmailTemplate().getEmailTemplateFromProvider().equals("Gmail")) {
      emailService.send(readyEmail, javaMailGmailSender);
    } else {
      emailService.send(readyEmail, javaMailDefaultSender);
    }
  }
}
