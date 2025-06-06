package com.github.yuriserka.rocketseatorders.scheduler.jobs;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.yuriserka.rocketseatorders.core.gateways.database.outboxevent.OutboxEventDatabaseAdapter;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.OutboxEventSenderFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProcessOutboxScheduler {
    private final OutboxEventDatabaseAdapter outboxEventDatabaseAdapter;
    private final OutboxEventSenderFactory outboxEventSenderFactory;

    @Scheduled(fixedRate = 60, timeUnit = TimeUnit.SECONDS)
    public void process() {
        final var eventsToProcess = outboxEventDatabaseAdapter.findAllNonProcessed();
        if (eventsToProcess.isEmpty()) {
            log.info("No outbox events to process");
            return;
        }

        eventsToProcess.forEach(outboxEvent -> {
            log.info("Processing outbox event {}", outboxEvent);
            outboxEventSenderFactory.create(outboxEvent).emit(outboxEvent);
            outboxEvent.markAsProcessed();
            outboxEventDatabaseAdapter.update(outboxEvent);
        });
    }
}
