package com.github.yuriserka.rocketseatorders.api.customers.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.github.yuriserka.rocketseatorders.api.customers.dtos.CustomerDTO;
import com.github.yuriserka.rocketseatorders.api.orders.mappers.OrderMapper;
import com.github.yuriserka.rocketseatorders.core.entities.customer.Customer;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = { OrderMapper.class })
public interface CustomerMapper {
    CustomerDTO toDto(Customer customer);
}
