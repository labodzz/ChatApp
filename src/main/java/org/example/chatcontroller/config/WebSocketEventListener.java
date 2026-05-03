package org.example.chatcontroller.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.chatcontroller.MessageTypeEnum;
import org.example.chatcontroller.model.ChatMessage;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j

public class WebSocketEventListener {

    private final SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void EventDisconnected(SessionDisconnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());

        var sessionAttributes = accessor.getSessionAttributes();

        if (sessionAttributes != null) {
            Object usernameObj = sessionAttributes.get("username");

            if (usernameObj != null) {
                String username = usernameObj.toString();

                log.info("Disconnected " + username);

                var chatMessage = ChatMessage.builder()
                        .messageType(MessageTypeEnum.LEAVE)
                        .sender(username)
                        .build();

                messagingTemplate.convertAndSend("/topic/public", chatMessage);
            }
        }
    }
}
