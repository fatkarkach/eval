package com.controller;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class SendMail {
    public  static Object a;
    public static void go(String toEmail,String Email,String code_active) throws MessagingException, IOException {
        //authentication info

        final String username = "";
        final String password = "";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });
        //Start our mail message
        Message message = null;

        message = prepareMessage(session, username,toEmail,Email,code_active);
        Transport.send(message);

    }

    private static Message prepareMessage(Session session, String username, String toEmail,String Email ,String code_active) throws MessagingException, MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject("Groupe Marjan Maroc ");
        message.setText("Bienvenue Dans l'Application MarjanPromo  : Vos information pour connecter\n "
                +"==>Adresse Email"+Email +"\n"+
                "==>Mode Passe : "+code_active);

        return  message;
    }
}
