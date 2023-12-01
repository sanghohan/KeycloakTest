package com.example.keycloak.entity

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
class BaseEntity(
    @CreatedBy
    @Column(name = "create_id", nullable = false, updatable = false)
    var createId: String? = null,

    @CreatedDate
    @Column(name = "create_dt", nullable = false, updatable = false)
    var createDt: LocalDateTime = LocalDateTime.now(),

) : Serializable
