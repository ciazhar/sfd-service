package com.ciazhar.sfdservice.service.impl

import com.ciazhar.sfdservice.exception.UserHasVisitException
import com.ciazhar.sfdservice.model.Score
import com.ciazhar.sfdservice.model.mongo.FestivalParticipant
import com.ciazhar.sfdservice.model.mongo.WorkshopParticipant
import com.ciazhar.sfdservice.model.request.DecreasePointForm
import com.ciazhar.sfdservice.model.request.DeleteFestivalParticipantForm
import com.ciazhar.sfdservice.model.request.SubmitScoreForm
import com.ciazhar.sfdservice.model.request.UpdateParticipantForm
import com.ciazhar.sfdservice.service.FestivalParticipantService
import com.ciazhar.sfdservice.repository.FestivalParticipantRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Service
class FestivalParticipantServiceImpl(private val userRepository: FestivalParticipantRepository) : FestivalParticipantService {

    override fun delete(id : String) : Mono<Void> {
        return userRepository.findById(id).flatMap { user -> userRepository.delete(user) }
    }

    override fun update(user: UpdateParticipantForm): Mono<FestivalParticipant> {
        return userRepository.findById(user.id)
                .flatMap { findedUser ->
                    change(user,findedUser)
                }.flatMap { userRepository.save(it) }
    }

    fun change(user : UpdateParticipantForm,newUser : FestivalParticipant) : Mono<FestivalParticipant>{
        newUser.email = user.email
        newUser.firstName = user.firstName
        newUser.lastName = user.lastName
        newUser.phoneNumber = user.phoneNumber

        return Mono.just(newUser)
    }

    override fun registerFestival(festivalUser: FestivalParticipant) : Mono<FestivalParticipant>{
        return userRepository.save(festivalUser)
    }

    override fun decreasePoint(form: DecreasePointForm): Mono<FestivalParticipant> {
        return userRepository.findById(form.participantId)
                .flatMap {
                    participant -> decreasePointExtend(participant,form)
                }
                .flatMap{
                    participant -> userRepository.save(participant)
                }
    }

    fun decreasePointExtend(participant : FestivalParticipant, form : DecreasePointForm) : Mono<FestivalParticipant>{
        participant.score = participant.score!! - form.point!!
        return Mono.just(participant)
    }

    override fun findAll(): Flux<FestivalParticipant> {
        return userRepository.findAll()
    }

    override fun submitScore(form : SubmitScoreForm) : Mono<FestivalParticipant> {
        return Mono.just(
            submitOrNot(userRepository.findById(form.userId).block(),form)
        )
        .flatMap {
            user ->  userRepository.save(user)
        }
    }

    fun submitOrNot(festivalUser: FestivalParticipant, form : SubmitScoreForm) : FestivalParticipant {
        if(isStandHasVisited(festivalUser,form)==false){
            addPoint(festivalUser,form)
            return festivalUser
        }
        else{
            throw UserHasVisitException()
        }
    }

    fun isStandHasVisited(festivalUser: FestivalParticipant, form : SubmitScoreForm) : Boolean? {
        return festivalUser.scoreList?.stream()?.anyMatch {
            score -> score.standId.equals(form.standId)
        }
    }

    fun addPoint(festivalUser: FestivalParticipant, form : SubmitScoreForm?){
        val score = Score(standId = form?.standId, score = form?.score)
        festivalUser.scoreList?.add(score)
        festivalUser.score = festivalUser.score!! + form?.score!!
    }
}