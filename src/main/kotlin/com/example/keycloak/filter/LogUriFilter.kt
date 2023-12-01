package com.example.keycloak.filter

import com.example.keycloak.event.AuditLogEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Order(1)
@Component
class LogUriFilter(
    private val applicationEventPublisher: ApplicationEventPublisher,
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        AuditLogEvent(
            ip = request.remoteAddr,
            uri = request.requestURI.orEmpty()
        ).let {
            applicationEventPublisher.publishEvent(it)
        }

        filterChain.doFilter(request, response)

    }


}

