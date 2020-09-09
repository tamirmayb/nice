package com.nice.producer.validator;

import com.nice.producer.dto.MessageType;

public interface MessageValidator {
    MessageType validate(String input);
}
