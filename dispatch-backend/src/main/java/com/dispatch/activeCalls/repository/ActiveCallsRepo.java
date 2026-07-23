package com.dispatch.activeCalls.repository;

import com.dispatch.activeCalls.models.ActiveCallsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ActiveCallsRepo extends JpaRepository<ActiveCallsModel, UUID> {
    List<ActiveCallsModel> findAllBy();
}
