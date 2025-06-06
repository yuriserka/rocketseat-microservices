package com.github.yuriserka.rocketseatorders.core.gateways.outbox.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yuriserka.rocketseatorders.core.entities.outboxevent.OutboxEvent;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.MessageBrokerEventSender;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.dtos.EmittedEvent;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class KafkaBrokerEventSender implements MessageBrokerEventSender {
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public void emit(final OutboxEvent event) {
        final var json = objectMapper.writeValueAsString(new EmittedEvent(event));
        log.info("Sending message to topic {}: {}", event.getDestination(), json);
        kafkaTemplate.send(event.getDestination(), json);
    }
}
