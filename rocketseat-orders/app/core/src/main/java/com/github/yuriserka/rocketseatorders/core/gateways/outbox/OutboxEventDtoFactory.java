package com.github.yuriserka.rocketseatorders.core.gateways.outbox;

import org.springframework.stereotype.Component;

import com.github.yuriserka.rocketseatorders.core.gateways.outbox.kafka.KafkaBrokerEventTypesFactory;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.rabbitmq.RabbitMQBrokerEventTypesFactory;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OutboxEventDtoFactory {
    private final KafkaBrokerEventTypesFactory kafkaBrokerEventTypesFactory;
    private final RabbitMQBrokerEventTypesFactory rabbitMQBrokerEventTypesFactory;

    public MessageBrokerEventTypesCreator get(final EventTypes eventType) {
        final var broker = eventType.getMessageBroker();
        return switch (broker) {
            case KAFKA -> kafkaBrokerEventTypesFactory;
            case RABBITMQ -> rabbitMQBrokerEventTypesFactory;
            default -> throw new IllegalArgumentException(String.format("Broker %s is not supported", broker));
        };
    }
}
