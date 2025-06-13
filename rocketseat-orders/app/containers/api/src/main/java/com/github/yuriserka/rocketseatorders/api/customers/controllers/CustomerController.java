package com.github.yuriserka.rocketseatorders.api.customers.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.github.yuriserka.rocketseatorders.api.customers.dtos.CreateCustomerDTO;
import com.github.yuriserka.rocketseatorders.api.customers.dtos.CustomerDTO;
import com.github.yuriserka.rocketseatorders.api.customers.usecases.CreateCustomerUseCase;
import com.github.yuriserka.rocketseatorders.api.customers.usecases.ListOrdersByCustomerUseCase;
import com.github.yuriserka.rocketseatorders.api.customers.usecases.QueryCustomerUseCase;
import com.github.yuriserka.rocketseatorders.api.orders.dtos.OrderDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CustomerController implements CustomerControllerApi {
    private final CreateCustomerUseCase createCustomerUseCase;
    private final QueryCustomerUseCase queryCustomerUseCase;
    private final ListOrdersByCustomerUseCase listOrdersByCustomer;

    @Override
    public CustomerDTO create(final CreateCustomerDTO createCustomerDTO) {
        return createCustomerUseCase.execute(createCustomerDTO);
    }

    @Override
    public CustomerDTO findBy(final String email, final Long id) {
        return queryCustomerUseCase.execute(email, id);
    }

    @Override
    public List<OrderDTO> getAllOrders(final Long customerId) {
        return listOrdersByCustomer.execute(customerId);
    }
}
