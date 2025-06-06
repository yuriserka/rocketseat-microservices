package com.github.yuriserka.rocketseatorders.api.orders.dtos;

import java.math.BigDecimal;

public record OrderDTO(
    Long id,
    Long customerId,
    String status,
    String createdAt,
    BigDecimal amount
) {
}
