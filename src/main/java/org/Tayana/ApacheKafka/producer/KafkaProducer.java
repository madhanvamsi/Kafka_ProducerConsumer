//package org.Tayana.ApacheKafka.producer;
//
//import org.Tayana.ApacheKafka.dto.Ecommerce;
//import org.apache.kafka.clients.producer.Callback;
//import org.apache.kafka.clients.producer.RecordMetadata;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.kafka.clients.producer.RecordMetadata;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.util.concurrent.ListenableFutureCallback;
//
//@SuppressWarnings("deprecation")
//@Service
//public class KafkaProducer {
//    
//    private final KafkaTemplate<String, String> kafkaTemplate;
//    private static final String TOPIC = "topic11";
//
//    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    //this Method is used to send the data to the topic to round robin pattern partition offset value (key value we r not specifying here 
//     public void sendMessage(Ecommerce message) 
//     {
//        System.out.println("Producing message: " + message);
//        try
//        {
//        	//which converts object into string 
//        	String mss= new ObjectMapper().writeValueAsString(message);
//            kafkaTemplate.send(TOPIC, mss);
//        }
//        catch (Exception e) 
//        {
//        	System.out.println("error while producing from kafka :::" );
//        }
//        
//    }  
//    
// 
//        
//}
