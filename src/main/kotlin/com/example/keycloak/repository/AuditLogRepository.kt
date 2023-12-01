package com.example.keycloak.repository

import com.example.keycloak.entity.AuditLogEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuditLogRepository : JpaRepository<AuditLogEntity, Long>