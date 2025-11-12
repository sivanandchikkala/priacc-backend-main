package com.disaster.notification.controller;

import com.disaster.notification.dto.NotificationRequest;
import com.disaster.notification.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notify")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> sendAlert(@RequestBody NotificationRequest req) {
        service.sendNotification(req);
        return ResponseEntity.ok("✅ Notification sent successfully");
    }
}
