package org.Tayana.ApacheKafka.controller;

import org.Tayana.ApacheKafka.dto.Ecommerce;
import org.Tayana.ApacheKafka.producer.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

	@Autowired
	private KafkaProducerService kafkaProducer;

   
    @PostMapping("/commerce")
    public String sendMessageToKafkaTopic(@RequestBody Ecommerce message) 
    {
    	System.out.println("hiii");
    	kafkaProducer.sendMessage(message);
    	return "Message published to Kafka topic!";
    }
}

