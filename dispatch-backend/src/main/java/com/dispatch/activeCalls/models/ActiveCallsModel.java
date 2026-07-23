package com.dispatch.activeCalls.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "activeCalls")
public class ActiveCallsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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

    @Column(name = "responseMinuetsEta")
    private int responseMinuetsEta;

    @CreationTimestamp
    @Column(name = "createdAt", updatable = false, nullable = false)
    private Instant createdAt;

    @Column(name = "notes")
    private String notes;

}
