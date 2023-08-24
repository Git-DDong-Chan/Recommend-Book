package com.example.rb.chatgpt;

import com.example.rb.recommend.Input;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

@Service
@RequiredArgsConstructor
public class ChatGptMessageService {
    private static final String TOPIC = "chatgpt";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(Input input) {

        JSONObject msgData = new JSONObject();
        msgData.put("id", input.getId());
        msgData.put("content", input.getContent());

        JSONObject msgObj = new JSONObject();
        msgObj.put("command", "request_chatgpt");
        msgObj.put("data", msgData);

        String msg = msgObj.toString(4);
        kafkaTemplate.send(TOPIC, msg);
    }
}