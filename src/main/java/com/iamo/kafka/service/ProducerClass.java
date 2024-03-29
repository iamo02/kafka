package com.iamo.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerClass {
	
	private static final Logger  logger = LoggerFactory.getLogger(ProducerClass.class);
	private static final String TOPIC = "user";
	
	@Autowired
	private KafkaTemplate kafkaTemplate;
	
	public void sendMessage(String message) {
		logger.info(String.format("+++++ Producer sending the messGE NOW -> %S", message));
		this.kafkaTemplate.send(TOPIC,message);
	}

}
