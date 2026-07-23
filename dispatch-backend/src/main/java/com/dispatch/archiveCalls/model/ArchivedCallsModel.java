package com.dispatch.archiveCalls.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity(name = "archivedCalls")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArchivedCallsModel {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "callType")
    private String callType;

    @Column(name = "address")
    private String address;

    @Column(name = "urgency")
    private String urgency;

    @Column(name = "respondingUnit")
    private String respondingUnit;

    @Column(name = "notes")
    private String notes;


    @Column(name = "createdAt", updatable = false, nullable = false)
    private Instant createdAt;

}
