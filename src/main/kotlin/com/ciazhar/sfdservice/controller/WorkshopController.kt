package com.ciazhar.sfdservice.controller

import com.ciazhar.sfdservice.model.mongo.FestivalUser
import com.ciazhar.sfdservice.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import javax.validation.Valid

/**
 * Created by ciazhar on 11/11/17.
 *
 * [ Documentation Here ]
 */

@RestController
@RequestMapping("/workshop")
class WorkshopController(private val service: UserService){

    @PostMapping("/register")
    fun register(@Valid @RequestBody festivalUser: FestivalUser) : Mono<FestivalUser>{
        return service.registerWorkshop(festivalUser)
    }
}