package com.github.yuriserka.rocketseatorders.core.gateways.outbox.builders;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yuriserka.rocketseatorders.core.entities.order.Order;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.EventTypes;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.dtos.order.CustomerOrderInformationDTO;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.dtos.order.OrderCreatedPayloadDTO;

@Component
public class OrderCreatedPayloadEventBuilder extends OutboxEventBuilder<OrderCreatedPayloadDTO> {
    static final EventTypes EVENT_TYPE = EventTypes.ORDER_CREATED;

    public OrderCreatedPayloadEventBuilder(final ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    protected OrderCreatedPayloadDTO createPayload(final Object... args) {
        final var order = (Order) args[0];
        return new OrderCreatedPayloadDTO(
            order.getId(),
            new CustomerOrderInformationDTO(order.getCustomerId()),
            order.getAmount()
        );
    }

    @Override
    protected String getAggregateId(final OrderCreatedPayloadDTO payload) {
        return payload.orderId().toString();
    }

    @Override
    protected EventTypes getEventType() {
        return EVENT_TYPE;
    }
}
