package com.ciazhar.sfdservice.service

import com.ciazhar.sfdservice.model.mongo.FestivalParticipant
import com.ciazhar.sfdservice.model.request.DecreasePointForm
import com.ciazhar.sfdservice.model.request.DeleteFestivalParticipantForm
import com.ciazhar.sfdservice.model.request.SubmitScoreForm
import com.ciazhar.sfdservice.model.request.UpdateParticipantForm
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Created by ciazhar on 11/11/17.
 *
 * [ Documentation Here ]
 */
interface FestivalParticipantService {
    fun registerFestival(festivalUser: FestivalParticipant) : Mono<FestivalParticipant>
    fun submitScore(form : SubmitScoreForm) : Mono<FestivalParticipant>
    fun findAll() : Flux<FestivalParticipant>
    fun update(user : UpdateParticipantForm):Mono<FestivalParticipant>
    fun delete(id : String) : Mono<Void>
    fun decreasePoint(form : DecreasePointForm) : Mono<FestivalParticipant>
}