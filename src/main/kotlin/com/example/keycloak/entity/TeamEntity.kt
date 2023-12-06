package com.example.keycloak.entity

import com.example.keycloak.support.kotlinEquals
import com.example.keycloak.support.kotlinHashCode
import javax.persistence.*

@Entity
@Table(name = "team")
class TeamEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0L,
    var name: String? = null,

    @OneToMany(mappedBy = "teamEntity", fetch = FetchType.LAZY)
    var userEntityList: MutableList<UserEntity> = mutableListOf()

) : BaseEntity() {

    companion object {
        private val properties = arrayOf(TeamEntity::id, TeamEntity::name)
    }
    override fun equals(other: Any?): Boolean = kotlinEquals(other, properties)
    override fun hashCode(): Int = kotlinHashCode(properties)
    override fun toString(): String {
        return "TeamEntity(id=$id, name=$name, userEntityList=$userEntityList, creageId=$createId, createDt=$createDt)"
    }
}