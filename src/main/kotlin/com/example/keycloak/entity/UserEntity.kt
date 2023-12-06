package com.example.keycloak.entity

import com.example.keycloak.support.kotlinEquals
import com.example.keycloak.support.kotlinHashCode
import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0L,
    var name: String?,
    var age: Int?,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    var teamEntity : TeamEntity


) : BaseEntity() {
    companion object {
        private val properties = arrayOf(UserEntity::id, UserEntity::name, UserEntity::age)
    }

    override fun equals(other: Any?): Boolean = kotlinEquals(other, properties)
    override fun hashCode(): Int = kotlinHashCode(properties)

    override fun toString(): String {
        return "CurdEntity(id=$id, name=$name, age=$age, creageId=$createId, createDt=$createDt)"
    }
}