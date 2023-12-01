package com.example.keycloak.config

import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.context.SecurityContextHolder
import java.util.*

@Configuration
class JpaAuditorAwareConfig {

    @Bean
    fun auditorAware(): AuditorAware<String> {

        return AuditorAware<String> {

            val account = SecurityContextHolder.getContext().authentication.details as SimpleKeycloakAccount
            Optional.of(account.keycloakSecurityContext.token.preferredUsername?:"system")
        }
    }
}