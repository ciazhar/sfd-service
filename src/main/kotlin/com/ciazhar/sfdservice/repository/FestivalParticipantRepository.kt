package com.ciazhar.sfdservice.repository

import com.ciazhar.sfdservice.model.mongo.FestivalParticipant
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

/**
 * Created by ciazhar on 11/11/17.
 *
 * [ Documentation Here ]
 */

interface FestivalParticipantRepository : ReactiveMongoRepository<FestivalParticipant, String>