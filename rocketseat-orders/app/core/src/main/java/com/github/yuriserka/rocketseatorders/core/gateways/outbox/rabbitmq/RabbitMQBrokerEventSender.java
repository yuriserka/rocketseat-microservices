package com.github.yuriserka.rocketseatorders.core.gateways.outbox.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

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
public class RabbitMQBrokerEventSender implements MessageBrokerEventSender {
    private final ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public void emit(final OutboxEvent event) {
        final var destination = event.getDestination().split(":");
        if (destination.length < 2) {
            throw new IllegalArgumentException("Invalid destination format. Expected 'exchange:routingKey'");
        }

        final var json = objectMapper.writeValueAsString(new EmittedEvent(event));
        final var exchange = destination[0];
        final var routingKey = destination[1];
        log.info("Sending message to exchange {} with routing key {}: {}", exchange, routingKey, json);

        rabbitTemplate.convertAndSend(exchange, routingKey, json);
    }
}
