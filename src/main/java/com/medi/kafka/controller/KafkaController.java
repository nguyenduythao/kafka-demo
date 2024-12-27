package com.medi.kafka.controller;

import com.medi.kafka.service.KafkaTopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class KafkaController {
    private final KafkaTopicService kafkaTopicService;

    @GetMapping("/list-topics")
    public Set<String> listTopics() {
        return kafkaTopicService.listTopics();
    }

    @GetMapping("/create-topic")
    public String createTopic(@RequestParam String topicName) {
        kafkaTopicService.createTopic(topicName, 1, (short) 1); // 1 partition, 1 replication factor
        return "Topic creation requested: " + topicName;
    }

    @DeleteMapping("/delete-topic/{topicName}")
    public String deleteTopic(@PathVariable String topicName) {
        return kafkaTopicService.deleteTopic(topicName);
    }
}
