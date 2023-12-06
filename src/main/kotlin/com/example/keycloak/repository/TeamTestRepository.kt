package com.example.keycloak.repository

import com.example.keycloak.entity.TeamEntity
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TeamTestRepository : JpaRepository<TeamEntity, Long> {

    @Query("select DISTINCT team from TeamEntity team left join fetch team.userEntityList")
    //@EntityGraph(attributePaths = ["userEntityList"], type = EntityGraph.EntityGraphType.FETCH)
    //@Query("select team from TeamEntity team left join team.userEntityList")
    fun findAllFetchJoin(): List<TeamEntity>
}