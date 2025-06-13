package com.github.yuriserka.rocketseatorders.core.gateways.database.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(final String field, final String value) {
        super(String.format("Customer not found by %s: %s", field, value));
    }
}
