package com.ciazhar.sfdservice.service

import com.ciazhar.sfdservice.model.mongo.WorkshopParticipant
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */

interface WorkshopParticipantService {
    fun registerWorkshop(user : WorkshopParticipant) : Mono<WorkshopParticipant>
    fun findAll() : Flux<WorkshopParticipant>
}