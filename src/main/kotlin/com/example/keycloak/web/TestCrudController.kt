package com.example.keycloak.web

import com.example.keycloak.web.service.crud.CrudTestService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/test")
class TestCrudController(
    private val crudTestService: CrudTestService
) {

    private val logger = KotlinLogging.logger {}

    @RequestMapping(value = ["/crud/get"], method = [RequestMethod.GET])
    @ResponseBody
    fun permitAll(): String {
        return crudTestService.getTest()
    }

    @RequestMapping(value = ["/crud/insert"], method = [RequestMethod.GET])
    @ResponseBody
    fun insertTest(): String {
        return crudTestService.insertTest()
    }

    @RequestMapping(value = ["/crud/update"], method = [RequestMethod.GET])
    @ResponseBody
    fun updateTest(): String {
        return crudTestService.updateTest()
    }

    @RequestMapping(value = ["/crud/delete"], method = [RequestMethod.GET])
    @ResponseBody
    fun deleteTest(): String {
        return crudTestService.deleteTest()
    }

    @RequestMapping(value = ["/crud/team/insert/{number}"], method = [RequestMethod.GET])
    @ResponseBody
    fun insertTeamTest(@PathVariable number: Int): String {
        return crudTestService.insertTeamTest(number)
    }

    @RequestMapping(value = ["/crud/team/get/{number}"], method = [RequestMethod.GET])
    @ResponseBody
    fun getTeamTest(@PathVariable number: Int): String {
        return crudTestService.selectTeamTest(number)
    }

    @RequestMapping(value = ["/crud/team/getAll"], method = [RequestMethod.GET])
    @ResponseBody
    fun getAllTeamTest(): String {
        return crudTestService.selectTeamAllTest()
    }

    @RequestMapping(value = ["/crud/team/getAllFetchJoin"], method = [RequestMethod.GET])
    @ResponseBody
    fun getAllFetchJoinTeamTest(): String {
        return crudTestService.selectTeamAllFetchJoinTest()
    }

    @RequestMapping(value = ["/crud/team/getAllQueryDsl"], method = [RequestMethod.GET])
    @ResponseBody
    fun selectTeamUseQueryDsl(): String {
        return crudTestService.selectTeamUseQueryDsl()
    }

}

