package com.github.yuriserka.rocketseatorders.core.gateways.outbox;

import com.github.yuriserka.rocketseatorders.core.gateways.database.outboxevent.dtos.OutboxEventDto;

public interface MessageBrokerEventTypesCreator {
    public OutboxEventDto create(final EventTypes eventType, final Object... args);
}
