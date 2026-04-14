package org.example.chatcontroller.model;

import lombok.*;
import org.example.chatcontroller.MessageTypeEnum;

import java.awt.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ChatMessage {
    private String message;
    private String sender;
    private MessageTypeEnum messageType;
}
