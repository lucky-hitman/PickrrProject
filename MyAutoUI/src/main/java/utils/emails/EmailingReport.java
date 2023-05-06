package utils.emails;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EmailingReport {

    public static void emailSend(String text) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("testAutoSelen007@gmail.com",
                                "fqkisyhbmdlshiag");
                    } });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new
                    InternetAddress("testAutoSelen007@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("lokesh.gahlawat2010@gmail.com"));
            message.setSubject("Testing Subject");

            BodyPart messageBodyPart1 = new MimeBodyPart();

            messageBodyPart1.setText("Please Find attached the report for Sanity Suite");

            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            String filename = "MyAutoUI/target/spark/Spark.html";

            DataSource source = new FileDataSource(filename);

            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName(filename);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart2);
            multipart.addBodyPart(messageBodyPart1);
            message.setContent(multipart);
            Transport.send(message);

            System.out.println("=====Email Sent=====");

        } catch (MessagingException e) {

            throw new RuntimeException(e);

        }
    }
}
