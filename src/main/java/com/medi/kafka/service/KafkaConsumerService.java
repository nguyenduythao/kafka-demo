package com.medi.kafka.service;

import com.medi.kafka.common.constant.KafkaTopic;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = KafkaTopic.TEST_TOPIC, groupId = "group")
    public void listenTestTopic(String message) {
        System.out.println("Received message: " + message);
    }
}
