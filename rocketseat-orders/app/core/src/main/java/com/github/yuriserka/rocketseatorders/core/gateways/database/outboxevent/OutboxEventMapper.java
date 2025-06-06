package com.github.yuriserka.rocketseatorders.core.gateways.database.outboxevent;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.yuriserka.rocketseatorders.core.entities.outboxevent.OutboxEvent;
import com.github.yuriserka.rocketseatorders.core.gateways.database.outboxevent.dtos.OutboxEventDto;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OutboxEventMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "processed", constant = "false")
    @Mapping(target = "destination", expression = "java(dto.eventType().getDestination())")
    OutboxEvent toEntity(OutboxEventDto dto);
}
