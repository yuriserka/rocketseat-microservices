package com.github.yuriserka.rocketseatorders.core.gateways.database.order;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.yuriserka.rocketseatorders.core.entities.order.Order;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderDatabaseGateway {
    private final OrderRepository orderRepository;

    public Order createOrderToCustomer(final Long customerId, final BigDecimal amount) {
        final var order = Order.builder().customerId(customerId).amount(amount).build();
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
