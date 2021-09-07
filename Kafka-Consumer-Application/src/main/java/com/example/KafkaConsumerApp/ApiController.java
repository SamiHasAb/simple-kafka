package com.example.KafkaConsumerApp;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController("/kafka/listner")
public class ApiController {
    List<String> messages = new ArrayList<>();

    User userFromTopic = null;

    @GetMapping("/consumeStringMessage")
    public List<String> consumeMsg() {
        return messages;
    }

    @GetMapping("/consumeJsonMessage")
    public User consumeJsonMessage() {
        return userFromTopic;
    }

    @KafkaListener(groupId = "groupId-1", topics = "topicname", containerFactory = "kafkaListenerContainerFactory")
    public List<String> getMsgFromTopic(String data) {
        messages.add(data);
        return messages;
    }

    @KafkaListener(groupId = "groupId-2", topics = "topicname", containerFactory = "userKafkaListenerContainerFactory")
    public User getJsonMsgFromTopic(User user) {
        userFromTopic = user;
        return userFromTopic;
    }
}
