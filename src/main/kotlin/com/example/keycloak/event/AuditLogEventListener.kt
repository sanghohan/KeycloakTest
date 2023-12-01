package com.example.keycloak.event

import com.example.keycloak.repository.AuditLogRepository
import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class AuditLogEventListener(
    private val auditLogRepository: AuditLogRepository
) {

    private val logger = KotlinLogging.logger {}

    @Async
    @EventListener
    fun onAuditLogEvent(event: AuditLogEvent) {
        logger.info("AuditLogEvent: $event")
        auditLogRepository.save(event.toEntity())
    }
}