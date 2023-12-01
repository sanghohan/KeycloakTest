package com.example.keycloak

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class KeycloakApplication

fun main(args: Array<String>) {
    runApplication<KeycloakApplication>(*args)
}
