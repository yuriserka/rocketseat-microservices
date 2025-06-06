package com.github.yuriserka.rocketseatorders.api.orders.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.github.yuriserka.rocketseatorders.api.orders.dtos.CreateOrderDTO;
import com.github.yuriserka.rocketseatorders.api.orders.dtos.OrderDTO;
import com.github.yuriserka.rocketseatorders.api.orders.usecases.CreateOrderUseCase;
import com.github.yuriserka.rocketseatorders.api.orders.usecases.ListOrdersByCustomer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class OrdersController implements OrdersControllerApi {
    private final CreateOrderUseCase createOrderUseCase;
    private final ListOrdersByCustomer listOrdersByCustomer;

    @Override
    public List<OrderDTO> getAllOrders(final Long customerId) {
        return listOrdersByCustomer.execute(customerId);
    }

    @Override
    public OrderDTO createOrder(final CreateOrderDTO createOrderDTO) {
        return createOrderUseCase.execute(createOrderDTO);
    }
}
