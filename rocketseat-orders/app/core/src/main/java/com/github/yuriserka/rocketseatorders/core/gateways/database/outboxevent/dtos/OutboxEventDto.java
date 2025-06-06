package com.github.yuriserka.rocketseatorders.core.gateways.database.outboxevent.dtos;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.yuriserka.rocketseatorders.core.entities.outboxevent.MessageBrokers;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.EventTypes;

public record OutboxEventDto(
    String aggregateId,
    EventTypes eventType,
    MessageBrokers messageBroker,
    JsonNode payload
) {
    public static OutboxEventDto kafkaEvent(
        String aggregateId,
        EventTypes eventType,
        JsonNode payload
    ) {
        return new OutboxEventDto(aggregateId, eventType, MessageBrokers.KAFKA, payload);
    }

    public static OutboxEventDto rabbitMqEvent(
        String aggregateId,
        EventTypes eventType,
        JsonNode payload
    ) {
        return new OutboxEventDto(aggregateId, eventType, MessageBrokers.RABBITMQ, payload);
    }
}
