package com.github.yuriserka.rocketseatorders.core.gateways.database.customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.yuriserka.rocketseatorders.core.entities.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
