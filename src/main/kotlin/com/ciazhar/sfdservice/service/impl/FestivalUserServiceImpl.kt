package com.ciazhar.sfdservice.service.impl

import com.ciazhar.sfdservice.exception.UserHasVisitException
import com.ciazhar.sfdservice.model.Score
import com.ciazhar.sfdservice.model.mongo.FestivalUser
import com.ciazhar.sfdservice.model.request.SubmitScoreForm
import com.ciazhar.sfdservice.service.FestivalUserService
import com.ciazhar.sfdservice.repository.FestivalUserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Service
class FestivalUserServiceImpl(private val userRepository: FestivalUserRepository) : FestivalUserService {

    override fun registerFestival(festivalUser: FestivalUser) : Mono<FestivalUser>{
        return userRepository.save(festivalUser)
    }

    override fun findAll(): Flux<FestivalUser> {
        return userRepository.findAll()
    }

    override fun submitScore(form : SubmitScoreForm) : Mono<FestivalUser> {
        return Mono.just(
            submitOrNot(userRepository.findById(form.userId).block(),form)
        )
        .flatMap {
            user ->  userRepository.save(user)
        }
    }

    fun submitOrNot(festivalUser: FestivalUser, form : SubmitScoreForm) : FestivalUser {
        if(isStandHasVisited(festivalUser,form)==false){
            addPoint(festivalUser,form)
            return festivalUser
        }
        else{
            throw UserHasVisitException()
        }
    }

    fun isStandHasVisited(festivalUser: FestivalUser, form : SubmitScoreForm) : Boolean? {
        return festivalUser.scoreList?.stream()?.anyMatch {
            score -> score.standId.equals(form.standId)
        }
    }

    fun addPoint(festivalUser: FestivalUser, form : SubmitScoreForm?){
        val score = Score(standId = form?.standId, score = form?.score)
        festivalUser.scoreList?.add(score)
        festivalUser.score = festivalUser.score!! + form?.score!!
    }
}