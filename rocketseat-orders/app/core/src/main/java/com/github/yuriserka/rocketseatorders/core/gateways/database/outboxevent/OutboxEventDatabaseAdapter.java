package com.github.yuriserka.rocketseatorders.core.gateways.database.outboxevent;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.yuriserka.rocketseatorders.core.entities.outboxevent.OutboxEvent;
import com.github.yuriserka.rocketseatorders.core.gateways.database.outboxevent.dtos.OutboxEventDto;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.EventTypes;
import com.github.yuriserka.rocketseatorders.core.gateways.outbox.OutboxEventDtoFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OutboxEventDatabaseAdapter {
    private final OutboxEventRepository outboxEventsRepository;
    private final OutboxEventMapper outboxEventMapper;
    private final OutboxEventDtoFactory outboxEventDtoFactory;

    public List<OutboxEvent> findAllNonProcessed() {
        return outboxEventsRepository.findAllByProcessedFalse();
    }

    public OutboxEvent update(final OutboxEvent outboxEvent) {
        return outboxEventsRepository.save(outboxEvent);
    }

    public OutboxEvent save(final OutboxEventDto outboxEvent) {
        return outboxEventsRepository.save(outboxEventMapper.toEntity(outboxEvent));
    }

    public void saveFromEventType(final EventTypes eventType, final Object... args) {
        save(outboxEventDtoFactory.get(eventType).create(eventType, args));
    }
}
