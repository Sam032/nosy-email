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
    emailTemplate.setEmailTemplateFromAddress("test@nosy.tech");
    emailTemplate.setEmailTemplateFromProvider("DEFAULT");
    emailTemplate.setEmailTemplateId("emailTemplateId");
    Set<String> emailTemplateToSet=new HashSet<>();
    String emailTemplateTo="nosy@email.to";
    emailTemplateToSet.add(emailTemplateTo);
    Set<String> emailTemplateCcSet=new HashSet<>();
    String emailTemplateCc="nosy@email.to";
    emailTemplateToSet.add(emailTemplateCc);

    emailTemplate.setEmailTemplateCc(emailTemplateCcSet);
    emailTemplate.setEmailTemplateTo(emailTemplateToSet);
    emailTemplate.setEmailTemplatePriority(1);
    emailTemplate.setEmailTemplateRetryPeriod(1);
    emailTemplate.setEmailTemplateRetryTimes(1);
    emailTemplate.setEmailTemplateSubject("subject");
    emailTemplate.setEmailTemplateText("text");
    readyEmail.setEmailTemplate(emailTemplate);

    doNothing().when(emailService).send(any(), any());
    emailServiceListener.handleGreetings(readyEmail);


  }

  @Test(expected = Test.None.class)
  public void handleGreetingsYandex() {
    readyEmail=new ReadyEmail();
    EmailTemplate emailTemplate=new EmailTemplate();
    emailTemplate.setEmailTemplateName("emailTemplateName");
    emailTemplate.setEmailTemplateFromAddress("test@nosy.tech");
    emailTemplate.setEmailTemplateFromProvider("Yandex");
    emailTemplate.setEmailTemplateId("emailTemplateId");
    Set<String> emailTemplateToSet=new HashSet<>();
    String emailTemplateTo="nosy@email.to";
    emailTemplateToSet.add(emailTemplateTo);
    Set<String> emailTemplateCcSet=new HashSet<>();
    String emailTemplateCc="nosy@email.to";
    emailTemplateToSet.add(emailTemplateCc);

    emailTemplate.setEmailTemplateCc(emailTemplateCcSet);
    emailTemplate.setEmailTemplateTo(emailTemplateToSet);
    emailTemplate.setEmailTemplatePriority(1);
    emailTemplate.setEmailTemplateRetryPeriod(1);
    emailTemplate.setEmailTemplateRetryTimes(1);
    emailTemplate.setEmailTemplateSubject("subject");
    emailTemplate.setEmailTemplateText("text");
    readyEmail.setEmailTemplate(emailTemplate);

    doNothing().when(emailService).send(any(), any());

    emailServiceListener.handleGreetings(readyEmail);


  }

  @Test(expected = Test.None.class)
  public void handleGreetingsGmail() {
    readyEmail=new ReadyEmail();
    EmailTemplate emailTemplate=new EmailTemplate();
    emailTemplate.setEmailTemplateName("emailTemplateName");
    emailTemplate.setEmailTemplateFromAddress("test@nosy.tech");
    emailTemplate.setEmailTemplateFromProvider("Gmail");
    emailTemplate.setEmailTemplateId("emailTemplateId");
    Set<String> emailTemplateToSet=new HashSet<>();
    String emailTemplateTo="nosy@email.to";
    emailTemplateToSet.add(emailTemplateTo);
    Set<String> emailTemplateCcSet=new HashSet<>();
    String emailTemplateCc="nosy@email.to";
    emailTemplateToSet.add(emailTemplateCc);

    emailTemplate.setEmailTemplateCc(emailTemplateCcSet);
    emailTemplate.setEmailTemplateTo(emailTemplateToSet);
    emailTemplate.setEmailTemplatePriority(1);
    emailTemplate.setEmailTemplateRetryPeriod(1);
    emailTemplate.setEmailTemplateRetryTimes(1);
    emailTemplate.setEmailTemplateSubject("subject");
    emailTemplate.setEmailTemplateText("text");
    readyEmail.setEmailTemplate(emailTemplate);

    doNothing().when(emailService).send(any(), any());

    emailServiceListener.handleGreetings(readyEmail);

  }

}
