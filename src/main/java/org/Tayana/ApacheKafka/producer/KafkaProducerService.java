package org.Tayana.ApacheKafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.Tayana.ApacheKafka.dto.Ecommerce;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    public final String topic1 = "topic11";

   
    public void sendMessage( Ecommerce message) {
        System.out.println("Producer sending message ::: " + message);
        try {
            // Convert the message object to a JSON string
            String mss = new ObjectMapper().writeValueAsString(message);

			// Send the message to Kafka
            CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic1, mss);

            // Handle success and failure scenarios
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    RecordMetadata metadata = result.getRecordMetadata();
                    System.out.println("Message sent successfully!");
                    System.out.println("Topic: " + metadata.topic());
                    System.out.println("Partition: " + metadata.partition());
                    System.out.println("Offset: " + metadata.offset());
                    System.out.println("Timestamp: " + metadata.timestamp());
                } else {
                    System.err.println("Message sending failed!");
                    ex.printStackTrace();
                }
            });

        } catch (JsonProcessingException e) {
            System.err.println("Failed to serialize message!");
            e.printStackTrace();
        }
    }
}
