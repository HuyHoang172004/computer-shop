package com.techecommerce.util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
    private final JavaMailSender mailSender;

    public EmailUtil(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    public void sendVerificationEmail(String to, String token) {
        String subject = "Verify your email address";
        String text = "Please click the link below to verify your email address:\n" +
                "http://localhost:8080/api/auth/verify-email?token=" + token;
        sendEmail(to, subject, text);
    }

    public void sendPasswordResetEmail(String to, String token) {
        String subject = "Reset your password";
        String text = "Please click the link below to reset your password:\n" +
                "http://localhost:8080/api/auth/reset-password?token=" + token;
        sendEmail(to, subject, text);
    }

    public void sendOrderConfirmationEmail(String to, String orderId) {
        String subject = "Order Confirmation";
        String text = "Your order has been confirmed. Order ID: " + orderId;
        sendEmail(to, subject, text);
    }

    public void sendOrderStatusUpdateEmail(String to, String orderId, String status) {
        String subject = "Order Status Update";
        String text = "Your order status has been updated. Order ID: " + orderId + ", Status: " + status;
        sendEmail(to, subject, text);
    }
} 