package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.entity.EmailRequest;
import com.email.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/send-email")
	public void sendEmail(@RequestBody EmailRequest request) {
		// Validate request data
		emailService.sendSimpleEmail(request.getTo(), request.getSubject(), request.getText());
	}

	// ... other endpoints for attachments and inline images
}
