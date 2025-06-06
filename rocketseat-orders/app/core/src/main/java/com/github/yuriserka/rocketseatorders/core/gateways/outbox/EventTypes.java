package com.github.yuriserka.rocketseatorders.core.gateways.outbox;

import com.github.yuriserka.rocketseatorders.core.entities.outboxevent.MessageBrokers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EventTypes {
    ORDER_CREATED("orders:orders", MessageBrokers.RABBITMQ);

    private final String destination;
    private final MessageBrokers messageBroker;
}
