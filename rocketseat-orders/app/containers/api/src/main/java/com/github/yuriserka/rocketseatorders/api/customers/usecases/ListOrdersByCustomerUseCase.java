package com.github.yuriserka.rocketseatorders.api.customers.usecases;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.yuriserka.rocketseatorders.api.orders.dtos.OrderDTO;
import com.github.yuriserka.rocketseatorders.api.orders.mappers.OrderMapper;
import com.github.yuriserka.rocketseatorders.core.services.customer.CustomerService;
import com.github.yuriserka.rocketseatorders.core.services.orders.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class ListOrdersByCustomerUseCase {
    private final OrderService orderService;
    private final CustomerService customerService;
    private final OrderMapper orderMapper;

    public List<OrderDTO> execute(final Long customerId) {
        final var customer = customerService.findCustomerById(customerId);
        log.info("Listing orders for customer {}", customer.getEmail());
        return orderService.findAllByCustomerId(customer.getId()).stream().map(orderMapper::toDTO).toList();
    }
}
