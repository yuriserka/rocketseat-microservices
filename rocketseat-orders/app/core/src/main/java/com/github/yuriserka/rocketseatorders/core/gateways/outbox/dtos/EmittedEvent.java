package com.github.yuriserka.rocketseatorders.core.gateways.outbox.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.yuriserka.rocketseatorders.core.entities.outboxevent.OutboxEvent;

public record EmittedEvent(
        Long id,
        @JsonProperty("event_id") String eventId,
        @JsonProperty("event_type") String eventType,
        JsonNode payload,
        @JsonProperty("created_at") LocalDateTime createdAt
) {
    public EmittedEvent(final OutboxEvent event) {
        this(
            event.getId(),
            UUID.randomUUID().toString(),
            event.getEventType(),
            event.getPayload(),
            event.getCreatedAt()
        );
    }
}
