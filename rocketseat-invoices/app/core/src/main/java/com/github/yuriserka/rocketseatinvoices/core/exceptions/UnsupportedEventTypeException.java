package com.github.yuriserka.rocketseatinvoices.core.exceptions;

public class UnsupportedEventTypeException extends BusinessException {
    public UnsupportedEventTypeException(final String eventType) {
        super("Unsupported event type: " + eventType);
    }
}
