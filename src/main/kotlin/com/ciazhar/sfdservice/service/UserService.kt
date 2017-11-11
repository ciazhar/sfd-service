package com.ciazhar.sfdservice.service

import com.ciazhar.sfdservice.model.mongo.User
import reactor.core.publisher.Mono

/**
 * Created by ciazhar on 11/11/17.
 *
 * [ Documentation Here ]
 */
interface UserService{
    fun registerWorkshop(user : User) : Mono<User>
    fun registerFestival()
    fun editPoint()
}