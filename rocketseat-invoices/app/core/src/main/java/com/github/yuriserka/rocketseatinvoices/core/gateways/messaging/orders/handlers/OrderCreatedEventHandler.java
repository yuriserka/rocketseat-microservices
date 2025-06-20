package com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders.handlers;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.BaseEvent;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders.dtos.OrderEventHandler;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders.dtos.OrdersEventTypes;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders.dtos.payloads.OrderCreatedEventPayload;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderCreatedEventHandler extends OrderEventHandler {
    OrderCreatedEventHandler(final ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    public void handle(final BaseEvent<OrdersEventTypes> event) {
        final var payload = getPayload(event);
        log.info(
            "notifying user {} that order {} generated an invoice with value {}",
            payload.getCustomer(), payload.getOrderId(), payload.getAmount()
        );
    }

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public OrderCreatedEventPayload getPayload(BaseEvent<OrdersEventTypes> event) {
        return objectMapper.treeToValue(event.getPayload(), OrderCreatedEventPayload.class);
    }
}
