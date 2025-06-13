package com.github.yuriserka.rocketseatorders.api.customers.usecases;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.yuriserka.rocketseatorders.api.customers.dtos.CreateCustomerDTO;
import com.github.yuriserka.rocketseatorders.api.customers.dtos.CustomerDTO;
import com.github.yuriserka.rocketseatorders.api.customers.mappers.CustomerMapper;
import com.github.yuriserka.rocketseatorders.core.services.customer.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateCustomerUseCase {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Transactional
    public CustomerDTO execute(final CreateCustomerDTO dto) {
        final var customer = customerService.createCustomer(dto.email(), dto.birthDate());
        return customerMapper.toDto(customer);
    }
}
