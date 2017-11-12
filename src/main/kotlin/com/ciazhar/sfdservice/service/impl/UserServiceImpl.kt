package com.ciazhar.sfdservice.service.impl

import com.ciazhar.sfdservice.exception.UserHasVisitException
import com.ciazhar.sfdservice.model.Score
import com.ciazhar.sfdservice.model.mongo.User
import com.ciazhar.sfdservice.model.request.SubmitScoreForm
import com.ciazhar.sfdservice.service.UserService
import com.ciazhar.sfdservice.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Service
class UserServiceImpl (private val userRepository: UserRepository) : UserService {

    override fun registerWorkshop(user : User) : Mono<User>{
        val score = Score(standId = "workshop",score = 100)
        user.scoreList?.add(score)
        user.score = 100
        return userRepository.save(user)
    }

    override fun registerFestival(user : User) : Mono<User>{
        return userRepository.save(user)
    }


    override fun submitScore(form : SubmitScoreForm) : Mono<User> {
        return Mono.just(
            submitOrNot(userRepository.findById(form.userId).block(),form)
        )
        .flatMap {
            user ->  userRepository.save(user)
        }
    }

    fun submitOrNot(user : User, form : SubmitScoreForm) : User {
        if(isStandHasVisited(user,form)==false){
            addPoint(user,form)
            return user
        }
        else{
            throw UserHasVisitException()
        }
    }

    fun isStandHasVisited(user : User, form : SubmitScoreForm) : Boolean? {
        return user.scoreList?.stream()?.anyMatch {
            score -> score.standId.equals(form.standId)
        }
    }

    fun addPoint(user : User, form : SubmitScoreForm?){
        val score = Score(standId = form?.standId, score = form?.score)
        user.scoreList?.add(score)
        user.score = user.score!! + form?.score!!
    }
}