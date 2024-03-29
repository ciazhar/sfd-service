package com.ciazhar.sfdservice.service

import com.ciazhar.sfdservice.model.mongo.Stand
import com.ciazhar.sfdservice.model.request.DeleteStandForm
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */
interface StandService {
    fun createStand(stand : Stand) : Mono<Stand>
    fun findAll() : Flux<Stand>
    fun delete(form : DeleteStandForm) : Mono<Void>
}