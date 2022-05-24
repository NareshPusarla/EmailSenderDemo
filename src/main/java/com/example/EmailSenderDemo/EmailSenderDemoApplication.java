package com.example.EmailSenderDemo;

import com.example.EmailSenderDemo.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Random;

@SpringBootApplication
public class EmailSenderDemoApplication {

	public static String getRandomNumberString() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		return String.format("%06d", number);
	}

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
						getRandomNumberString()+"\n" +
						"\n" +
						"Thanks!\n" +
						"\n" +
						"KFCOMM 2 Repligen Team",
				"This email has otp");
	}
}
