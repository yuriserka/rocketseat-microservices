package com.github.yuriserka.rocketseatorders.core.gateways.database.order;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.yuriserka.rocketseatorders.core.entities.customer.Customer;
import com.github.yuriserka.rocketseatorders.core.entities.order.Order;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderDatabaseGateway {
    private final OrderRepository orderRepository;

    public Order createOrderToCustomer(final Customer customer, final BigDecimal amount) {
        return orderRepository.save(Order.builder().customer(customer).amount(amount).build());
    }

    public List<Order> findAllByCustomerId(final Long customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }
}
