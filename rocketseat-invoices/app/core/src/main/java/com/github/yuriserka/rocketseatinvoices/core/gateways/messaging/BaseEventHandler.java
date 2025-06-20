package com.github.yuriserka.rocketseatinvoices.core.gateways.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseEventHandler<T, P, E extends BaseEvent<T>> {
    protected final ObjectMapper objectMapper;

    public abstract void handle(E event);

    public abstract P getPayload(E event);
}
