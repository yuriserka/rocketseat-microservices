package com.github.yuriserka.rocketseatorders.api.customers.usecases;

import org.springframework.stereotype.Component;

import com.github.yuriserka.rocketseatorders.api.customers.dtos.CustomerDTO;
import com.github.yuriserka.rocketseatorders.api.customers.mappers.CustomerMapper;
import com.github.yuriserka.rocketseatorders.core.services.customer.CustomerService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class QueryCustomerUseCase {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerDTO execute(final String email, final Long id) {
        validateInput(email, id);

        return customerMapper.toDto(
            email != null
                ? customerService.findCustomerByEmail(email)
                : customerService.findCustomerById(id)
        );
    }

    private void validateInput(final String email, final Long id) {
        if (email == null && id == null) {
            throw new IllegalArgumentException("At least one of email or id must be provided");
        }
        if (email != null && id != null) {
            throw new IllegalArgumentException("Only one of email or id can be provided");
        }
    }
}
