package com.github.yuriserka.rocketseatorders.core.services.customer;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.github.yuriserka.rocketseatorders.core.entities.customer.Customer;
import com.github.yuriserka.rocketseatorders.core.gateways.database.customer.CustomerDatabaseGateway;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerDatabaseGateway customerDatabaseGateway;

    public Customer createCustomer(final String email, final LocalDate birthDate) {
        log.info("Saving customer with email: {}", email);
        final var customer = customerDatabaseGateway.save(
            Customer.builder().birthDate(birthDate).email(email).build()
        );
        log.info("Customer created with email: {}: {}", email, customer);
        return customer;
    }

    public Customer findCustomerByEmail(final String email) {
        return customerDatabaseGateway.findByEmail(email);
    }

    public Customer findCustomerById(final Long id) {
        return customerDatabaseGateway.findById(id);
    }
}
