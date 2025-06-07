package com.techecommerce.service;

import com.techecommerce.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public void sendVerificationEmail(User user) {
        try {
            Context context = new Context();
            context.setVariable("name", user.getName());
            context.setVariable("verificationLink", "http://localhost:3000/verify-email?token=" + user.getEmailVerificationToken());

            String emailContent = templateEngine.process("verification-email", context);

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(user.getEmail());
            helper.setSubject("Verify your email");
            helper.setText(emailContent, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send verification email", e);
        }
    }

    public void sendPasswordResetEmail(User user) {
        try {
            Context context = new Context();
            context.setVariable("name", user.getName());
            context.setVariable("resetLink", "http://localhost:3000/reset-password?token=" + user.getPasswordResetToken());

            String emailContent = templateEngine.process("password-reset-email", context);

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(user.getEmail());
            helper.setSubject("Reset your password");
            helper.setText(emailContent, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send password reset email", e);
        }
    }

    public void sendOrderStatusUpdateEmail(User user, String orderId, String status) {
        try {
            Context context = new Context();
            context.setVariable("name", user.getName());
            context.setVariable("orderId", orderId);
            context.setVariable("status", status);
            context.setVariable("orderLink", "http://localhost:3000/orders/" + orderId);

            String emailContent = templateEngine.process("order-status-update-email", context);

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(user.getEmail());
            helper.setSubject("Order status update");
            helper.setText(emailContent, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send order status update email", e);
        }
    }
} 