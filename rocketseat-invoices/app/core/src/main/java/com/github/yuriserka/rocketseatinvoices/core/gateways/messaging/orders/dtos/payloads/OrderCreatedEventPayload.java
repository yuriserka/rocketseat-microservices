package com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders.dtos.payloads;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCreatedEventPayload implements OrderEventsPayload {
    @JsonProperty("order_id")
    private Long orderId;
    private CustomerOrderInformationPayload customer;
    private BigDecimal amount;
}
