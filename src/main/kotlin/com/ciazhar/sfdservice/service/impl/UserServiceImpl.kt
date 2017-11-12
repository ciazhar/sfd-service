package com.ciazhar.sfdservice.service.impl

import com.ciazhar.sfdservice.model.Score
import com.ciazhar.sfdservice.model.mongo.User
import com.ciazhar.sfdservice.service.UserService
import com.ciazhar.sfdservice.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserServiceImpl (private val userRepository: UserRepository): UserService {
    override fun registerWorkshop(user : User) : Mono<User>{
        val score = Score(scoreName = "workshop",score = 100)
        user.scoreList?.add(score)
        user.score = 100
        return userRepository.save(user)
    }

    override fun registerFestival(user : User) : Mono<User>{
        return userRepository.save(user)
    }

    override fun editPoint() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}