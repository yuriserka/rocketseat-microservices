package com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders.dtos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.BaseEvent;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.BaseEventHandler;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders.dtos.payloads.OrderEventsPayload;

public abstract class OrderEventHandler
        extends BaseEventHandler<OrdersEventTypes, OrderEventsPayload, BaseEvent<OrdersEventTypes>> {
    protected OrderEventHandler(final ObjectMapper objectMapper) {
        super(objectMapper);
    }
}
