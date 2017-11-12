package com.ciazhar.sfdservice.service.impl

import com.ciazhar.sfdservice.model.Score
import com.ciazhar.sfdservice.model.mongo.FestivalUser
import com.ciazhar.sfdservice.model.mongo.WorkshopUser
import com.ciazhar.sfdservice.repository.FestivalUserRepository
import com.ciazhar.sfdservice.repository.WorkshopUserRepository
import com.ciazhar.sfdservice.service.FestivalUserService
import com.ciazhar.sfdservice.service.WorkshopUserService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class WorkshopUserServiceImpl (private val workshopUserRepository: WorkshopUserRepository,
                               private val festivalUserRepository: FestivalUserRepository)
    : WorkshopUserService {
    override fun registerWorkshop(user : WorkshopUser) : Mono<WorkshopUser>{
        val score = Score(standId = "workshop",score = 100)
        val userFestival = FestivalUser(
                firstName = user.firstName,
                lastName = user.lastName,
                username = user.username,
                email = user.email,
                phoneNumber = user.phoneNumber,
                score = 100
        )
        userFestival.scoreList?.add(score)
        return festivalUserRepository.save(userFestival).flatMap { workshopUserRepository.save(user) }
    }
}