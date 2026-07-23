package com.dispatch.activeCalls.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewEventDto {
    private UUID id;
    private String callType;
    private String address;
    private String urgency;
    private String respondingUnit;
    private int responseMinutesEta;
    private String notes;
}
