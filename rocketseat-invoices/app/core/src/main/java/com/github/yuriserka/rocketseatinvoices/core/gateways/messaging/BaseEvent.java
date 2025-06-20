package com.github.yuriserka.rocketseatinvoices.core.gateways.messaging;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEvent<T> {
    private Long id;
    @JsonProperty("event_id")
    private String eventId;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("event_type")
    private T type;
    private JsonNode payload;
}
