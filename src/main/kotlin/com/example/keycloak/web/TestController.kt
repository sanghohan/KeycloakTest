package com.example.keycloak.web

import mu.KotlinLogging
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import java.security.Principal


@RestController
@RequestMapping("/test")
class TestController {

    private val logger = KotlinLogging.logger {}

    @RequestMapping(value = ["/permitAll"], method = [RequestMethod.GET])
    @ResponseBody
    fun permitAll(): String {
        return "누구나 접근이 가능합니다.\n"
    }

    @RequestMapping(value = ["/authenticated"], method = [RequestMethod.GET])
    @ResponseBody
    fun authenticated(@RequestHeader Authorization: String?, authentication: Authentication): String {

        return "로그인한 사람 누구나 가능합니다.\n"
    }

    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping(value = ["/user"], method = [RequestMethod.GET])
    @ResponseBody
    fun user(): String {
        return "user 가능합니다.\n"
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = ["/admin"], method = [RequestMethod.GET])
    @ResponseBody
    fun admin(@RequestHeader Authorization: String?): String {
        //logger.debug(Authorization)
        return "admin 가능합니다.\n"
    }

    @RequestMapping(value = ["/logoutSuccess"], method = [RequestMethod.GET])
    @ResponseBody
    fun logoutSuccess(): String {
            return "로그아웃 성공\n"

    }

    @RequestMapping(value = ["/accessDenied"], method = [RequestMethod.GET])
    @ResponseBody
    fun accessDenied(): String {
            return "권한이 없습니다.\n"

    }


}

