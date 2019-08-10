package com.nosy.email.nosyemail.service;

import com.nosy.email.nosyemail.model.ReadyEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceListener {

    private EmailService emailService;
    private JavaMailSenderImpl javaMailDefaultSender;
    private JavaMailSenderImpl javaMailGmailSender;
    private JavaMailSenderImpl javaMailYandexSender;

    @Autowired
    public EmailServiceListener(
            EmailService emailService,
            @Qualifier("Yandex") JavaMailSenderImpl javaMailYandexSender,
            @Qualifier("Default") JavaMailSenderImpl javaMailDefaultSender,
            @Qualifier("Gmail") JavaMailSenderImpl javaMailGmailSender
    ) {
        this.emailService = emailService;
        this.javaMailYandexSender = javaMailYandexSender;
        this.javaMailDefaultSender = javaMailDefaultSender;
        this.javaMailGmailSender = javaMailGmailSender;
    }

    public void handleReadyEmail(ReadyEmail readyEmail) {
        String emailProvider = readyEmail.getEmailTemplate().getEmailTemplateFromProvider();
        switch (emailProvider) {
            case "Yandex": {
                emailService.send(readyEmail, javaMailYandexSender);
                break;
            }
            case "Gmail": {
                emailService.send(readyEmail, javaMailGmailSender);
                break;
            }
            default: {
                emailService.send(readyEmail, javaMailDefaultSender);
                break;
            }
        }
    }

}
