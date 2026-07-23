package com.dispatch.activeCalls.mapper;

import com.dispatch.activeCalls.dto.NewEventDto;
import com.dispatch.activeCalls.models.ActiveCallsModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-22T13:26:28-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class ActiveCallsMapperImpl implements ActiveCallsMapper {

    @Override
    public NewEventDto toDto(ActiveCallsModel activeCallsModel) {
        if ( activeCallsModel == null ) {
            return null;
        }

        NewEventDto.NewEventDtoBuilder newEventDto = NewEventDto.builder();

        if ( activeCallsModel.getId() != null ) {
            newEventDto.id( activeCallsModel.getId() );
        }
        if ( activeCallsModel.getCallType() != null ) {
            newEventDto.callType( activeCallsModel.getCallType() );
        }
        if ( activeCallsModel.getAddress() != null ) {
            newEventDto.address( activeCallsModel.getAddress() );
        }
        if ( activeCallsModel.getUrgency() != null ) {
            newEventDto.urgency( activeCallsModel.getUrgency() );
        }
        if ( activeCallsModel.getRespondingUnit() != null ) {
            newEventDto.respondingUnit( activeCallsModel.getRespondingUnit() );
        }
        if ( activeCallsModel.getNotes() != null ) {
            newEventDto.notes( activeCallsModel.getNotes() );
        }

        return newEventDto.build();
    }
}
