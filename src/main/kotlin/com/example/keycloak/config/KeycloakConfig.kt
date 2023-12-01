package com.example.keycloak.config

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class KeycloakConfig {
    /*
     *  keycloak.json 대신에 Spring Boot yml 파일을 이용하도록 돕는다.
     *
     * */
    @Bean
    fun KeycloakConfigResolver(): KeycloakSpringBootConfigResolver {
        return KeycloakSpringBootConfigResolver()
    }
}