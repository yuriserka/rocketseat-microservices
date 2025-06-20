package com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders;

import org.springframework.stereotype.Component;

import com.github.yuriserka.rocketseatinvoices.core.exceptions.UnsupportedEventTypeException;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.BaseEvent;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.BaseEventHandler;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders.dtos.OrdersEventTypes;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders.dtos.payloads.OrderEventsPayload;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders.handlers.OrderCreatedEventHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderEventHandlerFactory {
    private final OrderCreatedEventHandler orderCreatedEventHandler;

    public BaseEventHandler<OrdersEventTypes, OrderEventsPayload, BaseEvent<OrdersEventTypes>> createHandler(
        final OrdersEventTypes eventType
    ) {
        log.info("Creating handler for event type: {}", eventType);
        return switch (eventType) {
            case ORDER_CREATED -> orderCreatedEventHandler;
            default -> throw new UnsupportedEventTypeException(eventType.name());
        };
    }
}
