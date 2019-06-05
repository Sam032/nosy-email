package com.nosy.email.nosyemail.service;

import com.nosy.email.nosyemail.model.EmailProviderProperties;
import com.nosy.email.nosyemail.model.EmailTemplate;
import com.nosy.email.nosyemail.model.PlaceHolders;
import com.nosy.email.nosyemail.model.ReadyEmail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.util.ReflectionTestUtils;

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
        PlaceHolders placeHolders=new PlaceHolders();
        placeHolders.setName("name");
        placeHolders.setValue("value");
        EmailTemplate emailTemplate=new EmailTemplate();
        emailTemplate.setEmailTemplateName("emailTemplateName");
        emailTemplate.setEmailTemplateFromAddress("test@nosy.tech");
        emailTemplate.setEmailTemplateFromProvider("DEFAULT");
        emailTemplate.setEmailTemplateId("emailTemplateId");
        emailTemplate.setEmailTemplateRetryTimes(2);

        Set<String> emailTemplateToSet=new HashSet<>();
        String emailTemplateTo="nosyTo@email.to";
        String emailTemplateTo1="nosyTo1@email.to";

        emailTemplateToSet.add(emailTemplateTo);
        emailTemplateToSet.add(emailTemplateTo1);


        Set<String> emailTemplateCcSet=new HashSet<>();
        String emailTemplateCc="nosyCc@email.to";
        String emailTemplateCc1="nosyCc1@email.to";

        emailTemplateCcSet.add(emailTemplateCc);
        emailTemplateCcSet.add(emailTemplateCc1);


        emailTemplate.setEmailTemplateCc(emailTemplateCcSet);
        emailTemplate.setEmailTemplateTo(emailTemplateToSet);


        emailTemplate.setEmailTemplatePriority(1);
        emailTemplate.setEmailTemplateRetryPeriod(1);
        emailTemplate.setEmailTemplateRetryTimes(1);
        emailTemplate.setEmailTemplateSubject("subject");
        emailTemplate.setEmailTemplateText("text");
        emailTemplate.setEmailTemplatePriority(1);
        readyEmail.setEmailTemplate(emailTemplate);
        ReflectionTestUtils.setField(emailService, "emailDefaultUsername", "asdasd");
        ReflectionTestUtils.setField(emailService, "emailDefaultPassword", "asdasd");

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
    @Test
    public void NonDefault(){
        readyEmail.getEmailTemplate().setEmailTemplateFromProvider("Yandex");

        EmailProviderProperties emailProviderProperties=new EmailProviderProperties();
        emailProviderProperties.setPassword("dadad");
        emailProviderProperties.setUsername("dadasdas");
        readyEmail.setEmailProviderProperties(emailProviderProperties);

        JavaMailSenderImpl javaMailSender=mock(JavaMailSenderImpl.class);
        MimeMessage mimeMessage=mock(MimeMessage.class);
        when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);
        doNothing().when(javaMailSender).send(mimeMessage);
        emailService.send(readyEmail,javaMailSender);
    }
    @Test(expected = IllegalArgumentException.class)
    public void WithCcNull(){
        readyEmail.getEmailTemplate().setEmailTemplateFromProvider("Yandex");

        EmailProviderProperties emailProviderProperties=new EmailProviderProperties();
        emailProviderProperties.setPassword("dadad");
        emailProviderProperties.setUsername("dadasdas");
        readyEmail.setEmailProviderProperties(emailProviderProperties);
        Set<String> ccSet=new HashSet<>();
        ccSet.add(null);
        readyEmail.getEmailTemplate().setEmailTemplateCc(ccSet);
        JavaMailSenderImpl javaMailSender=mock(JavaMailSenderImpl.class);
        MimeMessage mimeMessage=mock(MimeMessage.class);
        when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);
        emailService.send(readyEmail,javaMailSender);
    }
    @Test(expected = IllegalArgumentException.class)
    public void WithToNull(){
        readyEmail.getEmailTemplate().setEmailTemplateFromProvider("Yandex");

        EmailProviderProperties emailProviderProperties=new EmailProviderProperties();
        emailProviderProperties.setPassword("dadad");
        emailProviderProperties.setUsername("dadasdas");
        readyEmail.setEmailProviderProperties(emailProviderProperties);
        Set<String> toSet=new HashSet<>();
        toSet.add(null);
        readyEmail.getEmailTemplate().setEmailTemplateTo(toSet);
        JavaMailSenderImpl javaMailSender=mock(JavaMailSenderImpl.class);
        MimeMessage mimeMessage=mock(MimeMessage.class);
        when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);
        emailService.send(readyEmail,javaMailSender);
    }
    }

