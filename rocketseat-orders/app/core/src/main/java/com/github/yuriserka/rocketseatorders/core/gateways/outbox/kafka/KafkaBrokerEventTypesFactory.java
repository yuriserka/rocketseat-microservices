package com.github.yuriserka.rocketseatorders.core.gateways.outbox.kafka;

import org.springframework.stereotype.Component;

import com.github.yuriserka.rocketseatorders.core.gateways.database.outboxevent.dtos.OutboxEventDto;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.EventTypes;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.MessageBrokerEventTypesCreator;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaBrokerEventTypesFactory implements MessageBrokerEventTypesCreator {
    public OutboxEventDto create(final EventTypes eventType, final Object... args) {
        throw new IllegalArgumentException(String.format("Event type %s is not supported", eventType));
    }
}
