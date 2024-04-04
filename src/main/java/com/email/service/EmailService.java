package com.email.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;  // Use JavaMailSender for advanced features

    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sn2331@outlook.com");  // Set default from address
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    public void sendEmailWithAttachment(String to, String subject, String text, String attachmentPath) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);  // True for multipart
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            FileSystemResource file = new FileSystemResource(new File(attachmentPath));
            helper.addAttachment("CoolImage.jpg", file);
            mailSender.send(message);
        } catch (MessagingException e) {
            // Handle exception
        }
    }

    public void sendEmailWithInlineImage(String to, String subject, String text, String imagePath, String contentId) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);  // True for multipart
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);  // True for HTML content
            FileSystemResource res = new FileSystemResource(new File(imagePath));
            helper.addInline(contentId, res);
            mailSender.send(message);
        } catch (MessagingException e) {
            // Handle exception
        }
    }
}
