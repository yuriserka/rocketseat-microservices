package com.github.yuriserka.rocketseatorders.api.orders.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateOrderDTO(
    @NotNull @JsonProperty("customer_email") String customerEmail,
    @NotNull @Min(0) @Max(100) @JsonProperty("amount") BigDecimal amount
) {
}
