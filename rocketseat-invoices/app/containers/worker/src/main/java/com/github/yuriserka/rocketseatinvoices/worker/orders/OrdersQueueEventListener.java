package com.github.yuriserka.rocketseatinvoices.worker.orders;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.BaseEvent;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders.OrderEventHandlerFactory;
import com.github.yuriserka.rocketseatinvoices.core.gateways.messaging.orders.dtos.OrdersEventTypes;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrdersQueueEventListener {
    private final OrderEventHandlerFactory orderEventHandlerFactory;

    @RabbitListener(queues = { "${rocketseatinvoices.rabbitmq.orders.queue}" })
    @WithSpan
    public void listen(@Payload BaseEvent<OrdersEventTypes> event) {
        log.info("Starting to consume event: {}", event);
        final var handler = orderEventHandlerFactory.createHandler(event.getType());
        handler.handle(event);
        log.info("Finished consuming event: {}", event);
    }
}
