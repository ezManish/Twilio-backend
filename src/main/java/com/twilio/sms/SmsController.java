package com.twilio.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sms")
@CrossOrigin(origins = "*") // Allow requests from any origin (e.g., your React Native app)
public class SmsController {

    @Autowired
    private TwilioService twilioService;

    @PostMapping("/send")
    public ResponseEntity<String> sendSms(@RequestBody SmsRequest request) {
        System.out.println("Processing SMS request for: " + request.getTo());
        try {
            String sid = twilioService.sendSms(request);
            System.out.println("SMS sent successfully with SID: " + sid);
            return ResponseEntity.ok("SMS sent successfully! SID: " + sid);
        } catch (Exception e) {
            e.printStackTrace(); // Log the full error to console
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send SMS: " + e.getMessage());
        }
    }
}
