package com.nosy.email.nosyemail.service;

import com.nosy.email.nosyemail.model.EmailTemplate;
import com.nosy.email.nosyemail.model.ReadyEmail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;


@RunWith(MockitoJUnitRunner.class)
public class EmailServiceListenerTest {
  @InjectMocks
  EmailServiceListener emailServiceListener;

  @Mock
  EmailService emailService;


  private ReadyEmail readyEmail;
  private EmailTemplate emailTemplate;


  @Test(expected = Test.None.class)
  public void handleGreetings() {
    readyEmail=new ReadyEmail();
    EmailTemplate emailTemplate=new EmailTemplate();
    emailTemplate.setEmailTemplateName("emailTemplateName");
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

    doNothing().when(emailService).send(any(), any());
    emailServiceListener.handleGreetings(readyEmail);


  }

  @Test(expected = Test.None.class)
  public void handleGreetingsYandex() {
    readyEmail=new ReadyEmail();
    EmailTemplate emailTemplate=new EmailTemplate();
    emailTemplate.setEmailTemplateName("emailTemplateName");
    emailTemplate.setFromAddress("test@nosy.tech");
    emailTemplate.setEmailFromProvider("Yandex");
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

    doNothing().when(emailService).send(any(), any());

    emailServiceListener.handleGreetings(readyEmail);


  }

  @Test(expected = Test.None.class)
  public void handleGreetingsGmail() {
    readyEmail=new ReadyEmail();
    EmailTemplate emailTemplate=new EmailTemplate();
    emailTemplate.setEmailTemplateName("emailTemplateName");
    emailTemplate.setFromAddress("test@nosy.tech");
    emailTemplate.setEmailFromProvider("Yandex");
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

    doNothing().when(emailService).send(any(), any());

    emailServiceListener.handleGreetings(readyEmail);

  }

}
