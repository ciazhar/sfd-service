package com.ciazhar.sfdservice.repository

import com.ciazhar.sfdservice.model.mongo.WorkshopParticipant
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */
interface WorkshopParticipantRepository : ReactiveMongoRepository<WorkshopParticipant,String>