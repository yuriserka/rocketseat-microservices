package com.github.yuriserka.rocketseatorders.api.customers.controllers;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.yuriserka.rocketseatorders.api.customers.dtos.CreateCustomerDTO;
import com.github.yuriserka.rocketseatorders.api.customers.dtos.CustomerDTO;
import com.github.yuriserka.rocketseatorders.api.orders.dtos.OrderDTO;

import jakarta.validation.Valid;

@RequestMapping("/customers")
public interface CustomerControllerApi {
    @PostMapping
    @Validated
    public CustomerDTO create(@RequestBody @Valid CreateCustomerDTO createCustomerDTO);

    @GetMapping
    public CustomerDTO findBy(
        @RequestParam(name = "email", required = false) String email,
        @RequestParam(name = "id", required = false) Long id
    );

    @GetMapping("/{id}/orders")
    public List<OrderDTO> getAllOrders(@PathVariable("id") Long customerId);
}
