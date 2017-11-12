package com.ciazhar.sfdservice.controller

import com.ciazhar.sfdservice.model.mongo.WorkshopParticipant
import com.ciazhar.sfdservice.model.request.DeleteWorkshopParticipantForm
import com.ciazhar.sfdservice.service.WorkshopParticipantService
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
@RequestMapping("/workshop")
class WorkshopParticipantController(private val service: WorkshopParticipantService){

    @PostMapping("/register")
    fun register(@Valid @RequestBody user: WorkshopParticipant) : Mono<WorkshopParticipant>{
        return service.registerWorkshop(user)
    }

    @GetMapping("/all")
    fun findAll() : Flux<WorkshopParticipant>{
        return service.findAll()
    }

    @PostMapping("/delete")
    fun delete(@Valid @RequestBody form : DeleteWorkshopParticipantForm) : Mono<Void>{
        return service.delete(form)
    }
}