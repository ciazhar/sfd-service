package com.ciazhar.sfdservice.service

import com.ciazhar.sfdservice.model.mongo.FestivalUser
import com.ciazhar.sfdservice.model.request.SubmitScoreForm
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Created by ciazhar on 11/11/17.
 *
 * [ Documentation Here ]
 */
interface FestivalUserService {
    fun registerFestival(festivalUser: FestivalUser) : Mono<FestivalUser>
    fun submitScore(form : SubmitScoreForm) : Mono<FestivalUser>
    fun findAll() : Flux<FestivalUser>
}