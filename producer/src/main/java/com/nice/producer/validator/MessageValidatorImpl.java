package com.nice.producer.validator;


import com.nice.producer.dto.MessageType;
import org.springframework.stereotype.Component;

@Component
public class MessageValidatorImpl implements MessageValidator {

    private static final String REGEX_FRACTION = "([0-9]+) *(?:/ *([1-9]+))";
    private static final String REGEX_DECIMAL = "^([0-9]+)(\\.([0-9]+))?$";
    private static final String REGEX_INTEGER = "^([0-9]+)";
    private static final String STRING_IND = "'";

    @Override
    public MessageType validate(String input) {
        if(input.replaceAll(STRING_IND, "").matches(REGEX_FRACTION)) {
            return MessageType.FRACTION;
        }
        if(input.replaceAll(STRING_IND, "").matches(REGEX_DECIMAL)) {
            return MessageType.DECIMAL;
        }
        if(input.replaceAll(STRING_IND, "").matches(REGEX_INTEGER)) {
            return MessageType.INTEGER;
        }

        return MessageType.INVALID;
    }
}
