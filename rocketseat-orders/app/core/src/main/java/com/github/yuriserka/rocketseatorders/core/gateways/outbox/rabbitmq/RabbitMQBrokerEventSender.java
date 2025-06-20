package com.github.yuriserka.rocketseatorders.core.gateways.outbox.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.github.yuriserka.rocketseatorders.core.entities.outboxevent.OutboxEvent;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.MessageBrokerEventSender;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.dtos.EmittedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class RabbitMQBrokerEventSender implements MessageBrokerEventSender {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void emit(final OutboxEvent event) {
        final var destination = event.getDestination().split(":");
        if (destination.length < 2) {
            throw new IllegalArgumentException("Invalid destination format. Expected 'exchange:routingKey'");
        }

        final var emittedEvent = new EmittedEvent(event);
        final var exchange = destination[0];
        final var routingKey = destination[1];
        log.info("Sending message to exchange {} with routing key {}: {}", exchange, routingKey, emittedEvent);

        rabbitTemplate.convertAndSend(exchange, routingKey, emittedEvent);
    }
}
