package com.example.serving_web_content.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebSocketService(final SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendMessage(final String topicSuffix) {
        messagingTemplate.convertAndSend("/topic/" + topicSuffix, "GAGARIN");
    }

    @Scheduled(fixedRate = 30000) // Отправка сообщений каждые 30 секунд
    public void sendPeriodicMessages() {
        System.out.println("Sending periodic messages...");
        sendMessage("favorites");
        sendMessage("recent");
    }
}
