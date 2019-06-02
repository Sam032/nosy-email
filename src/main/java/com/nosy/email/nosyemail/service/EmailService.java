package com.nosy.email.nosyemail.service;

import com.nosy.email.nosyemail.model.ReadyEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@Component
public class EmailService {
    private static final String DEFAULT_FROM_PROVIDER="DEFAULT";
    private Logger logger = LoggerFactory.getLogger(EmailService.class);

  @Value("${nosy.email.default.username}")
  private String emailDefaultUsername;

    @Value("${nosy.email.default.password}")
    private String emailDefaultPassword;

    public void send(ReadyEmail readyEmail, JavaMailSenderImpl javaMailSender){
        if (readyEmail.getEmailTemplate().getEmailFromProvider().equals(DEFAULT_FROM_PROVIDER) ||

                readyEmail.getEmailTemplate().getFromAddress()==null) {
            javaMailSender.setUsername(emailDefaultUsername);
            javaMailSender.setPassword(emailDefaultPassword);
            readyEmail.getEmailTemplate().setFromAddress(emailDefaultUsername);
        }
        else{
            javaMailSender.setUsername(readyEmail.getEmailProviderProperties().getUsername());
            javaMailSender.setPassword(readyEmail.getEmailProviderProperties().getPassword());
        }
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);
        try {

            if (readyEmail.getEmailTemplate().getFromAddress() != null) {
                mimeMessageHelper.setFrom(readyEmail.getEmailTemplate().getFromAddress());
            }
            mimeMessageHelper.setSubject(readyEmail.getEmailTemplate().getSubject());
            mimeMessageHelper.setText(
                    readyEmail.getEmailTemplate().getFromAddress()
                            + ":   "
                            + readyEmail.getEmailTemplate().getText(),
                    true);
            readyEmail
                    .getEmailTemplate()
                    .getEmailTemplateTo()
                    .forEach(
                            emailTo -> {
                                try {
                                    mimeMessageHelper.addTo(emailTo);
                                } catch (MessagingException e) {
                                    logger.error(e.getMessage());
                                }
                            });

            if (!readyEmail.getEmailTemplate().getEmailTemplateCc().isEmpty()) {
                readyEmail
                        .getEmailTemplate()
                        .getEmailTemplateCc()
                        .forEach(
                                emailCc -> {
                                    try {
                                        mimeMessageHelper.addCc(emailCc);

                                    } catch (MessagingException e) {
                                        logger.error(e.getMessage());
                                    }
                                });
            }

            javaMailSender.send(message);
        } catch (MessagingException messageException) {
            logger.error(messageException.getMessage());
        }

    }
}
