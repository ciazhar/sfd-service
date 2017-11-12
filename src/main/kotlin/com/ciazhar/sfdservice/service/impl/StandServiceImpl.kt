package com.ciazhar.sfdservice.service.impl

import com.ciazhar.sfdservice.model.mongo.Stand
import com.ciazhar.sfdservice.repository.StandRepository
import com.ciazhar.sfdservice.service.StandService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class StandServiceImpl (private val standRepository: StandRepository) : StandService {

    override fun createStand(stand : Stand) : Mono<Stand>{
        return standRepository.save(stand)
    }
}