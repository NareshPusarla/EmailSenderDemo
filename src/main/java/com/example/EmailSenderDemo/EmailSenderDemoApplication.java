package com.example.EmailSenderDemo;

import com.example.EmailSenderDemo.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailSenderDemoApplication {

	@Autowired
	public EmailSenderService service;

	public static void main(String[] args) {

		SpringApplication.run(EmailSenderDemoApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail(){

		service.sendSimpleEmail("nareshn2213@gmail.com",
				"Hello,\n" +
						"\n" +
						"Please use the One Time Password (OTP) below on KF COMM 2 Repligen login portal. This OTP is valid for 30 minutes only.\n" +
						"\n" +
						"392614\n" +
						"\n" +
						"Thanks!\n" +
						"\n" +
						"KFCOMM 2 Repligen Team",
				"This email has otp");
	}
}
