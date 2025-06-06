package com.github.yuriserka.rocketseatorders.api.orders.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.github.yuriserka.rocketseatorders.api.orders.dtos.OrderDTO;
import com.github.yuriserka.rocketseatorders.core.entities.order.Order;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {
    OrderDTO toDTO(Order order);
}
