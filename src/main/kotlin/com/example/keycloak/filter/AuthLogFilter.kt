package com.example.keycloak.filter

import com.example.keycloak.event.AuditLogEvent
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount
import org.springframework.context.ApplicationEventPublisher
import org.springframework.core.annotation.Order
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Order(0)
@Component
class AuthLogFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        printAuthInfo(request.userPrincipal as Authentication)
        filterChain.doFilter(request, response)

    }

    private fun printAuthInfo(authentication : Authentication) {
        val account = authentication.details as SimpleKeycloakAccount
        logger.debug("account principal : " + account.principal.toString())
        //logger.debug(account.keycloakSecurityContext.idToken.id)
        //logger.debug(account.keycloakSecurityContext.tokenString)
        //logger.debug(account.keycloakSecurityContext.token.subject)
        //logger.debug(account.keycloakSecurityContext.token.audience.toString())
        //logger.debug(account.keycloakSecurityContext.token.realmAccess.roles.toString())
        //logger.debug(account.keycloakSecurityContext.token.resourceAccess.toString())
        //logger.debug(account.keycloakSecurityContext.token.authorization?.toString())
        //logger.debug(account.keycloakSecurityContext.token.issuedFor)
        //logger.debug(account.keycloakSecurityContext.token.issuer)
        //logger.debug(account.keycloakSecurityContext.token.otherClaims.toString())
        logger.debug("preferredUsername : " + account.keycloakSecurityContext.token.preferredUsername)
        //logger.debug(account.keycloakSecurityContext.token.name)
        //logger.debug(account.keycloakSecurityContext.token.givenName)
        logger.debug("account roles : " + account.roles.toString())
    }


}

