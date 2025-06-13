package com.github.yuriserka.rocketseatorders.core.gateways.database.customer;

import org.springframework.stereotype.Component;

import com.github.yuriserka.rocketseatorders.core.entities.customer.Customer;
import com.github.yuriserka.rocketseatorders.core.gateways.database.customer.exceptions.CustomerNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerDatabaseGateway {
    public final CustomerRepository customerRepository;

    public Customer save(final Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findByEmail(final String email) {
        return customerRepository
                .findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException("email", email));
    }

    public Customer findById(final Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("id", String.valueOf(id)));
    }
}
