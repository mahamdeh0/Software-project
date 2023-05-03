package fall2023project;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.*;

public class SendEmailExample {
    private static final Logger LOGGER = Logger.getLogger(SendEmailExample.class.getName());
    private SendEmailExample() {
    	
    }

    public static void sendEmail(String recipientEmail, String subject, String messageText) {
        final String username = "sam.sam12042589@gmail.com"; 
        final String pass = "wglirsvdsbxvpfhe"; 

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        	@Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, pass);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);

            LOGGER.info("Email sent successfully!");

        } catch (MessagingException e) {
        	LOGGER.info("Failed to send email. Error message: " + e.getMessage());
        }
    }
}