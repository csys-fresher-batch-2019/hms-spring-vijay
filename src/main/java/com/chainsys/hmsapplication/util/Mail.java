package com.chainsys.hmsapplication.util.mail;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Mail

{

	private static final Logger LOGGER = LoggerFactory.getLogger(Mail.class);

	public static void send(final String from, final String password, String to, String sub, int appid, int patientid,
			int doctorid, LocalDate appdate, String apptime) throws IOException {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.ssl.checkserveridentity", true);
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			Multipart multipart = messageBody(appid, patientid, doctorid, appdate, apptime);
			message.setContent(multipart);
			Transport.send(message);
			LOGGER.info("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private static Multipart messageBody(int appid, int patientid, int doctorid, LocalDate appdate, String apptime)
			throws MessagingException {
		BodyPart messageBodyPart1 = new MimeBodyPart();
		messageBodyPart1.setText("Hello sir ! Please be on time for your appointment to meet your personalized doctor");
		BodyPart messageBodyPart2 = new MimeBodyPart();
		messageBodyPart2.setText("\nAppointment Id :" + appid);
		BodyPart messageBodyPart3 = new MimeBodyPart();
		messageBodyPart3.setText("\npatient Id :" + patientid);
		BodyPart messageBodyPart4 = new MimeBodyPart();
		messageBodyPart4.setText("\nDoctor Id :" + doctorid);
		BodyPart messageBodyPart5 = new MimeBodyPart();
		messageBodyPart5.setText("\nAppointment time :" + apptime);
		BodyPart messageBodyPart6 = new MimeBodyPart();
		messageBodyPart6.setText("\nAppointment date :" + appdate);

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart1);
		multipart.addBodyPart(messageBodyPart2);
		multipart.addBodyPart(messageBodyPart3);
		multipart.addBodyPart(messageBodyPart4);
		multipart.addBodyPart(messageBodyPart5);
		multipart.addBodyPart(messageBodyPart6);

		return multipart;
	}
}
