package com.ciazhar.sfdservice.controller

import com.ciazhar.sfdservice.model.mongo.FestivalParticipant
import com.ciazhar.sfdservice.model.request.DecreasePointForm
import com.ciazhar.sfdservice.model.request.DeleteFestivalParticipantForm
import com.ciazhar.sfdservice.model.request.SubmitScoreForm
import com.ciazhar.sfdservice.model.request.UpdateParticipantForm
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

    @PostMapping("/update")
    fun update(@Valid @RequestBody user: UpdateParticipantForm) : Mono<FestivalParticipant>{
        return service.update(user)
    }


    @PostMapping("/delete/{id}")
    fun delete(@Valid @PathVariable id : String) : Mono<Void>{
        return service.delete(id)
    }

    @PostMapping("/decrease")
    fun decreasePoint(@Valid @RequestBody form : DecreasePointForm) : Mono<FestivalParticipant>{
        return service.decreasePoint(form)
    }
}