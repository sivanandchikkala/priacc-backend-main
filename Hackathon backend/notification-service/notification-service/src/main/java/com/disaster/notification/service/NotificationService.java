package com.disaster.notification.service;

import com.disaster.notification.dto.NotificationRequest;
import com.disaster.notification.util.EmailService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final EmailService emailService;

    @Value("${twilio.from-number}")
    private String fromNumber;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendNotification(NotificationRequest req) {
        // Email
        if (req.getRecipientEmail() != null && !req.getRecipientEmail().isEmpty()) {
            emailService.sendEmail(req.getRecipientEmail(), req.getSubject(), req.getMessage());
        }

        // SMS
        if (req.getRecipientPhone() != null && !req.getRecipientPhone().isEmpty()) {
            Message.creator(
                    new PhoneNumber(req.getRecipientPhone()),
                    new PhoneNumber(fromNumber),
                    req.getMessage()
            ).create();
            System.out.println("📱 SMS sent to: " + req.getRecipientPhone());
        }
    }
}
