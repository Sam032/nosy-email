package com.nosy.email.nosyemail.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)

public class EmailConfigsTest {

  @InjectMocks
  EmailConfigs emailConfigs;


  @Test
  public void javaMailYandexSender() {
    assertEquals("smtp.yandex.ru",emailConfigs.javaMailYandexSender().getHost());


  }

  @Test
  public void javaMailGmailSender() {
    assertEquals("smtp.yandex.ru",emailConfigs.javaMailDefaultSender().getHost());


  }

  @Test
  public void javaMailDefaultSender() {
    assertEquals("smtp.gmail.com",emailConfigs.javaMailGmailSender().getHost());

  }
}
