package com.iamo.kafka.controller;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iamo.kafka.service.ProducerClass;

@RestController
@RequestMapping("kafka")
public class KafkaController {

	private final ProducerClass producer;
	public KafkaController(ProducerClass producer) {
		this.producer= producer;
	}
	
	@PostMapping(value = "/public")
	public String sendMessage(@RequestParam("message") String message) {
		this.producer.sendMessage(message);
		return "";
	}
	
	@Bean
	public NewTopic adviceTopic() {
	    return new NewTopic("user", 1, (short) 2);
	}
}
