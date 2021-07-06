package apiEngine.Utilies;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    Session mailSession;

    public static void emailSender(String mail, String toEmail, String subject) throws AddressException, MessagingException
    {
        EmailSender javaEmail = new EmailSender();
        javaEmail.setMailServerProperties();
        javaEmail.draftEmailMessage(toEmail, mail, subject);
        javaEmail.sendEmail(toEmail, mail, subject);
    }

    private void setMailServerProperties()
    {
        Properties emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", "587");
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
        mailSession = Session.getDefaultInstance(emailProperties, null);
    }

    private MimeMessage draftEmailMessage(String toEmail, String mail, String subject) throws AddressException, MessagingException
    {
        String[] toEmails = { toEmail };
        String emailSubject = subject;
        String emailBody =  mail;
        MimeMessage emailMessage = new MimeMessage(mailSession);
        /**
         * Set the mail recipients
         * */
        for (int i = 0; i < toEmails.length; i++)
        {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
        }
        emailMessage.setSubject(emailSubject);
        /**
         * If sending HTML mail
         * */
        emailMessage.setContent(emailBody, "text/html");
        /**
         * If sending only text mail
         * */
        //emailMessage.setText(emailBody);// for a text email
        return emailMessage;
    }

    private void sendEmail(String toEmail, String mail, String subject) throws AddressException, MessagingException
    {
        /**
         * Sender's credentials
         * */
        String fromUser = "tugccekor@gmail.com";
        String fromUserEmailPassword = "Mahallefrvr1!";

        String emailHost = "smtp.gmail.com";
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserEmailPassword);
        /**
         * Draft the message
         * */
        MimeMessage emailMessage = draftEmailMessage(toEmail, mail ,subject);
        /**
         * Send the mail
         * */
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }
}

