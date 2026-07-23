package com.dispatch.activeCalls.mapper;


import com.dispatch.activeCalls.dto.NewEventDto;
import com.dispatch.activeCalls.models.ActiveCallsModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", nullValueCheckStrategy = org.mapstruct.NullValueCheckStrategy.ALWAYS)

public interface ActiveCallsMapper {
    NewEventDto toDto(ActiveCallsModel activeCallsModel);
}
