package com.nice.producer.validator;

import com.nice.producer.dto.MessageType;

public class MessageValidator {
    public static MessageType validateMessage(String message) {
        return MessageType.INVALID;
    }
}
