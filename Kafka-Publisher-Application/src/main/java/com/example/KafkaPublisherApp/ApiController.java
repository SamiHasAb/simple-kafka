package com.example.KafkaPublisherApp;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController("/kafka")
public class ApiController {

    private final KafkaTemplate<String, Object> template;

    private String topic = "topicname";

    @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable String name) {
        template.send(topic, "Hi " + name + " you are using kafka as a messaging system");
        return "Data published";
    }

    @GetMapping("/publishJson")
    public String publishMessage() {
        User user = new User(2532, "User name", new String[] { "stockholm", "solna", "house 90" });
        template.send(topic, user);
        return "Json Data published";
    }

}
