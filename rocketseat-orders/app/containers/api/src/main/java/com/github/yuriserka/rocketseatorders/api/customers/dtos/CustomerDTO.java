package com.github.yuriserka.rocketseatorders.api.customers.dtos;

import java.util.List;

import com.github.yuriserka.rocketseatorders.api.orders.dtos.OrderDTO;

public record CustomerDTO(Long id, String email, List<OrderDTO> orders) {
}
