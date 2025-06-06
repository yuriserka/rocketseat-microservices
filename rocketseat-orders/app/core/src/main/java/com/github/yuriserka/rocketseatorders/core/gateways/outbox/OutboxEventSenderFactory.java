package com.github.yuriserka.rocketseatorders.core.gateways.outbox;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yuriserka.rocketseatorders.core.entities.outboxevent.OutboxEvent;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.kafka.KafkaBrokerEventSender;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.rabbitmq.RabbitMQBrokerEventSender;

@Component
public class OutboxEventSenderFactory {
    private KafkaBrokerEventSender kafkaBrokerEventSender;
    private RabbitMQBrokerEventSender rabbitMqBrokerEventSender;

    public OutboxEventSenderFactory(
        final ObjectMapper objectMapper,
        final KafkaTemplate<String, String> kafkaTemplate,
        final RabbitTemplate  rabbitTemplate
    ) {
        this.kafkaBrokerEventSender = new KafkaBrokerEventSender(objectMapper, kafkaTemplate);
        this.rabbitMqBrokerEventSender = new RabbitMQBrokerEventSender(objectMapper, rabbitTemplate);
    }

    public MessageBrokerEventSender create(final OutboxEvent outboxEvent) {
        final var broker = outboxEvent.getMessageBroker();
        return switch (broker) {
            case KAFKA -> kafkaBrokerEventSender;
            case RABBITMQ -> rabbitMqBrokerEventSender;
            default -> throw new IllegalArgumentException(String.format("Broker %s is not supported", broker));
        };
    }
}
