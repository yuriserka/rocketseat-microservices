package com.github.yuriserka.rocketseatorders.core.gateways.outbox.dtos.order;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderCreatedPayloadDTO(
    @JsonProperty("order_id") Long orderId,
    CustomerOrderInformationDTO customer,
    BigDecimal amount
) {
}
