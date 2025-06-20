package com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders.dtos.payloads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerOrderInformationPayload {
    private Long id;
    private String email;
}
