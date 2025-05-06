package com.example.Demo.QCManagementTool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.Demo.QCManagementTool.Entity.AuditLog;

@RestResource(path = "auditLogs")
public interface AuditLogRepository extends JpaRepository<AuditLog, Long>{

}
