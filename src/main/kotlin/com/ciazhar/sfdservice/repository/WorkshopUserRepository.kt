package com.ciazhar.sfdservice.repository

import com.ciazhar.sfdservice.model.mongo.WorkshopUser
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */
interface WorkshopUserRepository : ReactiveMongoRepository<WorkshopUser,String>