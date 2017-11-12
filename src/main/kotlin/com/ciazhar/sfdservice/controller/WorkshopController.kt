package com.ciazhar.sfdservice.controller

import com.ciazhar.sfdservice.model.mongo.FestivalUser
import com.ciazhar.sfdservice.model.mongo.WorkshopUser
import com.ciazhar.sfdservice.service.FestivalUserService
import com.ciazhar.sfdservice.service.WorkshopUserService
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
class WorkshopController(private val service: WorkshopUserService){

    @PostMapping("/register")
    fun register(@Valid @RequestBody user: WorkshopUser) : Mono<WorkshopUser>{
        return service.registerWorkshop(user)
    }

    @GetMapping("/all")
    fun findAll() : Flux<WorkshopUser>{
        return service.findAll()
    }
}