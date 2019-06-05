package com.nosy.email.nosyemail.model;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class EmailTemplate {
  private String emailTemplateId;
  private String emailTemplateName;
  private String emailTemplateFromAddress;
  private String emailTemplateFromProvider;
  private Set<String> emailTemplateTo;
  private Set<String> emailTemplateCc;
  private String emailTemplateText;
  private int emailTemplateRetryTimes;
  private int emailTemplateRetryPeriod;
  private int emailTemplatePriority;
  private String emailTemplateSubject;


  public String getEmailTemplateId() {
    return emailTemplateId;
  }

  public void setEmailTemplateId(String emailTemplateId) {
    this.emailTemplateId = emailTemplateId;
  }

  public String getEmailTemplateName() {
    return emailTemplateName;
  }

  public void setEmailTemplateName(String emailTemplateName) {
    this.emailTemplateName = emailTemplateName;
  }


  public Set<String> getEmailTemplateTo() {
    return emailTemplateTo;
  }

  public void setEmailTemplateTo(Set<String> emailTemplateTo) {
    this.emailTemplateTo = emailTemplateTo;
  }

  public Set<String> getEmailTemplateCc() {
    return emailTemplateCc;
  }

  public void setEmailTemplateCc(Set<String> emailTemplateCc) {
    this.emailTemplateCc = emailTemplateCc;
  }

  public String getEmailTemplateFromAddress() {
    return emailTemplateFromAddress;
  }

  public void setEmailTemplateFromAddress(String emailTemplateFromAddress) {
    this.emailTemplateFromAddress = emailTemplateFromAddress;
  }

  public String getEmailTemplateFromProvider() {
    return emailTemplateFromProvider;
  }

  public void setEmailTemplateFromProvider(String emailTemplateFromProvider) {
    this.emailTemplateFromProvider = emailTemplateFromProvider;
  }

  public String getEmailTemplateText() {
    return emailTemplateText;
  }

  public void setEmailTemplateText(String emailTemplateText) {
    this.emailTemplateText = emailTemplateText;
  }

  public int getEmailTemplateRetryTimes() {
    return emailTemplateRetryTimes;
  }

  public void setEmailTemplateRetryTimes(int emailTemplateRetryTimes) {
    this.emailTemplateRetryTimes = emailTemplateRetryTimes;
  }

  public int getEmailTemplateRetryPeriod() {
    return emailTemplateRetryPeriod;
  }

  public void setEmailTemplateRetryPeriod(int emailTemplateRetryPeriod) {
    this.emailTemplateRetryPeriod = emailTemplateRetryPeriod;
  }

  public int getEmailTemplatePriority() {
    return emailTemplatePriority;
  }

  public void setEmailTemplatePriority(int emailTemplatePriority) {
    this.emailTemplatePriority = emailTemplatePriority;
  }

  public String getEmailTemplateSubject() {
    return emailTemplateSubject;
  }

  public void setEmailTemplateSubject(String emailTemplateSubject) {
    this.emailTemplateSubject = emailTemplateSubject;
  }

  @Override
  public String toString() {
    return "EmailTemplate{" +
            "emailTemplateId='" + emailTemplateId + '\'' +
            ", emailTemplateName='" + emailTemplateName + '\'' +
            ", emailTemplateFromAddress='" + emailTemplateFromAddress + '\'' +
            ", emailTemplateFromProvider='" + emailTemplateFromProvider + '\'' +
            ", emailTemplateTo=" + emailTemplateTo +
            ", emailTemplateCc=" + emailTemplateCc +
            ", emailTemplateText='" + emailTemplateText + '\'' +
            ", emailTemplateRetryTimes=" + emailTemplateRetryTimes +
            ", emailTemplateRetryPeriod=" + emailTemplateRetryPeriod +
            ", emailTemplatePriority=" + emailTemplatePriority +
            ", emailTemplateSubject='" + emailTemplateSubject + '\'' +
            '}';
  }
}
