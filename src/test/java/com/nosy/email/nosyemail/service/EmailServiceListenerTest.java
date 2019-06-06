package com.nosy.email.nosyemail.service;

import com.nosy.email.nosyemail.model.EmailProviderProperties;
import com.nosy.email.nosyemail.model.EmailTemplate;
import com.nosy.email.nosyemail.model.PlaceHolders;
import com.nosy.email.nosyemail.model.ReadyEmail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
  private PlaceHolders placeHolders;
  private List<PlaceHolders> placeHoldersList=new ArrayList<>();
  @Before
  public void setUp(){
    emailTemplate=new EmailTemplate();
    placeHolders=new PlaceHolders();
    placeHolders.setName("name");
    placeHolders.setValue("value");
    placeHoldersList.add(placeHolders);
    emailTemplate.setEmailTemplateName("emailTemplateName");
    emailTemplate.setEmailTemplateFromAddress("test@nosy.tech");
    emailTemplate.setEmailTemplateId("emailTemplateId");
    Set<String> emailTemplateToSet=new HashSet<>();
    String emailTemplateTo="nosy@email.to";
    String emailTemplateTo1="test@email.to";
    emailTemplateToSet.add(emailTemplateTo);
    emailTemplateToSet.add(emailTemplateTo1);



    Set<String> emailTemplateCcSet=new HashSet<>();
    String emailTemplateCc="nosy@email.to";
    emailTemplateCcSet.add(emailTemplateCc);



    emailTemplate.setEmailTemplateCc(emailTemplateCcSet);
    emailTemplate.setEmailTemplateTo(emailTemplateToSet);
    emailTemplate.setEmailTemplatePriority(1);
    emailTemplate.setEmailTemplateRetryPeriod(1);
    emailTemplate.setEmailTemplateRetryTimes(1);
    emailTemplate.setEmailTemplateSubject("subject");
    emailTemplate.setEmailTemplateText("text");


  }


  @Test(expected = Test.None.class)
  public void handleGreetings() {
    readyEmail=new ReadyEmail();
    emailTemplate.setEmailTemplateFromProvider("DEFAULT");
    readyEmail.setEmailTemplate(emailTemplate);
    doNothing().when(emailService).send(any(), any());
    emailServiceListener.handleGreetings(readyEmail);


  }

  @Test(expected = Test.None.class)
  public void handleGreetingsYandex() {
    readyEmail=new ReadyEmail();
    emailTemplate.setEmailTemplateFromProvider("Yandex");
    readyEmail.setEmailTemplate(emailTemplate);
    emailServiceListener.handleGreetings(readyEmail);
  }

  @Test(expected = Test.None.class)
  public void handleGreetingsGmail() {
    readyEmail=new ReadyEmail();
    emailTemplate.setEmailTemplateFromProvider("Gmail");
    readyEmail.setEmailTemplate(emailTemplate);
    doNothing().when(emailService).send(any(), any());
    emailServiceListener.handleGreetings(readyEmail);
  }
  @Test(expected = Test.None.class)
  public void checkEmailTemplate() {
    EmailProviderProperties emailProviderProperties=new EmailProviderProperties();
    emailProviderProperties.setUsername("username");
    emailProviderProperties.setPassword("password");
    readyEmail=new ReadyEmail();
    readyEmail.setEmailTemplate(emailTemplate);
    emailTemplate.setEmailTemplateFromProvider("Gmail");

    emailProviderProperties.setPlaceholders(placeHoldersList);

    readyEmail.setEmailProviderProperties(emailProviderProperties);
    assertEquals("emailTemplateId", emailTemplate.getEmailTemplateId());
    assertEquals("emailTemplateName", emailTemplate.getEmailTemplateName());
    assertEquals(1, emailTemplate.getEmailTemplateRetryTimes());
    assertEquals(1, emailTemplate.getEmailTemplateRetryPeriod());
    assertEquals(1, emailTemplate.getEmailTemplatePriority());
    assertEquals("name", emailProviderProperties.getPlaceholders().get(0).getName());
    assertEquals("value", emailProviderProperties.getPlaceholders().get(0).getValue());

  }




}
