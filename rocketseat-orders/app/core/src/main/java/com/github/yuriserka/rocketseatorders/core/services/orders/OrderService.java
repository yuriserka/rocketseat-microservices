package com.github.yuriserka.rocketseatorders.core.services.orders;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.yuriserka.rocketseatorders.core.entities.order.Order;
import com.github.yuriserka.rocketseatorders.core.gateways.database.order.OrderDatabaseGateway;
import com.github.yuriserka.rocketseatorders.core.gateways.database.outboxevent.OutboxEventDatabaseAdapter;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.EventTypes;
import com.github.yuriserka.rocketseatorders.core.services.customer.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderDatabaseGateway orderDatabaseGateway;
    private final OutboxEventDatabaseAdapter outboxEventDatabaseAdapter;
    private final CustomerService customerService;

    public Order createOrderToCustomer(final String customerEmail, final BigDecimal amount) {
        log.info("Creating order for customer {}", customerEmail);
        final var customer = customerService.findCustomerByEmail(customerEmail);

        final var order = orderDatabaseGateway.createOrderToCustomer(customer, amount);
        outboxEventDatabaseAdapter.saveFromEventType(EventTypes.ORDER_CREATED, order);
        
        log.info("Order created successfully to customer {}: {}", customerEmail, order);
        return order;
    }

    public List<Order> findAllByCustomerId(final Long customerId) {
        log.info("Finding all orders for customer with ID: {}", customerId);
        final var orders = orderDatabaseGateway.findAllByCustomerId(customerId);
        log.info("Found {} orders for customer with ID: {}", orders.size(), customerId);
        return orders;
    }
}
