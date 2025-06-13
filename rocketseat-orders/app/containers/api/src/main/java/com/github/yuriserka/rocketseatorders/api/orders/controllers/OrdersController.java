package com.github.yuriserka.rocketseatorders.api.orders.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.github.yuriserka.rocketseatorders.api.orders.dtos.CreateOrderDTO;
import com.github.yuriserka.rocketseatorders.api.orders.dtos.OrderDTO;
import com.github.yuriserka.rocketseatorders.api.orders.usecases.CreateOrderUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class OrdersController implements OrdersControllerApi {
    private final CreateOrderUseCase createOrderUseCase;

    @Override
    public OrderDTO createOrder(final CreateOrderDTO createOrderDTO) {
        return createOrderUseCase.execute(createOrderDTO);
    }
}
