package com.ciazhar.sfdservice.controller

import com.ciazhar.sfdservice.model.mongo.FestivalParticipant
import com.ciazhar.sfdservice.model.request.DeleteFestivalParticipantForm
import com.ciazhar.sfdservice.model.request.SubmitScoreForm
import com.ciazhar.sfdservice.service.FestivalParticipantService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.validation.Valid

/**
 * Created by ciazhar on 11/11/17.
 *
 * [ Documentation Here ]
 */

@RestController
@RequestMapping("/festival")
class FestivalParticipantController(private val service: FestivalParticipantService){

    @PostMapping("/register")
    fun register(@Valid @RequestBody festivalUser: FestivalParticipant) : Mono<FestivalParticipant> {
        return service.registerFestival(festivalUser)
    }

    @PostMapping("/submit")
    fun submitScore(@Valid @RequestBody form : SubmitScoreForm) : Mono<FestivalParticipant>{
        return service.submitScore(form)
    }
    @GetMapping("/all")
    fun findAll() : Flux<FestivalParticipant>{
        return service.findAll()
    }

    @PostMapping("/delete")
    fun delete(@Valid @RequestBody form : DeleteFestivalParticipantForm) : Mono<Void>{
        return service.delete(form)
    }
}