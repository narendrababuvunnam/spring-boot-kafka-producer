package com.nnn.springbootkafkaproducer;


import org.springframework.web.bind.annotation.RestController;

import com.nnn.springbootkafkaproducer.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("kafka")
public class UserResource {
	
	@Autowired
	private KafkaTemplate<String, UserModel> kafkaTemplate;
	private static final String TOPIC = "Kafka_Example";
	
	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String name) {
		kafkaTemplate.send(TOPIC, new UserModel(name, "technology", "1200L"));
		
		return "publised successfully";
	}

}
