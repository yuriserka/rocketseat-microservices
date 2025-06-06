package com.github.yuriserka.rocketseatorders.api.orders.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.yuriserka.rocketseatorders.api.orders.dtos.CreateOrderDTO;
import com.github.yuriserka.rocketseatorders.api.orders.dtos.OrderDTO;

import jakarta.validation.Valid;

@RequestMapping("/orders")
public interface OrdersControllerApi {
    @GetMapping("/{customerId}")
    public List<OrderDTO> getAllOrders(@PathVariable("customerId") Long customerId);

    @PostMapping
    @Validated
    public OrderDTO createOrder(@RequestBody @Valid CreateOrderDTO createOrderDTO);
}
