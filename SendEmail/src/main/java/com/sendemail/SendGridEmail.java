package com.sendemail;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class SendGridEmail {
  public static void main(String[] args) {
    SendGrid sg = new SendGrid("smtp.sendgrid.net");

    Email from = new Email("rajeshkumar.vaja@majesco.com");
    String subject = "Sending with SendGrid is Fun";
    Email to = new Email("hemanttripathi1@kpmg.com");
    Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
    Mail mail = new Mail(from, subject, to, content);

    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }

    Response response;
    try {
      response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}

