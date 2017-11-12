package com.ciazhar.sfdservice.controller

import com.ciazhar.sfdservice.model.mongo.Stand
import com.ciazhar.sfdservice.service.StandService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import javax.validation.Valid

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */

@RestController
@RequestMapping("/stand")
class StandController(private val service : StandService){

    @PostMapping("/create")
    fun create(@Valid @RequestBody stand : Stand) : Mono<Stand>{
        return service.createStand(stand)
    }
}