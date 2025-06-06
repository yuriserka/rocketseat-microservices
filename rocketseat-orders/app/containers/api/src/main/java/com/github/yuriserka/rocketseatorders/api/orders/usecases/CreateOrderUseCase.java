package com.github.yuriserka.rocketseatorders.api.orders.usecases;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.yuriserka.rocketseatorders.api.orders.dtos.CreateOrderDTO;
import com.github.yuriserka.rocketseatorders.api.orders.dtos.OrderDTO;
import com.github.yuriserka.rocketseatorders.api.orders.mappers.OrderMapper;
import com.github.yuriserka.rocketseatorders.core.gateways.database.order.OrderDatabaseGateway;
import com.github.yuriserka.rocketseatorders.core.gateways.database.outboxevent.OutboxEventDatabaseAdapter;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.EventTypes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateOrderUseCase {
    private final OrderDatabaseGateway orderDatabaseGateway;
    private final OutboxEventDatabaseAdapter outboxEventDatabaseAdapter;
    private final OrderMapper orderMapper;

    @Transactional
    public OrderDTO execute(final CreateOrderDTO dto) {
        log.info("Creating order {} for customer {}", dto, dto.customerId());
        final var order = orderDatabaseGateway.createOrderToCustomer(dto.customerId(), dto.amount());
        outboxEventDatabaseAdapter.saveFromEventType(EventTypes.ORDER_CREATED, order);
        log.info("Order created successfully: {}", order);
        return orderMapper.toDTO(order);
    }
}
