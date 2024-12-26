package org.Tayana.ApacheKafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ApacheKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApacheKafkaApplication.class, args);
	}

}
