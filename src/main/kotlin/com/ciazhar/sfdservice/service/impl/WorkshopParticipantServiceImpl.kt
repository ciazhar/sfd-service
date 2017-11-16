package com.ciazhar.sfdservice.service.impl

import com.ciazhar.sfdservice.model.Score
import com.ciazhar.sfdservice.model.mongo.FestivalParticipant
import com.ciazhar.sfdservice.model.mongo.WorkshopParticipant
import com.ciazhar.sfdservice.model.request.UpdateParticipantForm
import com.ciazhar.sfdservice.repository.FestivalParticipantRepository
import com.ciazhar.sfdservice.repository.WorkshopParticipantRepository
import com.ciazhar.sfdservice.service.WorkshopParticipantService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Service
class WorkshopParticipantServiceImpl(private val workshopParticipantRepository: WorkshopParticipantRepository,
                                     private val festivalUserRepository: FestivalParticipantRepository)
    : WorkshopParticipantService {

    override fun delete(id : String): Mono<Void> {
        return workshopParticipantRepository.findById(id)
                .flatMap { workshopParticipantRepository.delete(it) }
    }

    override fun registerWorkshop(user : WorkshopParticipant) : Mono<WorkshopParticipant>{
        val score = Score(standId = "workshop",score = 100)
        val userFestival = FestivalParticipant(
                firstName = user.firstName,
                lastName = user.lastName,
                username = user.username,
                email = user.email,
                phoneNumber = user.phoneNumber,
                score = 100
        )
        userFestival.scoreList?.add(score)
        return festivalUserRepository.save(userFestival).flatMap { workshopParticipantRepository.save(user) }
    }

    override fun update(user: UpdateParticipantForm): Mono<WorkshopParticipant> {
        return workshopParticipantRepository.findById(user.id)
                .flatMap { findedUser ->
                    change(user,findedUser)
                }.flatMap { workshopParticipantRepository.save(it) }
    }

    fun change(user : UpdateParticipantForm,newUser : WorkshopParticipant) : Mono<WorkshopParticipant>{
        newUser.email = user.email
        newUser.firstName = user.firstName
        newUser.lastName = user.lastName
        newUser.phoneNumber = user.phoneNumber

        return Mono.just(newUser)
    }



    override fun findAll(): Flux<WorkshopParticipant> {
        return workshopParticipantRepository.findAll()
    }
}