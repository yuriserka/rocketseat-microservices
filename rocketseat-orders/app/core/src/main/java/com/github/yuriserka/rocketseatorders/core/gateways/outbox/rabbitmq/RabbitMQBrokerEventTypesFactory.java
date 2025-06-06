package com.github.yuriserka.rocketseatorders.core.gateways.outbox.rabbitmq;

import org.springframework.stereotype.Component;

import com.github.yuriserka.rocketseatorders.core.gateways.database.outboxevent.dtos.OutboxEventDto;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.EventTypes;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.MessageBrokerEventTypesCreator;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.builders.OrderCreatedPayloadEventBuilder;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.builders.OutboxEventBuilder;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RabbitMQBrokerEventTypesFactory implements MessageBrokerEventTypesCreator {
    private final OrderCreatedPayloadEventBuilder orderCreatedPayloadEventBuilder;

    public OutboxEventDto create(final EventTypes eventType, final Object... args) {
        final OutboxEventBuilder<?> eventBuilder = switch (eventType) {
            case ORDER_CREATED -> orderCreatedPayloadEventBuilder;
            default -> throw new IllegalArgumentException(String.format("Event type %s is not supported", eventType));
        };
        return eventBuilder.build(args);
    }
}
