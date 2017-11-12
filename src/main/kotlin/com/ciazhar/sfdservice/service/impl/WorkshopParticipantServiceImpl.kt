package com.ciazhar.sfdservice.service.impl

import com.ciazhar.sfdservice.model.Score
import com.ciazhar.sfdservice.model.mongo.FestivalParticipant
import com.ciazhar.sfdservice.model.mongo.WorkshopParticipant
import com.ciazhar.sfdservice.model.request.DeleteWorkshopParticipantForm
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

    override fun delete(form: DeleteWorkshopParticipantForm): Mono<Void> {
        return workshopParticipantRepository.findById(form.participantId)
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

    override fun findAll(): Flux<WorkshopParticipant> {
        return workshopParticipantRepository.findAll()
    }
}