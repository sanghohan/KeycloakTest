package com.example.keycloak.repository

import com.example.keycloak.entity.TeamEntity
import com.example.keycloak.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TeamTestRepository : JpaRepository<TeamEntity, Long>