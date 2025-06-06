package com.github.yuriserka.rocketseatorders.api.orders.usecases;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.yuriserka.rocketseatorders.api.orders.dtos.OrderDTO;
import com.github.yuriserka.rocketseatorders.api.orders.mappers.OrderMapper;
import com.github.yuriserka.rocketseatorders.core.gateways.database.order.OrderDatabaseGateway;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class ListOrdersByCustomer {
    private final OrderDatabaseGateway orderDatabaseGateway;
    private final OrderMapper orderMapper;

    public List<OrderDTO> execute(final Long customerId) {
        log.info("Listing orders for customer {}", customerId);
        return orderDatabaseGateway.findAll()
                .stream()
                .filter(order -> order.getCustomerId().equals(customerId))
                .map(orderMapper::toDTO)
                .toList();
    }
}
