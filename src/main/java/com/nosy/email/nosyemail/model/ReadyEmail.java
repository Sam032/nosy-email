package com.nosy.email.nosyemail.model;

import org.springframework.stereotype.Component;

@Component
public class ReadyEmail {
  private EmailProviderProperties emailProviderProperties;
  private EmailTemplate emailTemplate;

  public EmailProviderProperties getEmailProviderProperties() {
    return emailProviderProperties;
  }

  public void setEmailProviderProperties(EmailProviderProperties emailProviderProperties) {
    this.emailProviderProperties = emailProviderProperties;
  }

  public EmailTemplate getEmailTemplate() {
    return emailTemplate;
  }

  public void setEmailTemplate(EmailTemplate emailTemplate) {
    this.emailTemplate = emailTemplate;
  }

  @Override
  public String toString() {
    return "ReadyEmail{"
        + "emailProviderProperties="
        + emailProviderProperties
        + ", emailTemplate="
        + emailTemplate
        + '}';
  }
}
