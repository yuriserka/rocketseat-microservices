package com.github.yuriserka.rocketseatorders.core.gateways.outbox;

import com.github.yuriserka.rocketseatorders.core.entities.outboxevent.OutboxEvent;

public interface MessageBrokerEventSender {
    void emit(final OutboxEvent message);
}
