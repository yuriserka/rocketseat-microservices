package com.github.yuriserka.rocketseatorders.api.orders.usecases;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.yuriserka.rocketseatorders.api.orders.dtos.CreateOrderDTO;
import com.github.yuriserka.rocketseatorders.api.orders.dtos.OrderDTO;
import com.github.yuriserka.rocketseatorders.api.orders.mappers.OrderMapper;
import com.github.yuriserka.rocketseatorders.core.services.orders.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateOrderUseCase {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Transactional
    public OrderDTO execute(final CreateOrderDTO dto) {
        final var order = orderService.createOrderToCustomer(dto.customerEmail(), dto.amount());
        return orderMapper.toDTO(order);
    }
}
