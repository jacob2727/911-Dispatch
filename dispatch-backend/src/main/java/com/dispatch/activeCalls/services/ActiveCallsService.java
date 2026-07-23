package com.dispatch.activeCalls.services;


import com.dispatch.activeCalls.dto.CallIdRequest;
import com.dispatch.activeCalls.dto.NewEventDto;
import com.dispatch.activeCalls.mapper.ActiveCallsMapper;
import com.dispatch.activeCalls.models.ActiveCallsModel;
import com.dispatch.activeCalls.repository.ActiveCallsRepo;
import com.dispatch.archiveCalls.model.ArchivedCallsModel;
import com.dispatch.archiveCalls.repository.ArchivedCallsRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Setter
public class ActiveCallsService {
    private final ActiveCallsRepo activeCallsRepo;
    private final ArchivedCallsRepo archivedCallsRepo;
    private final ActiveCallsMapper activeCallsMapper;

    @Transactional
    public NewEventDto addCall(NewEventDto newEventDto) {
        System.out.println(newEventDto.getCallType());
        ActiveCallsModel call = new ActiveCallsModel();
        call.setCallType(newEventDto.getCallType());
        call.setAddress(newEventDto.getAddress());
        call.setUrgency(newEventDto.getUrgency());
        call.setRespondingUnit(newEventDto.getRespondingUnit());
        call.setResponseMinuetsEta(newEventDto.getResponseMinutesEta());
        call.setNotes(newEventDto.getNotes());
        ActiveCallsModel savedCall = activeCallsRepo.save(call);
        return activeCallsMapper.toDto(savedCall);
    }

    @Transactional
    public List<NewEventDto> getAllActiveCalls() {
        return activeCallsRepo.findAllBy().stream()
                .map(activeCallsMapper::toDto)
                .toList();
    }

    public void removeActiveCall(CallIdRequest callIdRequest) {
        ActiveCallsModel call = activeCallsRepo.findById(callIdRequest.getId()).orElseThrow();
        ArchivedCallsModel archivedCall  = new ArchivedCallsModel();
        archivedCall.setId(call.getId());
        archivedCall.setCallType(call.getCallType());
        archivedCall.setAddress(call.getAddress());
        archivedCall.setUrgency(call.getUrgency());
        archivedCall.setRespondingUnit(call.getRespondingUnit());
        archivedCall.setNotes(call.getNotes());
        archivedCall.setCreatedAt(call.getCreatedAt());
        archivedCallsRepo.save(archivedCall);
        activeCallsRepo.deleteById(callIdRequest.getId());
    }
}
