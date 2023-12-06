package com.example.keycloak.repository

import com.example.keycloak.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserTestRepository : JpaRepository<UserEntity, Long> {
    fun findAllByOrderByIdDesc(): List<UserEntity>
}