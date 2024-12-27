package com.medi.kafka.service;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.errors.TopicExistsException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaTopicService {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    public Set<String> listTopics() {
        // Create configuration for AdminClient
        Map<String, Object> config = Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        try (AdminClient adminClient = AdminClient.create(config)) {
            // Fetch list of topics
            ListTopicsResult topics = adminClient.listTopics(new ListTopicsOptions().listInternal(false));
            Set<String> topicNames = topics.names().get(); // Blocking call to get topic names
            return topicNames;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return Set.of();
        }
    }

    public void createTopic(String topicName, int partitions, short replicationFactor) {
        // Create configuration for AdminClient
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        try (AdminClient adminClient = AdminClient.create(config)) {
            NewTopic newTopic = new NewTopic(topicName, partitions, replicationFactor);
            adminClient.createTopics(java.util.Collections.singletonList(newTopic)).all().get();
            System.out.println("Topic created successfully: " + topicName);
        } catch (TopicExistsException e) {
            System.out.println("Topic already exists: " + topicName);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public String deleteTopic(String topicName) {
        Map<String, Object> config = Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        try (AdminClient adminClient = AdminClient.create(config)) {
            DeleteTopicsResult result = adminClient.deleteTopics(Collections.singletonList(topicName));
            result.all().get(); // Blocking call to wait until the topic is deleted

            return "Topic " + topicName + " deleted successfully.";
        } catch (InterruptedException | ExecutionException e) {
            return "Error occurred while deleting the topic: " + e.getMessage();
        }
    }
}
