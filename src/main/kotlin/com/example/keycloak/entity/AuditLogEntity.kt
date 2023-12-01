package com.example.keycloak.entity

import com.example.keycloak.support.kotlinEquals
import com.example.keycloak.support.kotlinHashCode
import javax.persistence.*


@Entity
@Table(name = "audit_log")
class AuditLogEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0L,

    val ip: String? = null,
    val uri: String? = null

) : BaseEntity() {

    companion object {
        private val properties = arrayOf(AuditLogEntity::id, AuditLogEntity::ip, AuditLogEntity::uri)
    }

    override fun equals(other: Any?): Boolean = kotlinEquals(other, properties)
    override fun hashCode(): Int = kotlinHashCode(properties)
}