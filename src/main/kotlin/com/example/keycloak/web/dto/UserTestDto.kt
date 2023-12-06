package com.example.keycloak.web.dto

import com.example.keycloak.entity.TeamEntity
import com.example.keycloak.entity.UserEntity


data class UserTestDto(
    var id: Long? = null,
    val name: String,
    val age: Int,
    val teamId: Long
) {
    fun toEntity() : UserEntity {
        return UserEntity(
            name = this.name,
            age = this.age,
            teamEntity = TeamEntity(id = this.teamId)
        )
    }

}

data class UserDto(
    var id: Long? = null,
    val name: String?,
    val age: Int?,
    val team: TeamDto?
)

data class TeamDto(
    var id: Long? = null,
    val name: String?
)