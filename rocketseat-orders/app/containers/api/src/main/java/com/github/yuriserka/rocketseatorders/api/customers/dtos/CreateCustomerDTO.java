package com.github.yuriserka.rocketseatorders.api.customers.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CreateCustomerDTO(
    @NotNull @Email String email,
    @NotNull @JsonProperty("birth_date") LocalDate birthDate
) {
}
