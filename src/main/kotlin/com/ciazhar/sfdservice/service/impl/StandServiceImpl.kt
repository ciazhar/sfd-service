package com.ciazhar.sfdservice.service.impl

import com.ciazhar.sfdservice.model.mongo.Stand
import com.ciazhar.sfdservice.model.request.DeleteStandForm
import com.ciazhar.sfdservice.repository.StandRepository
import com.ciazhar.sfdservice.service.StandService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Service
class StandServiceImpl (private val standRepository: StandRepository) : StandService {

    override fun findAll(): Flux<Stand> {
        return standRepository.findAll()
    }

    override fun delete(form: DeleteStandForm): Mono<Void> {
        return standRepository.findById(form.standId).flatMap { standRepository.delete(it) }
    }

    override fun createStand(stand : Stand) : Mono<Stand>{
        return standRepository.save(stand)
    }
}