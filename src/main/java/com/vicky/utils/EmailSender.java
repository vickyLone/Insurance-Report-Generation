package com.vicky.utils;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String toEmail, String subject, String body, File file) throws MessagingException {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setFrom("lonevicky@gmail.com.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.addAttachment(file.getName(), file);
		mailSender.send(mimeMessage);

		/*
		 * FileSystemResource fileSystemResource = new FileSystemResource(new
		 * File(attachment));
		 * mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),
		 * fileSystemResource);
		 */		
	}

}
