package com.ciazhar.sfdservice.service

import com.ciazhar.sfdservice.model.mongo.WorkshopUser
import reactor.core.publisher.Mono

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */

interface WorkshopUserService{
    fun registerWorkshop(user : WorkshopUser) : Mono<WorkshopUser>
}