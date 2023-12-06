package com.example.keycloak.web.service.crud

import com.example.keycloak.entity.TeamEntity
import com.example.keycloak.entity.UserEntity
import com.example.keycloak.repository.TeamTestRepository
import com.example.keycloak.repository.UserTestRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CrudTestService(
    private val userTestRepository: UserTestRepository,
    private val teamTestRepository: TeamTestRepository,
) {

    private val logger = KotlinLogging.logger {}

    fun getTest(): String {

        val crud = userTestRepository.findAllByOrderByIdDesc()
        return crud.toString()
    }

    fun insertTest(): String {
        userTestRepository.save(
            UserEntity(
                name = "suzi",
                age = 22,
                teamEntity = TeamEntity(id = 1L),
            )
        )

        val crud = userTestRepository.findAll()
        return crud.toString()
    }

    fun updateTest(): String {

        val findData = userTestRepository.findById(1L).orElseThrow()

        findData.age = 33

        userTestRepository.save(findData)

        logger.debug { findData.toString() }

        return findData.toString()

    }

    fun deleteTest(): String {

        val findDatas = userTestRepository.findAllByOrderByIdDesc()

        val size = findDatas.size

        logger.debug { "size : $size" }


        val deleteTarget = findDatas[size - 1]
        userTestRepository.delete(deleteTarget)

        return "delete success"
    }

    fun insertTeamTest(number : Int): String {
      val team =  teamTestRepository.save(
            TeamEntity(
                name = "team$number",
            )
        )


        return team.toString()
    }

    fun selectTeamTest(number: Int): String {
        val team =  teamTestRepository.findById(number.toLong()).orElseThrow()
        return team.toString()
    }


    fun selectTeamAllTest(): String {
        //n+1 문제 발생
        val team =  teamTestRepository.findAll()

        return team.toString()
    }

    fun selectTeamAllFetchJoinTest(): String {
        //n+1 문제 해결
        val team =  teamTestRepository.findAllFetchJoin()

        return team.toString()
    }
}