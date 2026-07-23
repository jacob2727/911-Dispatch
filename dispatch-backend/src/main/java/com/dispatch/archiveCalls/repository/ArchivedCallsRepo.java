package com.dispatch.archiveCalls.repository;

import com.dispatch.activeCalls.models.ActiveCallsModel;
import com.dispatch.archiveCalls.model.ArchivedCallsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArchivedCallsRepo extends JpaRepository<ArchivedCallsModel, UUID> {

}
