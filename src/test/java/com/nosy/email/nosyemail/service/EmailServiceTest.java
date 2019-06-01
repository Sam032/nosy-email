package com.nosy.email.nosyemail.service;

import com.nosy.email.nosyemail.model.EmailProviderProperties;
import com.nosy.email.nosyemail.model.EmailTemplate;
import com.nosy.email.nosyemail.model.ReadyEmail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.internet.MimeMessage;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class EmailServiceTest {
    @InjectMocks
    private EmailService emailService;
    private ReadyEmail readyEmail;

    @Before
    public void setUp(){
        readyEmail=new ReadyEmail();
        EmailTemplate emailTemplate=new EmailTemplate();
        emailTemplate.setFromAddress("test@nosy.tech");
        emailTemplate.setEmailFromProvider("DEFAULT");
        emailTemplate.setEmailTemplateId("emailTemplateId");
        Set<String> emailTemplateToSet=new HashSet<>();
        String emailTemplateTo="nosy@email.to";
        emailTemplateToSet.add(emailTemplateTo);
        Set<String> emailTemplateCcSet=new HashSet<>();
        String emailTemplateCc="nosy@email.to";
        emailTemplateToSet.add(emailTemplateCc);

        emailTemplate.setEmailTemplateCc(emailTemplateCcSet);
        emailTemplate.setEmailTemplateTo(emailTemplateToSet);
        emailTemplate.setPriority(1);
        emailTemplate.setRetryPeriod(1);
        emailTemplate.setRetryTimes(1);
        emailTemplate.setSubject("subject");
        emailTemplate.setText("text");
        readyEmail.setEmailTemplate(emailTemplate);


    }



  @Test(expected = Test.None.class)
  public void send() {
      EmailProviderProperties emailProviderProperties=new EmailProviderProperties();
      emailProviderProperties.setPassword("dadad");
      emailProviderProperties.setUsername("dadasdas");
      JavaMailSenderImpl javaMailSender=mock(JavaMailSenderImpl.class);
      MimeMessage mimeMessage=mock(MimeMessage.class);
      when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);
      doNothing().when(javaMailSender).send(mimeMessage);
      emailService.send(readyEmail,javaMailSender);


  }
}
