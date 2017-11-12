package com.ciazhar.sfdservice.service

import com.ciazhar.sfdservice.model.mongo.User
import com.ciazhar.sfdservice.model.request.SubmitScoreForm
import reactor.core.publisher.Mono

/**
 * Created by ciazhar on 11/11/17.
 *
 * [ Documentation Here ]
 */
interface UserService{
    fun registerWorkshop(user : User) : Mono<User>
    fun registerFestival(user : User) : Mono<User>
    fun submitScore(form : SubmitScoreForm) : Mono<User>
}