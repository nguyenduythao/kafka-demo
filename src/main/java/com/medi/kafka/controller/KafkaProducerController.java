package com.medi.kafka.controller;

import com.medi.kafka.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        kafkaProducerService.sendMessage(message);
        return "Message sent!";
    }

    @PostMapping("/send/topic")
    public String sendMessageToTopic(@RequestParam String topic, @RequestBody String message) {
        kafkaProducerService.sendMessage(topic, message);
        return "Message sent!";
    }
}
