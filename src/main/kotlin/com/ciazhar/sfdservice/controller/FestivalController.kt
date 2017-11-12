package com.ciazhar.sfdservice.controller

import com.ciazhar.sfdservice.model.mongo.User
import com.ciazhar.sfdservice.model.request.SubmitScoreForm
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
@RequestMapping("/festival")
class FestivalController(private val service: UserService){

    @PostMapping("/register")
    fun register(@Valid @RequestBody user: User) : Mono<User> {
        return service.registerFestival(user)
    }

    @PostMapping("/submit")
    fun submitScore(@Valid @RequestBody form : SubmitScoreForm) : Mono<User>{
        return service.submitScore(form)
    }
}