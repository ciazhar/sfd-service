package com.ciazhar.sfdservice.service.impl

import com.ciazhar.sfdservice.exception.UserHasVisitException
import com.ciazhar.sfdservice.model.Score
import com.ciazhar.sfdservice.model.mongo.FestivalUser
import com.ciazhar.sfdservice.model.request.SubmitScoreForm
import com.ciazhar.sfdservice.service.UserService
import com.ciazhar.sfdservice.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Service
class UserServiceImpl (private val userRepository: UserRepository) : UserService {

    override fun registerWorkshop(festivalUser: FestivalUser) : Mono<FestivalUser>{
        val score = Score(standId = "workshop",score = 100)
        festivalUser.scoreList?.add(score)
        festivalUser.score = 100
        return userRepository.save(festivalUser)
    }

    override fun registerFestival(festivalUser: FestivalUser) : Mono<FestivalUser>{
        return userRepository.save(festivalUser)
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