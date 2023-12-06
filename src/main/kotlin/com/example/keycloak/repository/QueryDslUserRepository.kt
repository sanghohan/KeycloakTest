package com.example.keycloak.repository

import com.example.keycloak.entity.QTeamEntity
import com.example.keycloak.entity.QUserEntity
import com.example.keycloak.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

interface QueryDslUserRepository : JpaRepository<UserEntity, Long>, QueryDslUserRepositoryCustom
interface QueryDslUserRepositoryCustom {
    fun findAllByOrderByIdDesc() : List<UserEntity>
}


class QueryDslUserRepositoryCustomImpl : QuerydslRepositorySupport(UserEntity::class.java), QueryDslUserRepositoryCustom {

    private val userTable = QUserEntity.userEntity
    private val teamTable = QTeamEntity.teamEntity

    override fun findAllByOrderByIdDesc(): List<UserEntity> {

       return from(userTable)
           .leftJoin(teamTable).fetchJoin()
           .on(userTable.id.eq(teamTable.id))
           .orderBy(userTable.id.desc())
           .fetch()
    }
}