package com.github.yuriserka.rocketseatorders.api.orders.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.yuriserka.rocketseatorders.api.orders.dtos.OrderDTO;
import com.github.yuriserka.rocketseatorders.core.entities.order.Order;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {
    @Mapping(target = "customerId", source = "customer.id")
    OrderDTO toDTO(Order order);
}
