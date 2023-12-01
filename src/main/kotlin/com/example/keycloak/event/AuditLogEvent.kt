package com.example.keycloak.event

import com.example.keycloak.entity.AuditLogEntity

data class AuditLogEvent(
    val ip: String? = null,
    val uri: String? = null
) {
    fun toEntity(): AuditLogEntity = AuditLogEntity(
        ip = ip,
        uri = uri
    )
}
